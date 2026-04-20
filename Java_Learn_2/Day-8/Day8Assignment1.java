public class Day8Assignment1 {
    static final int wage_per =20;
    static final int full_time = 8;
    static final int part_time = 4;
    static final int maxDay = 20;
    static final int maxHrs = 100;

    public static int Compute(){
        int tlworkingDays = 0;
        int tlworkingHrs = 0;
        int slry = 0;
        while(tlworkingDays <= maxDay && tlworkingHrs <= maxHrs){
            int empHrs = 0;
            tlworkingDays++;
            int empCheck = (int)(Math.random()*3);
            switch (empCheck){
                case 1:
                    empHrs = full_time;
                    break;
                case 2:
                    empHrs = part_time;
                    break;
                default:
                    empHrs=0;
            }
            tlworkingHrs += empHrs;
            int DailyWage = empHrs * wage_per;
            slry += DailyWage;
            if(tlworkingHrs + empHrs >=maxHrs){
                System.out.println("Day : " + tlworkingDays + " | Hours : "+tlworkingHrs+"| Wage : "+DailyWage);
            }
        }
        return slry;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage");
        int total = Compute();
        System.out.println("Total Salary : " + total);
    }
}
