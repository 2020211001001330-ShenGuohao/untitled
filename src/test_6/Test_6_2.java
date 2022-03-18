package test_6;


class  My extends Exception {
    String id;  //异常标识

    public My(String id){
        this.id=id;
    }
    public String toString(){
        return ("异常: "+id);
    }

}

class Find_root{
    public static double[] root(double a,double b,double c) throws My {
        double x[]=new double[2];
        if(a==0){
            throw new My("a 不能为0");
        }else{
            double disc=b*b-4*a*c;
            if(disc<0){
                throw  new My(b+"*"+b+"-"+4+"*"+a+"*"+c+"<0");
            }else{
                x[0]=(-b+Math.sqrt(disc))/(2*a);
                x[1]=(-b-Math.sqrt(disc))/(2*a);
            }

        }

        return x;
    }
}


public class Test_6_2 {
    public static void main(String[] args)throws My  {
        try {
            double x[]= Find_root.root(1,5,2);
            System.out.println("方程根为: "+x[0]+" "+x[1]);
        }catch (My e){
            System.out.println(e.toString());
        }

    }
}
