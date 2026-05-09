class MoodAnalysisException extends Exception {

    enum ExceptionType {
        EMPTY_MOOD,
        NULL_MOOD
    }

    ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}

class MoodAnalyser {

    private String message;
    public MoodAnalyser() {
    }
    public MoodAnalyser(String message) {
        this.message = message;
    }
    public String analyseMood() throws MoodAnalysisException {

        try {

            if (message.length() == 0) {

                throw new MoodAnalysisException(
                        MoodAnalysisException.ExceptionType.EMPTY_MOOD,
                        "Mood should not be Empty"
                );
            }

            if (message.contains("Sad")) {
                return "SAD";
            }

            return "HAPPY";
        }

        catch (NullPointerException e) {

            throw new MoodAnalysisException(
                    MoodAnalysisException.ExceptionType.NULL_MOOD,
                    "Mood should not be Null"
            );
        }
    }
}

public class Day21Assignment2 {

    public static void main(String[] args) {

        try {
            MoodAnalyser mood1 =
                    new MoodAnalyser("I am in Sad Mood");

            System.out.println(
                    "Mood 1 : " + mood1.analyseMood()
            );
            MoodAnalyser mood2 =
                    new MoodAnalyser("I am in Happy Mood");

            System.out.println(
                    "Mood 2 : " + mood2.analyseMood()
            );
            MoodAnalyser mood3 =
                    new MoodAnalyser(null);

            System.out.println(
                    "Mood 3 : " + mood3.analyseMood()
            );
        }

        catch (MoodAnalysisException e) {

            System.out.println(
                    "Exception Type : " + e.type
            );

            System.out.println(
                    "Exception Message : " + e.getMessage()
            );
        }
    }
}