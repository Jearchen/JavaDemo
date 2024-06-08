package com.jeartech.classProperty.overrideUsage;

//修仙途径飞升
public class AcensionMethod extends FlyUpPa{
    public static void showPath(){
        System.out.println("使用 public static 修饰的重写");
    }
    public static  void carrySomething()
    {
        System.out.println("public static 修饰的重写");
    }
    public final void showYourAbility()
    {
        System.out.println("使用private final 修饰的重写");
    }
//private 修饰的也能重写
//    private final void showYourAbility()
//    {
//        System.out.println("使用private final 修饰的重写");
//    }
//    private static void carrySomething()
//    {
//        System.out.println("使用private static 修饰的重写");
//    }




     private void choseDestiNation()
    {
        System.out.println("选择飞升地点");
    }
}
