package DynamicProxy;
public class DogRun implements TestInterface {
    public DogRun() {

    }
    @Override
    public void Hello() {
        System.out.println("DOG is Running");
    }

    @Override
    public void Bye() {
        System.out.println("DOG Runs away!");
    }
}
