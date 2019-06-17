package ThreadDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public  class RunableThread implements Runnable{

    @Override
    public void run()
    {
        System.out.println("I am washing your cloth");
    }

//    public  static String detected(String str1,BufferedReader buffer){
//        String str2 ="1";
//        try {
//             str2=buffer.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            return str2;
//        }
//    }
    public static void main(String[] args) {
        String Oncommand = "yes";
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader inputBuffer = new BufferedReader(input);
        Scanner input =new Scanner(System.in);

        System.out.println("you want to wash cloth ?");
        String comand = input.nextLine();
            RunableThread runcommand = new RunableThread();
            Thread Machine = new Thread(runcommand);
            Boolean flag = comand.equals(Oncommand);
            try {
                if (flag.equals(true)) {
                    Machine.start();
                    Machine.sleep(5000);//休眠五秒。
                    System.out.println("your cloth is washed down! Master");
//                    Machine.join(5000);
                }
                System.out.println("Stop!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
