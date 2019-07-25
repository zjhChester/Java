package 任务实现;
import java.util.Scanner;
public class TestBeverage{
	 public static void main(String[] args) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
		Beverage b1 = null, b2 = null, b3 = null, b4 = null;
		System.out.println("请选择您所需要的饮料：\n1、菊花茶\n2、奶茶\n3、柠檬汁\n4、橙汁");
		int ChooseBeverage = input.nextInt();
		switch(ChooseBeverage)
		{
		case 1: b1 = new JUHUACHA("菊花茶");break;
		case 2: b2 = new NaiCha("奶茶");break;
		case 3: b3 = new LemonJuice("柠檬汁");break;
		case 4: b4 = new OrangeJuice("橙汁");break;
		}
		System.out.println("请选择饮料的杯型：\n1、小杯\n2、中杯\n3、大杯");
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
		System.out.println("是否需要加冰糖:\n1、不需要\n2、需要");
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
		System.out.println("是否需要加牛奶:\n1、不需要\n2、需要");
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
		System.out.println("是否需要加椰果:\n1、不需要\n2、需要");
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
		case 1:System.out.println(b1.type()+b1.getdescription()+"价格:"+b1.price());break;
		case 2:System.out.println(b2.type()+b2.getdescription()+"价格:"+b2.price());break;
		case 3:System.out.println(b3.type()+b3.getdescription()+"价格:"+b3.price());break;
		case 4:System.out.println(b4.type()+b4.getdescription()+"价格:"+b4.price());break;
		}
		
		
	 }
	}

