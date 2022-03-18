package test_6;

import java.util.Scanner;

public class Test_6_1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String k=in.next();
        try {
                int n=Integer.parseInt(k,10);
                System.out.println(j(n));
        }catch (NumberFormatException e){
            System.out.println("输入异常");
        }
    }

    public  static int j(int n){
        if(n==0){
            return 1;
        }else {
            return n*j(n-1);
        }
    }

}
