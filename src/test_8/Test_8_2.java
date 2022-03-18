package test_8;

import java.util.*;
class Comparator1 implements Comparator<String>{
    public int compare(String s1,String s2){
        s1=s1.toLowerCase();   //字符串全部字符换小写
        s2=s2.toLowerCase();
        return s1.compareTo(s2);
    }
}

public class Test_8_2 {
    public static void output(Collection<String> c){
     Iterator<String> it=c.iterator(); //声明一个迭代器，泛型里面是String类型，表示迭代元素是String类型的
     while (it.hasNext()){             //判断集合里是不是已经没有元素了
         System.out.print(it.next()+","); //输出集合里面的元素
     }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> mylsit = new ArrayList<String>();
        for (char i = 'a'; i < 'g'; i++) {
            mylsit.add(String.valueOf(i));  //添加a-b-c-d-e-f
        }
        Collections.addAll(mylsit,  "T","v");  //在后面添加T v
        System.out.println("排序前");
        output(mylsit);
        Collections.sort(mylsit);
        System.out.println("区分大小写时排序");
        output(mylsit);
        System.out.println("不区分大小写时排序");
        Collections.sort(mylsit, new Comparator1());
        output(mylsit);
    }

}
