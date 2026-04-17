import java.util.*;
public class Day3Assignment11 {
    public static void main(String[]args){
        int wage_per = 20;
        int full_time = 8;
        int part_time = 4;
        int max_hrs = 100;
        int max_day = 20;
        int totalWorkingDays = 0;
        int totalWorkingHrs = 0;
        int totalSalary = 0;
        Random rand = new Random();
        while(totalWorkingDays < max_day && totalWorkingHrs < max_hrs){
            totalWorkingDays++;
            int emp = rand.nextInt(3);
            int empHrs = 0;
            switch (emp) {
                case 1 :
                    System.out.println("Day " + totalWorkingDays + "Employee is full time");
                    empHrs = full_time;
                    break;
                case 2 :
                    System.out.println("Day " + totalWorkingDays + "Employee is part time");
                    empHrs =part_time;
                    break;
                default:
                    System.out.println("Day " +totalWorkingDays+ "Employee is absent");
                    empHrs=0;
            }
            if (totalWorkingHrs + empHrs > max_hrs) {
                empHrs = max_hrs - totalWorkingHrs;
            }
            totalWorkingHrs += empHrs;
            int daily = empHrs * wage_per;
            totalSalary += daily;
            System.out.println("Daily Wage = " + daily);
            System.out.println("Total Hours = " + totalWorkingHrs);
        }
        System.out.println("Total Working Days: " + totalWorkingDays);
        System.out.println("Total Working Hours: " + totalWorkingHrs);
        System.out.println("Total Salary: " + totalSalary);
    }
}
