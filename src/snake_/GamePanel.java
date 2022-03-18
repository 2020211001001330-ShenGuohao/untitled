package snake_;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int length;                   //蛇的长度
    int speed;
    int [] snakeX=new int [600];  //存放各个部分的位置
    int [] snakeY=new int [600];
    String fx; //R:右 L:左 U:上 D:下
    boolean isstart;
    Timer timer;

    //定一个食物
    int footX;
    int footY;
    int Grades;
    Random random=new Random();

    //死亡判断
    boolean isFail=false;


    //构造函数
    public GamePanel(){

        init();
        //获取键盘监听时间
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    //初始化
    public void init(){
        fx="R";
        isstart=false;
        length=3;
        speed=500;
        Grades=0;
        snakeX[0]=200; snakeY[0]=100;
        snakeX[1]=175; snakeY[1]=100;
        snakeX[2]=150; snakeY[2]=100;
        timer=new Timer(speed,this);

        footX=25+25*random.nextInt(34);
        footY=75+25*random.nextInt(24);

    }




    //画板：画界面，画蛇
    //Graphics g     画笔

    //重写父类方法
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);           //清屏
        this.setBackground(Color.RED);   //设置背景颜色

        //绘制头部的广告栏
        Data.header.paintIcon(this,g,25,10);
        //绘制游戏区域
        g.fillRect(25,75,850,600);

        //画一条静态的蛇

        if(fx=="R") {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (fx=="L"){
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if(fx=="U"){
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else{
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for(int i=1;i<length;i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //画食物
        Data.food.paintIcon(this,g,footX,footY);

        //画积分
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度: "+length,750,35);
        g.drawString("分数: "+Grades,750,55);

        //游戏提示: 是否开始
        if(isstart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下回车游戏开始",300,300);
        }
        //失败提醒
        if(isFail==true){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败,按下回车重新开始",200,300);

        }

    }

    //实现接口

    //接受键盘的输入监听 :监听
    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();

        if(key==KeyEvent.VK_ENTER){
            if(isFail){    //游戏失败再来一遍
                isFail=false;
                init();       //重新初始化游戏
            }else{
                isstart=!isstart;   //暂停或者开始游戏
            }


            repaint();                //刷新界面
        }

        if(key==KeyEvent.VK_LEFT){
            fx="L";
        }else if(key==KeyEvent.VK_RIGHT){
            fx="R";
        }else if(key==KeyEvent.VK_UP){
            fx="U";
        }else if(key==KeyEvent.VK_DOWN){
            fx="D";
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}


    //定时器，监听时间,帧 :执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        //游戏出于开始状态，并且游戏没有结束
        if(isstart &&isFail==false){


            for(int i=length-1;i>0;i--){   //先将身体朝着蛇头的方向移动
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            if(fx=="R") {
                snakeX[0] = snakeX[0] + 25;        //移动蛇头
                if(snakeX[0]>850){ snakeX[0]=25;}
            }else if(fx=="L"){
                snakeX[0]= snakeX[0]-25;
                if(snakeX[0]<25){ snakeX[0]=850;}
            }else if(fx=="U"){
                snakeY[0]= snakeY[0]-25;
                if(snakeY[0]<75){ snakeY[0]=650;}
            }else  if(fx=="D"){
                snakeY[0]= snakeY[0]+25;
                if(snakeY[0]>650){snakeY[0]=75;}
            }

            //判断蛇头是否与食物重合
            if(footX==snakeX[0] && footY==snakeY[0]){
//                for(int i=length-1;i>0;i--){
//                    snakeX[i]=snakeX[i-1];
//                    snakeY[i]=snakeY[i-1];
//                }
//                snakeX[0]=footX;
//                snakeY[0]=footY;
                length++;
                Grades++;

                footX=25+25*random.nextInt(34);
                footY=75+25*random.nextInt(24);


                if(speed>200){
                    speed-=200;
                    timer.setDelay(speed);
                }
            }

            //结束判断
            //判断身体是否相撞
            for(int i=1;i<length;i++){
                if(snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFail=true;
                }
            }



//            if (snakeX[0]>=875){
//                snakeX[0]=25;
//  调整游戏速度          if(speed>200) {
//  可以随着吃的食物的增加  speed-=200;
//  加快游戏速率          timer.setDelay(speed);
//                }
//            }
            repaint();
        }
    }

}
