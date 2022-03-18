package test_5;

abstract class Fruit{
    abstract public double getweight();  //定义抽象方法
    public void To(){                    //定义具体方法
        System.out.println("hello");
    }
}


//定义苹果类并 实现抽象类当中的抽象方法
class Apple extends Fruit{
    double weight;       //成员变量
    String name;         //成员变量
    Apple(String name,double weight){  //构造方法
        this.name=name;
        this.weight=weight;
    }

    public double getweight(){   //实现抽象方法
        return weight;
    }

}

//定义桃子类并 实现抽象类当中的抽象方法
class Peach extends Fruit{
    double weight; //成员变量
    String name;   //成员变量
    Peach(String name,double weight){ //构造方法
        this.name=name;
        this.weight=weight;
    }

    public double getweight(){   //实现抽象方法
        return weight;
    }

}

//定义橘子类并 实现抽象类当中的抽象方法
class Orange extends Fruit{
    double weight;   //成员变量
    String name;     //成员变量
    Orange(String name,double weight){  //构造方法
        this.name=name;
        this.weight=weight;
    }

    public double getweight(){     //实现抽象方法
        return weight;
    }

}



public class Test_5_1 {
    public static void main(String[] args) {

        Fruit test[]=new Fruit[3];
        test[0]=new Apple("apple",10);
        test[1]=new Peach("peach",20);
        test[2]=new Orange("orange",30);

        for(int i=0;i<3;i++){
            System.out.println(test[i].getweight());
            System.out.println(test[i].getClass().getName());
        }


    }
}
