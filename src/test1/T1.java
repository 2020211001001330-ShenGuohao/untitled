package test1;

import test2.S1;


//不同包的非子类当中       访问权限只有pubic
public class T1{
    public static void main(String[] args) {
        S1 s1=new S1(1,2,3,4);


//
//        System.out.println("None "+s1.a);         //没有控制修饰符
//        System.out.println(s1.getA());           //利用特殊办法获取 None a的值

//        System.out.println("private "+s1.b);       //private
//        System.out.println("protect "+s1.c);        //protect
        System.out.println("public "+s1.d);        //public

        System.out.println("------------------------------");
//        s1.Show_none();               //没有控制修饰符
//        s1.Show_private();           //private
//        s1.Show_protect();           // protect
        s1.Show_public();           // public
    }
}
