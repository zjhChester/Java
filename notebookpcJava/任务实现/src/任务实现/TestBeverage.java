package ����ʵ��;
import java.util.Scanner;
public class TestBeverage{
	 public static void main(String[] args) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
		Beverage b1 = null, b2 = null, b3 = null, b4 = null;
		System.out.println("��ѡ��������Ҫ�����ϣ�\n1���ջ���\n2���̲�\n3������֭\n4����֭");
		int ChooseBeverage = input.nextInt();
		switch(ChooseBeverage)
		{
		case 1: b1 = new JUHUACHA("�ջ���");break;
		case 2: b2 = new NaiCha("�̲�");break;
		case 3: b3 = new LemonJuice("����֭");break;
		case 4: b4 = new OrangeJuice("��֭");break;
		}
		System.out.println("��ѡ�����ϵı��ͣ�\n1��С��\n2���б�\n3����");
		int ChooseType = input.nextInt();
		switch(ChooseType)
		{
		case 1:
			if(ChooseBeverage==1)b1.setCapacity(Beverage.SMALL);
			else if(ChooseBeverage==2)b2.setCapacity(Beverage.SMALL);
			else if(ChooseBeverage==3)b3.setCapacity(Beverage.SMALL);
			else if(ChooseBeverage==4)b4.setCapacity(Beverage.SMALL);break;
		case 2:
			if(ChooseBeverage==1)b1.setCapacity(Beverage.MEDIUM);
			else if(ChooseBeverage==2)b2.setCapacity(Beverage.MEDIUM);
			else if(ChooseBeverage==3)b3.setCapacity(Beverage.MEDIUM);
			else if(ChooseBeverage==4)b4.setCapacity(Beverage.MEDIUM);break;
		case 3:
			if(ChooseBeverage==1)b1.setCapacity(Beverage.LARGE);
			else if(ChooseBeverage==2)b2.setCapacity(Beverage.LARGE);
			else if(ChooseBeverage==3)b3.setCapacity(Beverage.LARGE);
			else if(ChooseBeverage==4)b4.setCapacity(Beverage.LARGE);break;
		}
		System.out.println("�Ƿ���Ҫ�ӱ���:\n1������Ҫ\n2����Ҫ");
		int chooseYEGUO = input.nextInt();
		switch(chooseYEGUO)
		{
		case 1:break;
		
		case 2:
		if(ChooseBeverage==1) b1 = new BingTang(b1);
		else if(ChooseBeverage==2)b2=new BingTang(b2);
		else if(ChooseBeverage==3)b3=new BingTang(b3);
		else if(ChooseBeverage==4)b4=new BingTang(b4);
		}
		System.out.println("�Ƿ���Ҫ��ţ��:\n1������Ҫ\n2����Ҫ");
		int chooseBingTang = input.nextInt();
		switch(chooseBingTang)
		{
		case 1:break;
		case 2:
		if(ChooseBeverage==1)b1=new Milk(b1);
		else if(ChooseBeverage==2)b2=new Milk(b2);
		else if(ChooseBeverage==3)b3=new Milk(b3);
		else if(ChooseBeverage==4)b4=new Milk(b4);
		}
		System.out.println("�Ƿ���Ҫ��Ҭ��:\n1������Ҫ\n2����Ҫ");
		int choosemilk = input.nextInt();
		switch(choosemilk)
		{
		case 1:break;
		case 2:
		if(ChooseBeverage==1)b1=new YeGuo(b1);
		else if(ChooseBeverage==2)b2=new YeGuo(b2);
		else if(ChooseBeverage==3)b3=new YeGuo(b3);
		else if(ChooseBeverage==4)b4=new YeGuo(b4);break;
		}
		
		switch(ChooseBeverage)
		{
		case 1:System.out.println(b1.type()+b1.getdescription()+"�۸�:"+b1.price());break;
		case 2:System.out.println(b2.type()+b2.getdescription()+"�۸�:"+b2.price());break;
		case 3:System.out.println(b3.type()+b3.getdescription()+"�۸�:"+b3.price());break;
		case 4:System.out.println(b4.type()+b4.getdescription()+"�۸�:"+b4.price());break;
		}
		
		
	 }
	}

