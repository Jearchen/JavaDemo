package DynamicProxy;
public class BirdFlying implements TestInterface{

    public BirdFlying() {
    }
    @Override
    public void Hello() {
        System.out.println("Hello!Bird is flying");
    }

    @Override
    public void Bye() {
        System.out.println("Bird is flying away!");
    }
}
