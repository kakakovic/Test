import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Generic {
    A<Test> a = new A<>();

    public static void main(String[] args) {
        Field field = null;
        try {
            field = Generic.class.getDeclaredField("a");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType)genericType;
            //得到泛型里的class类型对象
            System.out.println(pt.getActualTypeArguments()[0]);
        }
    }
}

class A<T>{

}
