package test_5;


interface Shape{         //定义接口
    abstract public double size();
}

class Rectangle implements Shape{  //实现接口
    double x1;                     //成员变量
    double x2;
    Rectangle(double x1,double x2){ //构造方法
        this.x1=x1;
        this.x2=x2;
    }
    public  double size(){    //重写接口定义的抽象方法
        return x1*x2;
    }
}

class Circle implements Shape{     //实现接口
    double r;                      //成员变量

    public Circle(double r) {     //构造方法
        this.r = r;
    }


    public double size() {   //重写接口定义的抽象方法
        return 3.14*r*r;
    }
}


class  Cylinder implements Shape{    //实现接口
    double r;                       //成员变量
    double height;

    public Cylinder(double r,double height) { //构造方法
        this.r = r;
        this.height=height;
    }

    public double size() {       //重写接口定义的抽象方法
        return 3.14*r*r*height;
    }
}


public class Test_5_2 {


    public static void main(String[] args) {
        Shape [] test=new Shape[3];    //创建Shape数组
        test[0]=new Rectangle(3,2);   //创建Rectangle对象
        test[1]=new Circle(1);     //创建Circle对象
        test[2]=new Cylinder(1,2); //创建Cylinder对象

        for(int i=0;i<3;i++){
            if(i!=2) {
                System.out.println(test[i].getClass().getName() + " 面积为: "+test[i].size());
            }else{
                System.out.println(test[i].getClass().getName() + " 体积为: "+test[i].size());
            }
        }
    }

}
