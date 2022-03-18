package test_3;



class Line{
    private Point p1,p2;
    private double distance;
    public Line(Point x1,Point x2) {
        p1=x1;
        p2=x2;
        distance=Math.sqrt((p1.Get_X()-p2.Get_X())*(p1.Get_X()-p2.Get_X())+(p1.Get_Y()-p2.Get_Y())*(p1.Get_Y()-p2.Get_Y()));
    }
    public String toString() {
        return "点 "+p1.Get_X()+","+p1.Get_Y()+" 与点 "+p2.Get_X()+","+p2.Get_Y()+" 之间的距离为"+distance;
    }

}

class triangle{
    int c1,c2,c3;
    double S,C;
    public triangle(int x1,int x2,int x3) {
        c1=x1;c2=x2;c3=x3;
        C=c1+c2+c3;
        double p=(c1+c2+c3)/2;
        S=Math.sqrt(p*(p-c1)*(p-c2)*(p-c3));
    }

    public String toString() {
        return "三角形边长为 "+c1+","+c2+","+c3+" 边长为 "+C+","+"面积为"+S;
    }
}

class Matrix{
    private int row,col;
    double [][]data;

    //无参构造函数
    public Matrix() {
        this.col=0;
        this.row=0;
        this.data=new double[row][col];
    }

    //设计一个与某一个二维数组一样的矩阵
    public Matrix(double [][]a) {
        this.row=a.length;
        this.col=a[0].length;
        this.data=new double[this.row][this.col];
        for(int i=0;i<this.row;i++) {
            for(int j=0;j<this.col;j++) {
                this.data[i][j]=a[i][j];
            }
        }
    }

    //设计一个每个元素都相同的矩阵
    public Matrix(int row,int col,int allvalue) {
        this.col=col;
        this.row=row;
        for(int i=0;i<this.col;i++) {
            for(int j=0;j<this.row;j++) {
                data[i][j]=allvalue;
            }
        }
    }

    //设计一个随机序列的矩阵
    public Matrix(int row,int col) {
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                data[i][j]=Math.random();
            }
        }
    }

    //返回行数
    public int Get_row() {
        return this.row;
    }
    //返回列数
    public int Get_col() {
        return this.col;
    }

    //打印矩阵
    public void PrintArray() {
        for(int i=0;i<this.row;i++) {
            for(int j=0;j<this.col;j++) {
                System.out.print(this.data[i][j]+" ");
            }System.out.println();
        }

    }
    public void add(Matrix x1) {
        for(int i=0;i<x1.row;i++) {
            for(int j=0;j<x1.col;j++) {
                this.data[i][j]=this.data[i][j]+x1.data[i][j];
            }
        }
    }

}


 class Point {

     private int x, y;

     public Point(Point p1) {
         x = p1.x;
         y = p1.y;
     }

     public Point() {
         x = 0;
         y = 0;
     }

     public Point(int xx, int yy) {
         x = xx;
         y = yy;
     }

     ;


     public void Set_X(int x1) {
         x = x1;
     }

     public void Set_Y(int y1) {
         y = y1;
     }

     public int Get_X() {
         return x;
     }

     public int Get_Y() {
         return y;
     }

     public String toString() {
         return "点 " + x + "," + y;
     }
 }

 public class Test_3 {
     public static void main(String[] args) {

             Point x1=new Point(1,2);
             Point x2=new Point(4,6);

             Line l1=new Line(x1,x2);
             triangle t1=new triangle(3,4,5);

             double a[][]= {{1,2},{3,4}};
             double b[][]= {{5,6},{7,8}};
             Matrix m1=new Matrix(a);
             Matrix m2=new Matrix(b);

             System.out.println(x1);
             System.out.println(x2);
             System.out.println(l1);
             System.out.println(t1);

             m1.PrintArray();
             System.out.println("--------");
             m2.PrintArray();
             System.out.println("--------");
             m1.add(m2);
             m1.PrintArray();
             System.out.println("--------");

     }
}
