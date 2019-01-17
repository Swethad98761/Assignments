package Incremental.Incremental3;

interface Organisation{
    void organisationName();
    void organisationAddress();
}

interface Employee {
    void employeeId();
    void employeeName();
}

interface Team {
    void teamId();
    void teamName();
}

interface EmployeeDetails extends Organisation,Employee,Team {
    void salary();
}

class ConcreteClass {
    void concreteClassMethod(){
        System.out.println("This is ConcreteClass method");
    }
}

class MainClass extends ConcreteClass implements EmployeeDetails {
    public void organisationName(){
        System.out.println("Organisation: Google");
    }

    public void organisationAddress(){
        System.out.println("Address: Gachibowli,Hyderabad");
    }

    public void employeeId() {
        System.out.println("EmployeeId : 101");

    }
    public void employeeName(){
        System.out.println("EmployeeName: John");
    }

    public void teamId(){
        System.out.println("TeamId: 5");
    }
    public void teamName(){
        System.out.println("TeamName: ABC");
    }

    public void salary(){
        System.out.println("Salary: 1 Lakh per Annum");
    }

    void organisationInterfaceMethod(Organisation organisation){
        organisation.organisationName();
        organisation.organisationAddress();
    }

    void employeeInterfaceMethod(Employee employee){
        employee.employeeId();
        employee.employeeName();
    }

    void teamInterfaceMethod(Team team){
        team.teamId();
        team.teamName();
    }

    void employeeDetailsInterfaceMethod(EmployeeDetails employeeDetails){
        employeeDetails.salary();
    }
}

class ImplementingInterfaces{
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.organisationInterfaceMethod(mainClass);
        mainClass.employeeInterfaceMethod(mainClass);
        mainClass.teamInterfaceMethod(mainClass);
        mainClass.employeeDetailsInterfaceMethod(mainClass);
    }
}

