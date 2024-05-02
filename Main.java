import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        Employee e1 =new Employee("A17",'I',"22/05/2017",7.5, 22,0);
        Employee e2 =new Employee("A239",'O',"21/05/2017",8.4, 19,10);

        employees.add(e1);
        employees.add(e2);

        Employee.costPerDay(employees,"21/05/2017");
        Employee.costPerDay(employees,"22/05/2017");
        Employee.RankingReport(employees);
    }
}