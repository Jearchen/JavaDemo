package com.jeartech.IO;

import  java.io.*;

/**
 * 文件操作类
 */
public class IOstream {
    private int cursorlen ;
    private char cursor2 ;
    public  static  final char a ='q';
    private FileInputStream collector ;
    private  FileOutputStream printer ;
    private  File rawFile ;

    /**
     *
     * @param a
     * @param printer
     * @param collector
     * @param rawFile
     */
    public IOstream() {
        try{
            this.collector = new FileInputStream("H:\\JavaDemo\\resource\\Watermelon.txt");
            this.printer = new FileOutputStream("H:\\JavaDemo\\resource\\SeizeFromWatermelon.txt");
            this.rawFile =new File("H:\\JavaDemo\\resource\\newFile.txt");
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void writetofile (char cursor3){
        try{
            this.printer.write(cursor3);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void writetofile (int cursor3){
        try{
            this.printer.write(cursor3);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public char readfileto (InputStreamReader inputStreamReader){
        char buffer ='0';
        try{
            buffer= (char)inputStreamReader.read();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            return  buffer;
        }
    }

    public char readfileto (FileInputStream inputStreamReader){
        char buffer ='0';
        try{
            buffer = (char)inputStreamReader.read();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            return  buffer;
        }
    }

    public void ScanAndOutput()
    {
        InputStreamReader inputStreamReader =new InputStreamReader(System.in);
        //输入一行并输出到控制台和文件中
        while((cursor2 = readfileto(inputStreamReader))!=a){
            System.out.print(cursor2);
            writetofile(cursor2);
        }
    }

    public void CopyFromOtherFile()
    {
        try
        {
            //拷贝文件内容到另一个文件。
            while ((this.cursorlen = this.collector.read()) != -1) {
                writetofile(this.cursorlen);
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void CloseAllFile()
    {
        //关闭所有文件流
        try
        {
            System.out.println("Close ALL");
            if (this.collector!=null)
            {
                this.collector.close();
            }
            if (this.printer!=null)
            {
                this.printer.close();
            }
        }catch (IOException e1){
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOstream iostream =new IOstream();
        iostream.ScanAndOutput();
        iostream.CopyFromOtherFile();
        iostream.CloseAllFile();
    }
}
