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
	private volatile BufferedImage boardDrawing;//volatile�ǳ̶Ƚ���� synchronized
    private volatile BufferedImage boardDisplaying;
   
    public colock()
    {
        setTitle("��ǰʱ��");//��������
        setSize(300, 300);//չʾ��Ĵ�С
        setLocation(0,100);//��ʼչ�ֵ�λ��
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
           g.clearRect(0, 0, boardDrawing.getWidth(), boardDrawing.getHeight());//���ͼ��
           g.fillRect(0, 0, boardDrawing.getWidth(), boardDrawing.getHeight());//��䱳��ɫΪ��ɫ
          
           //��ͼ
           //����clock�ı��̼�����
           
           g.setColor(Color.WHITE);
           g.drawOval(100, 100, 100, 100);
           g.drawString("12", 145, 115);
           g.drawString("6", 145, 195);
           g.drawString("9", 105, 155);
           g.drawString("3", 190, 155);
          
           //get Instance Time�õ���ǰʱ��
           Calendar c=Calendar.getInstance();
           int week=c.get(Calendar.DAY_OF_WEEK);
           int month=c.get(Calendar.MONTH);
           int day=c.get(Calendar.DATE);
           int hour=c.get(Calendar.HOUR_OF_DAY);
           int minute=c.get(Calendar.MINUTE);
           int second=c.get(Calendar.SECOND);
           int year=c.get(Calendar.YEAR);
          
           //����ʱ���������
           DrawHands(g, second/60.0, 40);
           DrawHands(g, minute/60.0, 32);
           DrawHands(g, (hour)/12.0, 25);
          
           String[] weekName={"������","������","����һ","���ڶ�","������","������","������"};
           String[] monthName={"1��","2��","3��","4��","5��","6��","7��","8��","9��","10��","11��","12��"};
          
           //������ʾʱ����ַ���
           g.drawString("�żκ��ĵ�һ������ʱ��",20, 45);
           g.drawString(weekName[week],180, 215);
           g.drawString(year+"��"+monthName[month]+day+"��", 85, 215);
           g.drawString("TimeWalking", 200, 280);
          
           // �л�ǰ���뱳��������
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
   
    //��g����ĳ���루ʱ����ֻ�ǳ��Ȳ�ͬ����percent��ʾ��ʮ���㵽ĳָ�����ڵ�λ��ռ����Բ�ܵİٷֱȣ�length��ʾ����
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