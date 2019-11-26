import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessageWhenSadShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is sad message");
        try {
            Assert.assertEquals("SAD", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAnyMessagethenItShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is Happy message");
        try {
            Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        try {
            Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodShouldThrowMoodAnalysisException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood(null);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenEmptyMoodShouldThrowMoodAnalysisExceptionEmpty() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood("");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassWhenProperShouldReturnObject() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"), moodAnalyser);
    }

    @Test
    public void givenMoodAnalyserImproperClassNameShouldReturnException() {
        try {
            MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserImproperMethodNameShouldReturnException() {
        try {
            MoodAnalyserFactory.createMoodAnalyser("I am in happy mood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }
}
