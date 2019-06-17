package DynamicProxy;
public class ProxyClass  implements TestInterface {
    private TestInterface testInterface;
    public ProxyClass(TestInterface testInterface) {
        this.testInterface =testInterface;
    }
    @Override
    public void Hello(){
        System.out.println("Before Hello Action!");
        testInterface.Hello();
        System.out.println("Stop Hello Action!");
    }

    @Override
     public void Bye() {
        System.out.println("Before Bye Action!");
        testInterface.Bye();
        System.out.println("Stop Bye Action");
    }
}
