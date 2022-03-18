package test2;


// 在同一类当中         四种访问权限均可访问
public class S1 {
    int a;
    private int b;
    protected int c;
    public  int d;

    public S1(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    public S1(){
        this.a=2;
        this.b=3;
        this.c=4;
        this.d=5;
    }
    void Show_none(){
        System.out.println("None");
    }
    public void Show_public(){
        System.out.println("pubic");
    }
    protected void Show_protect(){
        System.out.println("protect");
    }
    private void Show_private(){
        System.out.println("private");
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "S1{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    public static void main(String[] args) {
        //对于成员变量的调试
        S1 s1=new S1(1,2,3,4);
        System.out.println("None "+s1.a);         //没有控制修饰符
        System.out.println("private "+s1.b);       //private
        System.out.println("protect "+s1.c);        //protect
        System.out.println("public "+s1.d);        //public
        System.out.println("---------------------------------------------------------");
        //对于成员函数的调试
        s1.Show_none();               //没有控制修饰符
        s1.Show_private();           //private
        s1.Show_protect();           // protect
        s1.Show_public();           // public

    }

}
