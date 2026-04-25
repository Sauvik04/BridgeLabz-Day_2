import java.util.*;
interface EmpWageInterface {
    void addCompany(String name, int wagePerHour, int maxDays, int maxHours);
    void computeWages();
    int getTotalWage(String companyName);
}
class CompanyEmpWage {
    String companyName;
    int wagePerHour;
    int maxDays;
    int maxHours;

    int totalWage;
    ArrayList<Integer> dailyWages;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxDays, int maxHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxDays = maxDays;
        this.maxHours = maxHours;
        this.dailyWages = new ArrayList<>();
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }
    public int getTotalWage() {
        return totalWage;
    }
}
class EmpWageBuilder implements EmpWageInterface {
    ArrayList<CompanyEmpWage> companies = new ArrayList<>();
    public void addCompany(String name, int wagePerHour, int maxDays, int maxHours) {
        companies.add(new CompanyEmpWage(name, wagePerHour, maxDays, maxHours));
    }
    public void computeWages() {
        for (CompanyEmpWage company : companies) {

            int totalHours = 0;
            int totalDays = 0;

            while (totalHours < company.maxHours && totalDays < company.maxDays) {

                totalDays++;

                int empCheck = (int)(Math.random() * 3);
                int empHours = 0;

                switch (empCheck) {
                    case 1:
                        empHours = 8;
                        break;
                    case 2:
                        empHours = 4;
                        break;
                    default:
                        empHours = 0;
                }

                totalHours += empHours;

                int dailyWage = empHours * company.wagePerHour;
                company.dailyWages.add(dailyWage);
            }

            int totalWage = totalHours * company.wagePerHour;
            company.setTotalWage(totalWage);

            System.out.println("Company: " + company.companyName +
                    " | Total Wage: " + totalWage);
        }
    }
    public int getTotalWage(String companyName) {
        for (CompanyEmpWage company : companies) {
            if (company.companyName.equals(companyName)) {
                return company.getTotalWage();
            }
        }
        return -1;
    }
}
public class Day10Assignment2 {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmpWageBuilder builder = new EmpWageBuilder();
        builder.addCompany("Company1", 20, 20, 100);
        builder.addCompany("Company2", 25, 22, 110);
        builder.computeWages();
        System.out.println("\nWage for Company1: " + builder.getTotalWage("Company1"));
        System.out.println("Wage for Company2: " + builder.getTotalWage("Company2"));
    }
}