package RepairCompany;

public class RepairCompany
{
    private Order[] jobs;
    private Worker[] workers;
    private int workersNum;
    private int jobsNum;

    public RepairCompany()
    {
        jobs = new Order[100];
        workersNum = 1;
        workers = new Worker[workersNum];

        for (Order job : jobs)
            if (job != null)
                jobsNum++;
    }

    public void addJob(String address, int priority)
    {
        jobsNum++;
        if (jobs.length >= jobsNum)
        {
            jobs[jobsNum-1] = new Order(address,priority);
        }
    }

    public Order[] pendingJobs()
    {
        Order[] pending = new Order[100];

        int counter = 0;
        for (int j = 0 ; j < jobs.length ; j++)
        {
            for (Worker worker : workers)
            {
                if (worker.getOrder() == jobs[j]) // Se i lavoratori hanno il lavoro jobs[j] assegnato
                {
                    counter++;
                }
            }
            if (counter == 0) // Se il lavoro non è stato assegnato a nessuno è in attesa
                pending[j] = jobs[j];
        }

        return pending;
    }

    public Order nextOrderByPriority()
    {
        Order nextOrder = null;

        int maxPriorityJob = 0;

        for (int i = 0 ; i < jobsNum ; i++)
        {
            if (jobs[i].getPriority() > maxPriorityJob)
            {
                maxPriorityJob = jobs[i].getPriority();
                nextOrder = jobs[i];
            }
        }
        return nextOrder;
    }

    public void jobToWorker()
    {
        for (Worker worker : workers)
        {
            if (!worker.isWorking() && pendingJobs().length != 0) // Se il lavoratore non sta lavorando e ci sono lavori da fare
            {
                worker.setOrder(nextOrderByPriority());
                return;
            }
        }
    }

    public void jobDone(String workerName) // Se un lavoro viene assegnato si presuppone che venga risolto (quanta fiducia!)
    {
        if (workersNum!= 0)
        {
            for (Worker worker : workers)
            {
                if (worker.getName().equals(workerName))
                {
                    worker.getOrder().setProblemSolved(true);
                    worker.setWorking(false);
                }
            }
        }
    }

    public void addWorker(String workerName)
    {
        if (workers.length >= workersNum)
        {
            workers[workersNum-1] = new Worker(workerName,null, false);
            workersNum++;
        }
    }

    public void removeWorkers(String[] firedWorkerNames)
    {
        if (workersNum == 0) // Se non ci sono lavoratori, puoi licenziare solo te stesso
            return;

        for (Worker worker : workers)
            if (!worker.isWorking()) // Se non sta ancora lavorando
                for (String name : firedWorkerNames)
                    if (worker.getName().equals(name)) // Ed è nella lista nera del capo
                    {
                        worker.setFired(true);
                        workersNum--;
                    }
    }

    public static void main(String[] args)
    {
        RepairCompany rc = new RepairCompany();

        rc.addJob("Via dei topi 9", 1);
        rc.addJob("Via dei maiali 2", 2);
        rc.addJob("Via dei conigli 3", 1);
        rc.addJob("Via degli scoiattoli 21", 3);
        rc.addJob("Via delle rane 93", 1);
        rc.addJob("Via dei nerd 0", 2);

        rc.addWorker("Marcantonio del Capo");
        rc.addWorker("Gennarino del Colle");
        rc.addWorker("Genoveffa Indignata");
        rc.addWorker("Gertrude de Pazzi");

        System.out.println("The repairs still to be done are: " );
        for (Order pend : rc.pendingJobs())
        {
            if (pend != null)
                System.out.println(pend.getAddress());
        }

        System.out.println("One of our workers will take care of the most urgent request: " + rc.nextOrderByPriority().getAddress());
        rc.jobToWorker();

        for (Worker worker : rc.workers)
        {
            if (worker.isWorking())
            {
                rc.jobDone(worker.getName());
            }
        }

        System.out.println("The boss is in a bad mood today, I think he's going to fire someone randomly");

        for (Worker worker : rc.workers)
        {
            if (!worker.isWorking())
            {
                rc.removeWorkers(new String[]{worker.getName()});
                System.out.println(worker.getName() + " left us today. Who will be the next?!");
                return;
            }
        }
    }
}