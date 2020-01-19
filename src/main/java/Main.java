
public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Information info = new Information();
        Information info2 = new Information();
        try {


            Myclassloader myclassloader1 = new Myclassloader();
            Myclassloader2 myclassloader2 = new Myclassloader2();

            Class test1 = myclassloader1.findClass("./target/classes/MyClass");
            Class test2 = myclassloader2.findClass("./target/classes/MyClass");
            System.out.println("Load Class: " + test1+ " && " + test2);


            TestInterface<Integer> testInterfaceInt = (TestInterface)  test1.newInstance();
            TestInterface<String> testInterfaceSt = (TestInterface)  test2.newInstance();

            int TestInt = (testInterfaceInt.set(12345));
            String TestStr = (testInterfaceSt.set("Test String"));
            System.out.println(TestInt);
            System.out.println(TestStr);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
