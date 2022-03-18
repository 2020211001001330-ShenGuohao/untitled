package test1;
import test2.S1;

public class T2 extends S1{

    public static void main(String[] args) {
        T2 t2=new T2();


//
//        System.out.println("None "+t2.a);         //没有控制修饰符
//        System.out.println(t2.getA());           //利用特殊办法获取 None a的值
//        System.out.println("private "+t2.b);       //private
       System.out.println("protect "+t2.c);        //protect
        System.out.println("public "+t2.d);        //public

        System.out.println("------------------------------");
//        t2.Show_none();               //没有控制修饰符
//        t2.Show_private();           //private
        t2.Show_protect();           // protect
        t2.Show_public();           // public
    }
}
