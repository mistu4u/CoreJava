package trickycorejava.constructor;

public abstract class AbstractTester {
    abstract int getAge();
    final AbstractTester abstractTester;
      int check = 1;

    {
        abstractTester = new AbstractTester() {

            @Override
            int getAge() {
                return 0;
            }
        };
    }

}
