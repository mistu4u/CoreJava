package trickycorejava.constructor;

class parent{
    public int m(){
      return 2;
    }
}
public class ConstructorTest extends parent{
    int age;
    public ConstructorTest(){

    }
    public int m(){
        return  Integer.valueOf(2);
    }

    public static void main(String[] args) {

        ConstructorTest test = new ConstructorTest();
    }
}
