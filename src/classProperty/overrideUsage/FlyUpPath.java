package classProperty.overrideUsage;
/**
 * 这里使用修士飞升的途径有修仙和化魔一途来说明@Override注解**重写**注意事项。
 *
 */
public class FlyUpPath {

    //static、final方法不能被重写。
   public static void showPath()
   {
       System.out.println("飞升仙界入口");
   }
    private final void choseDestiNation()
   {
       System.out.println("选择飞升地点");
   }

   //private 后面无论带static还是final都能被重写。仅有static无final修饰的任意权限的类都能重写。
   // 总结就是：父类带final的方法只有private修饰符能重写。父类带static都可以重写。重写属于权限外放的过程。
   private static  void carrySomething()
   {
       System.out.println("选择你要携带的宝物");
   }
    private final  void showYourAbility()
    {
        System.out.println("选择你要点亮的技能");
    }
}
