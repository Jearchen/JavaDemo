package com.jeartech.classProperty.overrideUsageCopy;



//子类和父类不在一个包下，只能重写父类声明为public,protected 方法。
// 这一项暂时没测，在文件夹这个位置也是可以重写，可以考虑多模块下导入的时候是否有权限限制
// 化魔方式飞升
public class DemonizationMethod extends FlyUpPath {
    private static final void carrySomething()
    {
        System.out.println("在上一级目录中的测试private属性的类是否可以重写。");
    }
}
