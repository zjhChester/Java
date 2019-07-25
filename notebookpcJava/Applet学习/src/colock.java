import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Calendar;

import javax.swing.JFrame;

public class colock extends JFrame implements Runnable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile BufferedImage boardDrawing;//volatile是程度较轻的 synchronized
    private volatile BufferedImage boardDisplaying;
   
    public colock()
    {
        setTitle("当前时间");//标题名称
        setSize(300, 300);//展示框的大小
        setLocation(0,100);//初始展现的位置
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
       
       boardDrawing = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
       boardDisplaying = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
    }
   
   public void paint(Graphics g) {
       g.drawImage(boardDisplaying, 0, 0, null);
   }
   Font f1;
    @Override
    
    public void run() {
        while(this.isShowing())
        {
           Graphics g = boardDrawing.getGraphics();
          
           g.setColor(Color.BLACK);
           g.clearRect(0, 0, boardDrawing.getWidth(), boardDrawing.getHeight());//清除图形
           g.fillRect(0, 0, boardDrawing.getWidth(), boardDrawing.getHeight());//填充背景色为白色
          
           //画图
           //画出clock的表盘及数字
           
           g.setColor(Color.WHITE);
           g.drawOval(100, 100, 100, 100);
           g.drawString("12", 145, 115);
           g.drawString("6", 145, 195);
           g.drawString("9", 105, 155);
           g.drawString("3", 190, 155);
          
           //get Instance Time得到当前时间
           Calendar c=Calendar.getInstance();
           int week=c.get(Calendar.DAY_OF_WEEK);
           int month=c.get(Calendar.MONTH);
           int day=c.get(Calendar.DATE);
           int hour=c.get(Calendar.HOUR_OF_DAY);
           int minute=c.get(Calendar.MINUTE);
           int second=c.get(Calendar.SECOND);
           int year=c.get(Calendar.YEAR);
          
           //画出时针分针秒针
           DrawHands(g, second/60.0, 40);
           DrawHands(g, minute/60.0, 32);
           DrawHands(g, (hour)/12.0, 25);
          
           String[] weekName={"星期六","星期日","星期一","星期二","星期三","星期四","星期五"};
           String[] monthName={"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
          
           //画出显示时间的字符串
           g.drawString("张嘉豪的第一个界面时钟",20, 45);
           g.drawString(weekName[week],180, 215);
           g.drawString(year+"年"+monthName[month]+day+"日", 85, 215);
           g.drawString("TimeWalking", 200, 280);
          
           // 切换前景与背景工作区
           BufferedImage tmp = boardDisplaying;
           boardDisplaying = boardDrawing;
           boardDrawing = tmp;
           this.repaint();
          
           try {
                  Thread.sleep(500);
             } catch (Exception e) {
                  System.out.println(e);
             }
        }
    }
   
    //用g画出某根针（时分秒只是长度不同），percent表示从十二点到某指针现在的位置占整个圆周的百分比，length表示长度
    private void DrawHands(Graphics g,Double percent,int length)
    {
        double degree=360*percent;
        int x=(int)(150+Math.cos(2*Math.PI*(90-degree)/360)*length);
        int y=(int)(150-Math.sin(2*Math.PI*(90-degree)/360)*length);
       
        g.drawLine(150, 150, x, y);
    }
   
   public static void main(String[] args) {
      
      colock clock=new colock();
        new Thread(clock).start();
  }
}