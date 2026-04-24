import java.util.*;
class EmployeeWage {
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_TIME = 1;
    static final int PART_TIME = 2;
    static final int MAX_DAYS = 20;
    static final int MAX_HOURS = 100;
    public int computeWage() {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;
        while (totalHours < MAX_HOURS && totalDays < MAX_DAYS) {

            totalDays++;
            int empHours = 0;
            int empCheck = (int)(Math.random() * 3);

            switch (empCheck) {
                case FULL_TIME:
                    empHours = 8;
                    System.out.println("Day " + totalDays + ": Full Time");
                    break;

                case PART_TIME:
                    empHours = 4;
                    System.out.println("Day " + totalDays + ": Part Time");
                    break;

                default:
                    empHours = 0;
                    System.out.println("Day " + totalDays + ": Absent");
            }

            totalHours += empHours;
            int dailyWage = empHours * WAGE_PER_HOUR;
            totalWage += dailyWage;
            System.out.println("   Hours: " + empHours + " | Daily Wage: " + dailyWage);
        }
        System.out.println("\nTotal Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        return totalWage;
    }
}
public class Day9Assignment2 {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmployeeWage emp = new EmployeeWage();
        int totalSalary = emp.computeWage();
        System.out.println("\nTotal Monthly Wage: " + totalSalary);
    }
}