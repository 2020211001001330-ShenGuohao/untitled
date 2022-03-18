package test_snake;

//导入相关包
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// User: 沈国浩

//定义Mpanel类继承JPanel父类，并实现接口 KeyListener,ActionListener
public class MPanel extends JPanel implements KeyListener, ActionListener {
//------------------------载入入资源文件------------------------------------------------------------

    ImageIcon title =new ImageIcon("title.png");      //把图片放在GameSnake目录文件夹下，读入标题图片
    ImageIcon body =new ImageIcon("body.png");        //读入身体图片
    ImageIcon up =new ImageIcon("up.png");            //读入上头图片
    ImageIcon down =new ImageIcon("down.png");        //读入下头图片
    ImageIcon left =new ImageIcon("left.png");        //读入左头图片
    ImageIcon right =new ImageIcon("right.png");      //读入右头图片
    ImageIcon food =new ImageIcon("food.png");        //读入右头图片
    ImageIcon obstacle=new ImageIcon("obstacle.png");

//-------------------------主要成员变量,即游戏参数------------------------------------------------------------
      public static boolean isclose;
      String direction;   //蛇头的方向
      int length;         //蛇的长度
      int [] Snake_X =new int[600];  //各个部分的x位置
      int [] Snake_Y =new int[600];  //各个部分的y位置
      int grades;                    //得分
      int speed;                     //游戏速度

      Random random=new Random();    //创建产生随机数的对象
      int footX;                     //食物的x位置
      int footY;                     //食物的y位置

      int [] obstacle_X=new int[32];   //障碍物的x坐标
      int [] obstacle_Y=new int[32];   //障碍物的y坐标

      boolean isStart;                 //游戏状态
      boolean isFalse;

      Timer timer=new Timer(speed,this);
//----------------------------------------------------------------------------------------------
    public MPanel(){   //无参构造函数，在创建该对象时调用

        init();                        //初始化游戏参数
        this.setFocusable(true);       //获取键盘的监听事件
        this.addKeyListener(this);

        timer.start();                 //让时间监听开始
    }


    public static void setIsclose(boolean isclose) {
        MPanel.isclose = isclose;
    }

    public void init(){
             isclose=false;     //是否要结束游戏
             isStart=false;     //初始化游戏状态，此时游戏还未开始
             isFalse=false;     //初始化游戏状态,此时游戏还没有结束
            speed=400;         //初始化游戏速度
            grades=0;           //初始化游戏得分
            direction="R";      //初始化蛇头的方向向右
            length=3;           //初始化蛇的长度为3
            Snake_X[0]=100   ;  Snake_Y[0]=100;  //初始化蛇的位置
            Snake_X[1]=75   ;  Snake_Y[1]=100;
            Snake_X[2]=50   ;  Snake_Y[2]=100;

            timer.setDelay(speed);

            int j=0;
            for(int i=15;i<25 && j<32;i++,j++){   //初始化障碍物的位置
                obstacle_X[j]=i * 25;
                obstacle_Y[j]=20 * 25;
            }
            for(int i=17;i>11 && j<32;i--,j++){
                obstacle_X[j]=15 * 25;
                obstacle_Y[j]=i * 25;
            }
            for(int i=17;i>11 && j<32;i--,j++){
                obstacle_X[j]=24 * 25;
                obstacle_Y[j]=i * 25;
            }
            for(int i=15;i<25 && j<32;i++,j++){
                obstacle_X[j]=i * 25;
                obstacle_Y[j]=9 * 25;
            }

            footX=25+25*random.nextInt(38);    //这里产生的随机数范围为 0-37
            footY=75+25*random.nextInt(24);    //这里产生的随机数范围为 0-23

            for(int i=0;i<32;i++){                   //判断食物是否与障碍物重合,如果重合则重新生成食物的位置
                if((footX==obstacle_X[i] && footY==obstacle_Y[i])){
                         while (footX==obstacle_X[i] && footY==obstacle_Y[i]){
                             footX=25+25*random.nextInt(38);    //这里产生的随机数范围为 0-37
                             footY=75+25*random.nextInt(24);    //这里产生的随机数范围为 0-23
                         }
                }
            }
        timer.start();
    }



    //---------------用来实现贴图功能,即绘制游戏界面--------------------------------------
    @Override //重写父类方法
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                     //清屏
        this.setBackground(Color.BLUE);              //设置画布背景的颜色为蓝色
        title.paintIcon(this,g,25,10);      //绘制标题栏
        g.fillRect(25,75,950,600); //绘制游戏区域
        // -------------------绘制积分系统-------------------------------------
        g.setColor(Color.WHITE);                                //设置画笔颜色
        g.setFont(new Font("微软雅黑",Font.BOLD,15));  //设置字体
        g.drawString("长度: "+length,900,25);          //在相应的位置填充文本
        g.drawString("分数: "+grades,900,40);
        if (speed<=100){                                        //给速度大小分等级
            g.drawString("速度: 快",900,55);
        }else if(speed>100 && speed<=500){
            g.drawString("速度: 中",900,55);
        }else{
            g.drawString("速度: 慢",900,55);
        }

       //-------------------绘制障碍物----------------------------------------

        for(int i=0;i<32;i++){
            obstacle.paintIcon(this,g,obstacle_X[i],obstacle_Y[i]);
        }

