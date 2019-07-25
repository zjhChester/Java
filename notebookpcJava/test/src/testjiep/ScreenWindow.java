package testjiep;
import java.awt.AWTException;  
import java.awt.Color;  
import java.awt.Cursor;  
import java.awt.Dimension;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Image;  
import java.awt.Rectangle;  
import java.awt.Robot;  
import java.awt.Toolkit;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.awt.event.MouseMotionListener;  
import java.awt.image.BufferedImage;  
  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
  
/** 
 * ȫ����ʾ�Ĵ���, �� Alt +��F4 �˳� 
 * @author pengranxiang 
 */  
public class ScreenWindow extends JFrame {  
    private static final long serialVersionUID = -3758062802950480258L;  
      
    private Image image;  
    private JLabel imageLabel;  
      
    //����ͼ��ͼ����ص���Ŀ����������ڴ�ֵ  
    private JLabel targetLabel;  
      
    private int x, y, xEnd, yEnd;   //���ڼ�¼�������ʼ�ͽ���������  
  
    public ScreenWindow(JLabel targetLabel) throws AWTException, InterruptedException {  
        //Ŀ�������ʼ��  
        this.targetLabel = targetLabel;  
          
        //ȡ����Ļ�ߴ�  
        Dimension screenDims = Toolkit.getDefaultToolkit().getScreenSize();  
        //ȡ��ȫ��Ļ��ͼ  
        image = GraphicsUtils.getScreenImage(0, 0, screenDims.width, screenDims.height);  
        //����չʾ��ͼ  
        imageLabel = new JLabel(new ImageIcon(image));  
        //�������imageLabel��ʱ��չʾΪ ʮ����  
        imageLabel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));  
          
        createAction();  
          
        this.getContentPane().add(imageLabel);  
          
        this.setUndecorated(true);  //ȥ������װ��  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);   //�������  
    }  
      
    /** 
     * ʵ�ּ������� 
     */  
    private void createAction() {  
        imageLabel.addMouseListener(new MouseAdapter() {  
            public void mouseClicked(MouseEvent e) {  
                if(e.getButton() == MouseEvent.BUTTON3) { //����Ҽ������¼�  
                    //�˳�ScreenWindow  
                    ScreenWindow.this.dispose();  
                }  
            }  
              
            public void mousePressed(MouseEvent e) {  
                x = e.getX();  
                y = e.getY();  
            }  
              
            public void mouseReleased(MouseEvent e) {  
                xEnd = e.getX();  
                yEnd = e.getY();  
                  
                //��굯��ʱ��ȡ�������ʼ������ɵľ��������ͼ��  
                try {  
                    //��Ϊ xEnd ���ܱ�  x С �����������ƶ�����ʼ����ȡ���н�Сֵ��xEnd - x ȡ�����ֵ�� ͬ������y  
                    image = GraphicsUtils.getScreenImage(Math.min(x, xEnd), Math.min(y, yEnd), Math.abs(xEnd - x), Math.abs(yEnd - y));  
                } catch (AWTException e1) {  
                    e1.printStackTrace();  
                } catch (InterruptedException e1) {  
                    e1.printStackTrace();  
                }  
                  
                //Ϊ�˲鿴��ͼЧ�����������ͼ�Ĳ��ִ���ȫ���Ľ�ͼչʾ  
                //imageLabel.setIcon(new ImageIcon(image));  
                  
                //�����صõ�ͼ�񣬼��ص�Ŀ�����targetLabel  
                targetLabel.setIcon(new ImageIcon(image));  
                  
                //�˳���ScreenWindow  
                ScreenWindow.this.dispose();  
            }  
        });  
          
        imageLabel.addMouseMotionListener(new MouseMotionListener() {  
            public void mouseDragged(MouseEvent e) {  
                //1. ȡ�����İ��µ���ƶ���ǰ������  
                xEnd = e.getX();  
                yEnd = e.getY();  
                  
                //2. ����һ������ͼ�ζ���BufferedImage�� bi  
                BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);  
                Graphics2D g2d = (Graphics2D)bi.getGraphics();  
                //3. ��ԭʼͼ�λ��� bi ��  
                g2d.drawImage(image, 0, 0, null);     
                g2d.setColor(Color.RED);            //���û�����ɫΪ��ɫ  
                //4. ����ȡ�õ����껭һ�����ε� bi ��  
                //����갴�µ����������϶��ĵ�ǰ�����껭���Σ���Ϊ��ͼ�����չʾ  
                //+1 �� -1 ��Ϊ�˷�ֹ��ͼʱ�����ο�Ҳ�ؽ�ȥ  
                g2d.drawRect(Math.min(x, xEnd) - 1, Math.min(y, yEnd) - 1, Math.abs(xEnd - x) + 1, Math.abs(yEnd - y) + 1);   
                g2d.dispose();  
                  
                //5. �� bi ������Ļ��  
                Graphics g = imageLabel.getGraphics();  
                g.drawImage(bi, 0, 0, null);  
                g.dispose();  
            }  
          
            public void mouseMoved(MouseEvent e) {  
                  
            }  
        });  
    }  
      
//  public static void main(String[] args) throws AWTException, InterruptedException {  
//      new ScreenWindow();  
//  }  
}  
  
class GraphicsUtils {  
    /** 
     * ��ͼ��Ļ���ƶ������ͼƬ 
     * @param x 
     * @param y 
     * @param w 
     * @param h 
     * @return ���ز��ֵ�BufferedImage���� 
     * @throws AWTException 
     * @throws InterruptedException 
     */  
    public static BufferedImage getScreenImage(int x, int y, int w, int h) throws AWTException, InterruptedException {  
        Robot robot = new Robot();  
        BufferedImage screen = robot.createScreenCapture(new Rectangle(x, y, w, h));  
        return screen;  
    }  
} 