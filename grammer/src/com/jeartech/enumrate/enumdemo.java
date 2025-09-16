package com.jeartech.EnumDemo;

import java.util.Enumeration;
import java.util.Vector;

/**
 *枚举没有构造类型，枚举类都继承自java.lang.Enum
 * ps:datatype from elder scrooller
 */
public class enumdemo {
    /**
     * jdk1.6之后方法。
     */
    public enum DragonBron{
        POCHAR("Pochar",1), ORCHI("Orchi",2), BOZAR("Bozar",3);
        private  String announce;
        private  int content;

        DragonBron(String announce,int content) {
            this.announce = announce;
            this.content = content;
        }

        public String getAnnounce() {
            return announce;
        }

        public int getContent() {
            return content;
        }

        public void setAnnounce(String announce) {
            this.announce = announce;
        }

        public void setContent(int content) {
            this.content = content;
        }

        public static DragonBron GetDrangonBronByContent(int code){
            for(DragonBron key :DragonBron.values())
            {
                if (key.getContent()== code)
                    return key;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        /**
         * 通过Vector方法返回枚举Enumration类。完成增加，遍历操作。
         */
        Enumeration<String > IronBrons;
        Vector <String> Person_Name = new Vector<String>();
        Person_Name.add("Thenon GreyGeoy");
        Person_Name.add("Yala GreyGeoy");
        Person_Name.add("Yolun GreyGeoy");
        IronBrons = Person_Name.elements();
        while (IronBrons.hasMoreElements()) {
            System.out.println(IronBrons.nextElement());
        }
        /**
         * Jdk1.6之前，switch只支持int,char，enum。通过枚举
         */
        System.out.println(prince());
        System.out.println(princess("Earge public Parade in the street!"));
        ArrayErgodic();

        DragonBron mydragnbron = DragonBron.POCHAR;
        System.out.println(mydragnbron.getAnnounce());
        for(DragonBron key:DragonBron.values())
        {
            System.out.println(key.getAnnounce());
        }

        int yourcode = 2;
        DragonBron drgan =DragonBron.GetDrangonBronByContent(yourcode);
        System.out.println("Get DragonBron By code "+ drgan);

    }

    /**
     * 在枚举中加入自定义的方法，在最后一个枚举变量中加入一个分号
     */

    public enum ThronesKind{
            PARADE, ORDER, OBEY, SEIZE;
    }
    /**
     * using enum variable
     */
    public static boolean princess(String property)
    {
        if (property == EnumConstant.PARADE)
            return  true;
        else {
            return  false;
        }

    }
    /**
     * 易百教程上看到不知道什么傻吊代码！~
     * 使用==来进行比较
     * @return
     */
    public static boolean prince(){
        ThronesKind thronesKind = ThronesKind.OBEY;
        switch (thronesKind){
            case PARADE:
                System.out.println("public is parade!");break;
            case OBEY:
                System.out.println("subordinate is obeying you!");break;
            case ORDER:
                System.out.println("public is in order");break;
            case SEIZE:
                System.out.println("our king is dead!Seizing the throne");break;
            default:
                System.out.println("entering the right Code!");
        }
        if (thronesKind ==ThronesKind.PARADE)
            return  true;
        else{
            return false;
        }
    }
    /**
     * 数组方式遍历枚举数值
     */
    public static final void ArrayErgodic(){
        ThronesKind [] thronesKinds =ThronesKind.values();
        for(ThronesKind tk :thronesKinds)
        {
            System.out.println("DATA"+":"+tk);
        }
    }
}