       //------------------------画蛇------------------------------------------
        //绘制蛇头
        if(direction=="R"){            //判断蛇的前进方向，由此来绘制蛇头
              right.paintIcon(this,g,Snake_X[0],Snake_Y[0]);
        }else if(direction=="L"){
              left.paintIcon(this,g,Snake_X[0],Snake_Y[0]);
        }else if(direction=="U"){
              up.paintIcon(this,g,Snake_X[0],Snake_Y[0]);
        }else if(direction=="D"){
              down.paintIcon(this,g,Snake_X[0],Snake_Y[0]);
        }
        //绘制身体
        for(int i=1;i<length;i++){
            body.paintIcon(this,g,Snake_X[i],Snake_Y[i]);
        }

        //--------------------画食物----------------------------------
        food.paintIcon(this,g,footX,footY);

        //-------------------绘制游戏状态------------------------------
        if(isStart==false){
            g.setColor(Color.WHITE);                                    //设置画笔颜色
            g.setFont(new Font("黑体",Font.BOLD,40));         //设置字体
            g.drawString("按下回车游戏开始",300,150);             //在指定位置填充文字
            g.drawString("或者按下空格退出游戏",300,190);          //在指定位置填充文字
        }
        if(isFalse==true){
            g.setColor(Color.RED);                                     //设置画笔颜色
            g.setFont(new Font("黑体",Font.BOLD,40));        //设置字体
            g.drawString("游戏失败,按下回车重新开始",100,600);     //在指定位置填充文字
            g.drawString("或者按下空格退出游戏",100,640);           //在指定位置填充文字
        }

    }

    //覆盖接口当中定义的抽象方法
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override

    //-------------------实现键盘监听----------------------------------------
    public void keyPressed(KeyEvent e) {      //键盘按下

        int keycode=e.getKeyCode();          //接受键盘的输入键值
        if(keycode==KeyEvent.VK_SPACE){      //判断是否是空格，如果是则表明要结束游戏
            setIsclose(true);
        }
        if(keycode==KeyEvent.VK_ENTER){     //判断键盘的输入键值是否是回车
            if(isFalse==true){        //如果游戏结束了，则表明要重新开始游戏
                init();              //重新初始化游戏参数
                isFalse=false;       //调整游戏状态

            }else{
                isStart = !isStart;  //调整游戏状态,在这里表明暂停或者继续游戏
            }
        }

        if(keycode==KeyEvent.VK_RIGHT){
            if(direction!="L") {      //不能朝着蛇头的运动方向相反的方向前进
                direction = "R";
            }
        }else if(keycode==KeyEvent.VK_LEFT){
            if(direction!="R") {       //不能朝着蛇头的运动方向相反的方向前进
                direction = "L";
            }
        }else if(keycode==KeyEvent.VK_UP){
            if(direction!="D") {      //不能朝着蛇头的运动方向相反的方向前进
                direction = "U";
            }
        }else if(keycode==KeyEvent.VK_DOWN){
            if(direction!="U") {       //不能朝着蛇头的运动方向相反的方向前进
                direction = "D";
            }
        }

        repaint();   //根面前的游戏参数即MPanel类当中定义的成员变量，刷新界面

    }

    //----------------------事件监听,定时操作---------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) {
             if (isStart && isFalse!=true){      //表示游戏是否开始，并且没有结束

                 for(int i=length-1;i>0;i--){    //实现身体向着蛇头运动的方向移动
                     Snake_X[i]=Snake_X[i-1];
                     Snake_Y[i]=Snake_Y[i-1];
                 }
                 if(direction=="R"){
                     Snake_X[0]+=25;
                     //失败判断条件
                     if(Snake_X[0]>950){
                         isFalse=true;         //跃出右边界
                     }

                 }else if (direction=="L"){
                     Snake_X[0]-=25;
                     if(Snake_X[0]<25){
                         isFalse=true;         //跃出左边界
                     }
                 }else if (direction=="U"){
                     Snake_Y[0]-=25;
                     if (Snake_Y[0]<75){
                         isFalse=true;         //跃出上边界
                     }
                 }else if(direction=="D"){
                     Snake_Y[0]+=25;
                     if(Snake_Y[0]>=675){
                         isFalse=true;         //跃出下边界
                     }
                 }

                 //判断是否撞到了障碍物
                 for(int i=0;i<32;i++){   //因为游戏设计的时候障碍物设定了32个
                     if(Snake_X[0]==obstacle_X[i] && Snake_Y[0]==obstacle_Y[i]){
                         isFalse=true;
                     }
                 }
                 //判断是否撞到了自己的身体
                 for(int i=1;i<length;i++){
                     if(Snake_X[0]==Snake_X[i] && Snake_Y[0]==Snake_Y[i]){
                         isFalse=true;
                     }
                 }

                 //判断是否吃到了食物
                 if(Snake_X[0]==footX && Snake_Y[0]==footY){
                       length++;          //蛇的长度增加
                       grades++;          //积分增加
                       if(speed>100) {     //游戏速度加快
                           speed-=100;
                           timer.setDelay(speed);   //调整游戏速率

                       }

                     //重新生成食物的位置
                     footX=25+25*random.nextInt(38);    //这里产生的随机数范围为 0-37
                     footY=75+25*random.nextInt(24);    //这里产生的随机数范围为 0-23

                     for(int i=0;i<32;i++){                   //判断食物是否与障碍物重合,如果重合则重新生成食物的位置
                         if((footX==obstacle_X[i] && footY==obstacle_Y[i])){
                             while (footX==obstacle_X[i] && footY==obstacle_Y[i]){
                                 footX=25+25*random.nextInt(38);    //这里产生的随机数范围为 0-37
                                 footY=75+25*random.nextInt(24);    //这里产生的随机数范围为 0-23
                             }
                         }
                     }


                 }

                 repaint();         //根面前的游戏参数即MPanel类当中定义的成员变量，刷新界面
             }

    }
}


