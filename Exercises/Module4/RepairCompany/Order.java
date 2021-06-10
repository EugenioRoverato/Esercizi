package RepairCompany;

public class Order
{
    private String address;
    private int priority;
    private boolean problemSolved = false;

    public Order(String address, int priority)
    {
        this.address = address;
        this.priority = priority;
    }

    public boolean isProblemSolved() {
        return problemSolved;
    }

    public String getAddress() {
        return address;
    }

    public int getPriority() {
        return priority;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setProblemSolved(boolean problemSolved)
    {
        this.problemSolved = problemSolved;
        if (this.problemSolved)
            print();
    }

    public void print()
    {
        System.out.println("__________________________________________");
        System.out.println("| SOLVED | Address: " + getAddress() + " |");
        System.out.println("__________________________________________");
    }
}