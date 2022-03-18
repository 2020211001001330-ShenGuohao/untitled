package test_7;


import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Test_7_1 {

    public static void main(String[] args) {

        int count=0;           //统计单词个数初始化为0
        try{
            FileReader file=new FileReader("./test.dat");  //创建用于读取字符流对象
            LineNumberReader in=new LineNumberReader(file);        //创建用来按行读取文本文件对象
            boolean eof=false;  //判断是否到了文件末尾

            while (!eof){                 //循环条件为没有到达文本的结束位置
                String x=in.readLine();   //读取一行字符串

                if(x==null){              //表示已经读取到了文件的末端
                    eof=true;
                }else{
                    System.out.println("第"+in.getLineNumber()+"行"+":"+x);  //输出该行的信息
                    int ret=Count(x);    //统计该行的单词个数
                    count+=ret;          //一行一行统计累加
                }
            }
            in.close();
        }catch (IOException e){                 //捕获异常，如果读取文件不存在则会进行异常处理
            System.out.println(e.toString());
        }

           System.out.println("单词数:"+count);  //输出单词的个数
    }

    public static int Count(String x){   //统计单词的个数
        int count=0;     //统计单词的变量先初始化为0
        int flag=0;      //表示当前读取单词是否结束，1表示当前单词读取还没有结束 0表示表示当前单词读取已经结束

        for(int i=0;i<x.length();i++){
            if(x.substring(i,i+1).equals(" ")){
                flag=0;
            }else {
                if(flag==0){  //0表示表示当前单词读取已经结束
                    count++;  //进行累加
                    flag=1;   //当前单词读取没有结束
                }
            }
        }
        return count;
    }
}





//        Scanner in=new Scanner(System.in);  //创建输入流对象
//        String str=in.next();               //读取输入字符
//        System.out.println(str);            //打印信息
//
//        try {
//            FileOutputStream out=new FileOutputStream("./test.dat");
//            out.write(str.getBytes(StandardCharsets.UTF_8));
//            out.close();
//        }catch (Exception e){
//            e.toString();
//        }
//        in.close();
//