package RepairCompany;

public class Worker
{
    private String name;
    private Order assignedOrder;
    private boolean isWorking;
    private boolean isFired;

    public Worker(String name, Order order, boolean isWorking)
    {
        this.name = name;
        this.assignedOrder = order;
        this.isWorking = isWorking;
        this.isFired = false; // Non puoi essere stato licenziato ancor prima di entrare in azienda
    }

    public boolean isFired() {
        return isFired;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public String getName() {
        return name;
    }

    public Order getOrder() {
        return assignedOrder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrder(Order order)
    {
        if (!isFired())
        {
            this.assignedOrder = order;
            if (this.assignedOrder != null)
                isWorking = true;
        }
    }

    public void setWorking(boolean working)
    {
        if (!isFired())
        {
            isWorking = working;
            if (!this.isWorking)
                setOrder(null);
        }
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }
}
