package snake_;

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {
        //1.绘制一个静态窗口
        JFrame frame=new JFrame("贪吃蛇");
        frame.setBounds(500,100,900,720);     //设置界面大小
        frame.setResizable(false);                              //设置窗口不可变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 设置关闭事件



        //2.画板 JPanel   可以加到JFrame

        frame.add(new GamePanel());                 //将面板添加到窗口去
        frame.setVisible(true);                     //让窗口能够展示出来
    }
}
