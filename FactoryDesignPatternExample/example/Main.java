interface Employee{
    int getSalary();
}

class WebDeveloper implements Employee{
    public int getSalary(){
        System.out.println("Web developer salary ...... ");
        return 50000;
    }
}

class AndroidDeveloper implements Employee{
    public int getSalary(){
        System.out.println("Android developer salary ...... ");
        return 100000;
    }
}

class EmployeeFactory{
    public static Employee getEmployee(String employeeType) {
        if(employeeType.equals("web")) {
            return new WebDeveloper();
        }
        else if(employeeType.equals("android")) {
            return new AndroidDeveloper();
        }
        else {
            System.out.println("Invalid employee type");
            return null;
        }
    }
}


public class Main{
    public static void main(String[] args) {
        Employee web = EmployeeFactory.getEmployee("web");
        System.out.println(web.getSalary());

        Employee and = EmployeeFactory.getEmployee("android");
        System.out.println(and.getSalary());
    }
}