import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {

    private static final String CLASSFORTEST = "java.lang.String";
    //private static final String CLASSFORTEST = "java.lang.reflect.Method";

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Information info = new Information();
        try {


            Myclassloader myclassloader1 = new Myclassloader();
            Myclassloader2 myclassloader2 = new Myclassloader2();

            Class test1 = myclassloader1.findClass("/home/alexander/IdeaProjects/Interface/target/classes/MyClass");
            Class test2 = myclassloader2.findClass("/home/alexander/IdeaProjects/Interface/target/classes/MyClass2");
            System.out.println("Загружаемый класс : " + test1);

            Method method = test1.getMethod("PrintMessage",new Class[]{String.class});
            method.invoke(test1.newInstance(), new Object[]{"Hello Classloader"});


            TestInterface testInterface = (TestInterface)  test2.newInstance();
            testInterface.PrintMessage("Wooooooooow");


            Information info1 = new Information();
            info1.getInfo(test1);
            info.getInfo(test2);

            info.printClass();



//            Class clazz = Class.forName(CLASSFORTEST);
//            info.getInfo(clazz);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
