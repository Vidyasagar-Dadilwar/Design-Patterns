// interface Employee{
//     int salary();
// }

// class AndroidDeveloper implements Employee{
//     public int salary(){
//         System.out.println("Getting android developer salary .......");
//         return 50000;
//     }
// }

// class WebDeveloper implements Employee {
//     public int salary() {
//         System.out.println("Getting web developer salary .......");
//         return 40000;
//     }
// }

// class EmployeeFactory{
//     public static Employee getEmployee(String employeeType) {
//         if (employeeType.trim().equalsIgnoreCase("Android Developer")){
//             return new AndroidDeveloper();
//         }
//         else if(employeeType.trim().equalsIgnoreCase("Web Developer")){
//             return new WebDeveloper();
//         }
//         else{
//             return null;
//         }
//     }
// }

public class Client{
    public static void main(String[] args) {
        Employee e1 = EmployeeFactory.getEmployee("Android Developer");
        System.out.println("Salary: "+e1.salary());
        
        Employee e2 = EmployeeFactory.getEmployee("Web Developer");
        System.out.println("Salary: " + e2.salary());
    }
}