import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessageWhenSadShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is sad message");
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }

    @Test
    public void givenAnyMessagethenItShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("This is Happy message");
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }
}
