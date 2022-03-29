package classProperty.superUsage;

//此处 继承Dog会引发 “java: 涉及classProperty.superUsage.Animal的循环继承” 报错
public class Animal{
    private  boolean jump;
    private String name;
    public void showName(){
        System.out.println("AnimalName");
    }

    public void TestIfBarkable()
    {
        System.out.println("Animal are not able to bark");
    }
}
