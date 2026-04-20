import java.util.*;
public class Day7Assignment1 {
    static final int STAKE = 100;
    static final int BET = 1;
    static final int DAYS = 20;
    public static int playDay() {
        int money = STAKE;
        while (money > 50 && money < 150) {
            if (Math.random() < 0.5) {
                money += BET;
            } else {
                money -= BET;
            }
        }
        return money - STAKE;
    }
    public static void main(String[] args) {
            int totalMoney = 0;
            int winDays = 0;
            int lossDays = 0;
            int maxWin = Integer.MIN_VALUE;
            int maxLoss = Integer.MAX_VALUE;
            int luckiestDay = 0;
            int unluckiestDay = 0;

            for (int day = 1; day <= DAYS; day++) {

                int result = playDay();
                totalMoney += result;
                if (result > 0) {
                    winDays++;
                } else {
                    lossDays++;
                }
                if (result > maxWin) {
                    maxWin = result;
                    luckiestDay = day;
                }
                if (result < maxLoss) {
                    maxLoss = result;
                    unluckiestDay = day;
                }
            }
            System.out.println("Total Money after 20 days: " + totalMoney);
            System.out.println("Winning Days: " + winDays);
            System.out.println("Losing Days: " + lossDays);
            System.out.println("Luckiest Day: Day " + luckiestDay + " (+" + maxWin + ")");
            System.out.println("Unluckiest Day: Day " + unluckiestDay + " (" + maxLoss + ")");
            if (totalMoney > 0) {
                System.out.println("Continue Gambling Next Month");
            } else {
                System.out.println("Stop Gambling");
            }
        }
    }
