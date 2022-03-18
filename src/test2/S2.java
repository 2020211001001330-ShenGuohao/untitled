package test2;


//在同一包当中   四种访问权限 除了private  均可访问

public class S2 {
    public static void main(String[] args) {
        //对于成员变量的调试
        S1 s1=new S1(1,2,3,4);
        System.out.println("None "+s1.a);         //没有控制修饰符
        //System.out.println("private "+s1.b);       //private
        System.out.println("protect "+s1.c);        //protect
        System.out.println("public "+s1.d);        //public
        System.out.println("---------------------------------------------------------");
        //对于成员函数的调试
        s1.Show_none();               //没有控制修饰符
        //   s1.Show_private();       //private
        s1.Show_protect();           // protect
        s1.Show_public();           // public

    }

}
