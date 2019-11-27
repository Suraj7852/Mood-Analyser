import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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

    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalyserException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,"Define proper Method Name");
        }catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE,"May be issue with data entry");
        }catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_ACCESS,"May be issue with data entry");
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalyserException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject, fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD,"Define proper field name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_ACCESS,"May be issue with data entry");
        }
    }
}