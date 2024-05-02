import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
    String id;
    char type;
    String date;
    double hours;
    int hourlyRate;
    int fixedCost;

    public Employee(String id,char type,String date, double hours, int hourlyRate, int fixedCost){
        this.id= id;
        this.type=type;
        this.date=date;
        this.hours=hours;
        this.hourlyRate=hourlyRate;
        this.fixedCost=fixedCost;
    }

    double amountOfCost() {
        double amount;
        amount = (hours * hourlyRate) + fixedCost;
        return amount;
    }
    static void costPerDay(ArrayList employees, String dateOfCost) {
        double costI = 0;
        double costO = 0;

        for (int i=0; i<employees.size();i++ ){
            Employee e = (Employee) employees.get(i);
            if (e.date == dateOfCost){
                if (e.type == 'I'){
                    costI = costI + e.amountOfCost();
                }
                else {
                    costO = costO + e.amountOfCost();
                }
            }
        }
        System.out.println("The total cost for in-house employees is : " + costI);
        System.out.println("The total cost for outsourced employees is : " + costO);
        System.out.println("The total cost of the day is: " + costI+costO);
    }
    static void RankingReport(ArrayList employees){
        ArrayList<Employee> RankedemployeesI = new ArrayList<Employee>();
        ArrayList<Employee> RankedemployeesO = new ArrayList<Employee>();

        for(int i=0; i<employees.size();i++){
            Employee e = (Employee) employees.get(i);
            if(e.type=='I'){
                RankedemployeesI.add(e);
            }else {
                RankedemployeesO.add(e);
            }
        }

        Collections.sort(RankedemployeesI, Comparator.comparing(Employee::amountOfCost));   //taxinomisi
        Collections.reverse(RankedemployeesI);                                              //descending..

        Collections.sort(RankedemployeesO, Comparator.comparing(Employee::amountOfCost));
        Collections.reverse(RankedemployeesO);


        System.out.println("The Ranking Report for in-house employees : " );
        for(int i=0; i<RankedemployeesI.size();i++){
            System.out.println(RankedemployeesI.get(i).id +"\n");
        }
        System.out.println("The Ranking Report for outsourced employees : " );
        for(int i=0; i<RankedemployeesO.size();i++){
            System.out.println(RankedemployeesO.get(i).id +"\n");
        }
    }
}
