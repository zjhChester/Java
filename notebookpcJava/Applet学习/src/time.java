import java.awt.*;
import java.applet.*;
import java.util.Calendar;

public class time extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread t;
	Font f;
	Button b1, b2;

	public void init() {
		f = new Font("����", Font.BOLD, 30);
	}

	public void start() {
		if (t == null) {
			t = new Thread(this, "Time");
			t.start();
		}
	}

	public void run() {
		while (t != null) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	Font f1;

	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.setFont(f1 = new Font("����", Font.BOLD, 12));

		g.drawString("�żκ��ĵ�һ������С����", 13, 13);

		Calendar c = Calendar.getInstance();
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND), 50,
				100);
	}

	public void stop() {
		t = null;
	}
}
