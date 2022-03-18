
package test_7;

import java.io.*;

public class Test_7_2 {
    public static void main(String[] args) throws IOException{  //说明下面可能出现此异常
        BufferedReader buf1 = new BufferedReader(new InputStreamReader(System.in));
        //整体意思就是用InputStreamReader这个中介把System.in这个字节流转换成字符流BufferedReader
        //这样输入的时候就可以不是一个一个字节读，而是一个一个字符读，再加上是个Buffer，效率会高很多
        BufferedWriter buf2 = new BufferedWriter(new FileWriter("./test.txt"));
        System.out.println("请输入写入文本内容,"+"退出请输入end");
        String str = buf1.readLine();  //读取一行
        while(!str.equals("end")){
            buf2.write(str);         //写入文件
            buf2.newLine();          //开始下一行
            str = buf1.readLine();    //读取一行
        }
        buf1.close();    //关闭流对象
        buf2.close();
    }
}


