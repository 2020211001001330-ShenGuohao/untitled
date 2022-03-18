package test_snake;

import javax.swing.*;

public class SGames {

    public static void main(String[] args) {

        JFrame frame = new JFrame("沈国浩做的贪吃蛇");                       //创建窗体对象
        frame.setBounds(500,200,1000,720);          //设置窗体的大小
        frame.setResizable(false);                                    //设置窗体不可改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         //设置关闭事件，即关闭窗口，程序也就自动结束了
        frame.add(new MPanel());                                      //添加画板组件

        while (true) {                //在MPanel类当中定义的isclose boolean静态变量,当键盘输入空格时变为true
            if (MPanel.isclose == false) {
                frame.setVisible(true);                                       //显示窗体
            } else {
                 frame.setVisible(false);         //关闭窗体
                 System.exit(0);           //退出程序
            }
        }
    }
}
