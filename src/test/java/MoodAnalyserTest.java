import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessageWhenSadShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is sad message");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenAnyMessagethenItShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is Happy message");
        Assert.assertEquals("HAPPY",mood);
    }
}
