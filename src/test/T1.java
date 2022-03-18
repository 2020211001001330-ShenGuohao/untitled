package test;

public class T1 {
    int a=1;
    int b=f();
    int c;
    {
        a=10;
        b=20;
        c=30;
    }

    int  f(){
        return 10;
    }

    //该类的有参构造函数


    public T1(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    //显示该类的属性
    @Override
    public String toString() {
        return "T1{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public static void main(String[] args) {
        T1 t1=new T1(1,2,3);
        System.out.println(t1);

    }
}
