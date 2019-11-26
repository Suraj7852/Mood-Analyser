public class MoodAnalyser {

    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood(String message) throws MoodAnalyserException{
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalyserException{
        try {
            if(message.length()==0)
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"Enter proper Mood");
            if(message.contains("sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Enter Proper mood");
        }
    }

    public boolean equals(Object another) {
        if(this.message.equals(((MoodAnalyser) another).message))
            return true;
        return false;
    }
}
