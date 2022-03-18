package test_8;

class Point{              //定义点类
    private int x,y;      //私有成员

    public Point(int x, int y) { //Point有参构造函数
        this.x = x;
        this.y = y;
    }

    public int getX() {       //返回x的值
        return x;
    }

    public void setX(int x) { //设置x的值
        this.x = x;
    }

    public int getY() {      //返回y的值
        return y;
    }

    public void setY(int y) { //设置y的值
        this.y = y;
    }
    public String toString() { //打印Point的信息
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Example<T>{
    private T obj;  //定义泛型成员变量
    public Example(T obj){
        this.obj=obj;
    }
    public T getObj(){
        return obj;
    }
    public void showType(){
        System.out.println("T的实际类型: "+obj.getClass().getName());
    }

}



public class Test_8_1 {
    public static void main(String[] args) {
            Point p2=new Point(1,2);
            Example<Point> p1=new Example<Point>(p2);
            p1.showType();
            Point p3=p1.getObj();
            System.out.println("Value= "+p3);
    }

}
