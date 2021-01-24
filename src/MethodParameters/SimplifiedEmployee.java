package MethodParameters;

//Simplified Employee Class
class SimplifiedEmployee {
    private String name;
    private double salary;

    public SimplifiedEmployee(String n, double s)
    {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}
