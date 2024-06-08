package com.jeartech.classProperty.superUsage;

public class Dog extends Mammal{
     void getShowName()
    {
        super.showName();
    }
    void testBark()
    {
        //super函数可调用直接父类的方法，若不存在。会去上一级父类寻找，
        // 直接父类和间接父类都有同名函数时，优先调用直接父类的。
        //this和super均不可在静态环境中调用，包括Static变量、方法、语句块。
        //本质上this指向对象，super属于关键字。
        super.TestIfBarkable();
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.getShowName();
        dog.testBark();
    }
}
