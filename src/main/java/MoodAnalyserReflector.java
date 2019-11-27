import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static Constructor<?> getConstructor(Class<?> ... param) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("MoodAnalyser");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        }
    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object ... message) throws MoodAnalyserException {
        try {
            return constructor.newInstance(message);
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.OBJECT_CREATION_ISSUE, e);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_ACCESS,e);
        }
    }
}