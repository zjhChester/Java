package com.shop;
import java.util.Scanner;
class shop{
	String SName;
	String BName;
	private double money;
	shop(String SName,String BName,double money){
		this.SName = SName;
		this.BName = BName;
		this.money = money;
	}
	double getmoney(){
		return money;
	}
	void selloffice(printer office,int number,String size){
		office.size = size;
		if(office.size=="A") {
			money += number*office.AXprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+office.PName+"\n���������� "+number+"\n�������ۣ� "+office.AXprice+"\n��ǰ�ʽ��� "+money);
		}
		else if(office.size=="B") {
			money += number*office.BXprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+office.PName+"\n���������� "+number+"\n�������ۣ� "+office.BXprice+"\n��ǰ�ʽ��� "+money);
		}
	}
	void sellsports(treadmill sports,int number,String size){
		sports.size = size;
		if(sports.size=="A") {
			money += number*sports.AXprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+sports.PName+"\n���������� "+number+"\n�������ۣ� "+sports.AXprice+"\n��ǰ�ʽ��� "+money);
		}
		else if(sports.size=="B") {
			money += number*sports.BXprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+sports.PName+"\n���������� "+number+"\n�������ۣ� "+sports.BXprice+"\n��ǰ�ʽ��� "+money);
		}
	}
	void buyoffice(printer office,int number,String size){
		office.size = size;
		if(office.size=="A") {
			money -= number*office.ADprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+office.PName+"\n���������� "+number+"\n�������ۣ� "+office.ADprice+"\n��ǰ�ʽ��� "+money);
		}
		else if(office.size=="B") {
			money -= number*office.BDprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+office.PName+"\n���������� "+number+"\n�������ۣ� "+office.BDprice+"\n��ǰ�ʽ��� "+money);
		}
	}
	void buysports(treadmill sports,int number,String size){
		sports.size = size;
		if(sports.size=="A") {
			money -= number*sports.ADprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+sports.PName+"\n���������� "+number+"\n�������ۣ� "+sports.ADprice+"\n��ǰ�ʽ��� "+money);
		}
		else if(sports.size=="B") {
			money -= number*sports.BDprice;
			System.out.println("\n��ǰ������Ϣ��\n������Ʒ�� "+size+"��"+sports.PName+"\n���������� "+number+"\n�������ۣ� "+sports.BDprice+"\n��ǰ�ʽ��� "+money);
		}
		}
	
}
class sportgoods{
	String PName;
	String factory;
	String size;
	double Dprice;
	double Xprice;
sportgoods(String PName,String factory,String size,double Dprice,double Xprice){
		this.PName = PName;
		this.factory = factory;
		this.size = size;
		this.Dprice = Dprice;
		this.Xprice = Xprice;
	}
}
class officesupplies{
	String PName;
	String factory;
	String size;
	double Dprice;
	double Xprice;
	officesupplies(String PName,String factory,String size,double Dprice,double Xprice){
		this.PName = PName;
		this.factory = factory;
		this.size = size;
		this.Dprice = Dprice;
		this.Xprice = Xprice;
	}
}

class treadmill extends sportgoods{
	double ADprice;
	double AXprice;
	double BDprice;
	double BXprice;

	treadmill(String PName,String factory,String size,double Dprice,double Xprice,double BDprice,double BXprice,double ADprice,double AXprice){
		super(PName,factory,size, Dprice, Xprice);
		this.ADprice = ADprice;
		this.AXprice = AXprice;
		this.BDprice = BDprice;
		this.BXprice = BXprice;
	
	}
}
class printer extends officesupplies{
	double ADprice;
	double AXprice;
	double BDprice;
	double BXprice;

	printer(String PName,String factory,String size,double Dprice,double Xprice,double BDprice,double BXprice,double ADprice,double AXprice){
		super(PName,factory,size, Dprice, Xprice);
		this.ADprice = ADprice;
		this.AXprice = AXprice;
		this.BDprice = BDprice;
		this.BXprice = BXprice;
	}
}
public class TestShop {
	public static void main(String[] args) {
		
	@SuppressWarnings("resource")
	Scanner input = new Scanner(System.in);
	shop shop = new shop("�����̰�","ZWSQ",5000000);
	printer printer = new printer("��ӡ��","�ֻ��칫�ϳ�","A",0,0,1200,1500,1500,1700);
	treadmill treadmill = new treadmill("�ܲ���","�ֻ���������","A",0,0,3500,4000,3400,3900);
	int number = 0;
	int checknumber=0;
	do
	{
	System.out.println(shop.SName+"��ӭ��!\n��ӭ������Ʒ����/������̨����ϵͳ��\n");
	System.out.print("��ѡ���Ʒ����ѡ�\n1������\n2������\n����ѡ���ǣ� ");
	int choose = input.nextInt();
	switch(choose)
	{
	case 1:System.out.print("\n����ǰ��ѡ���ǣ� ����\n�������ʲô��Ʒ��\n1��������Ʒ\n2���칫��Ʒ\n����ѡ���ǣ� ");
			int productChoose = input.nextInt();
			switch(productChoose)
			{
			case 1:
				System.out.print("\n����ǰ��ѡ���ǣ� ������Ʒ\n"+treadmill.factory+"��ӭ����\n��ǰ��Ʒ:\n1��A���ܲ���:"+treadmill.ADprice+"\n2��B���ܲ���:"+treadmill.BDprice+"\n����ѡ���ǣ�" );
				int TsizeChoose = input.nextInt();
				switch(TsizeChoose)
				{
				case 1: 
					do{
						if(number*treadmill.ADprice>shop.getmoney())
							System.out.println("�ʽ����㣡���������빺��������");
						System.out.print("����������Ҫ������������\t");
						number = input.nextInt();
					}while(number*treadmill.ADprice>shop.getmoney());
			
					shop.buysports(treadmill, number, "A");
					break;
				case 2: 
				do{
					if(number*treadmill.BDprice>shop.getmoney())
						System.out.println("�ʽ����㣡���������빺��������");
					System.out.print("����������Ҫ������������\t");
					number = input.nextInt();
				}while(number*treadmill.BDprice>shop.getmoney());
		
				shop.buysports(treadmill, number, "B");
				}break;
			case 2:
				System.out.print("\n����ǰ��ѡ���ǣ� �칫��Ʒ\n"+printer.factory+"��ӭ����\n��ǰ��Ʒ:\n1��A���ӡ��:"+printer.ADprice+"\n2��B���ӡ��:"+printer.BDprice+"\n����ѡ���ǣ�" );
				int PsizeChoose = input.nextInt();
				switch(PsizeChoose)
				{
				case 1: 
					do{
						if(number*printer.ADprice>shop.getmoney())
							System.out.println("�ʽ����㣡���������빺��������");
						System.out.print("����������Ҫ������������\t");
						number = input.nextInt();
					}while(number*printer.ADprice>shop.getmoney());
			
					shop.buyoffice(printer, number, "A");
					break;
				case 2: 
				do{
					if(number*printer.BDprice>shop.getmoney())
						System.out.println("�ʽ����㣡���������빺��������");
					System.out.print("����������Ҫ������������\t");
					number = input.nextInt();
				}while(number*printer.BDprice>shop.getmoney());
		
				shop.buyoffice(printer, number, "B");
				}
			}break;
case 2:	System.out.print("\n����ǰ��ѡ���ǣ� ������\n�������ʲô��Ʒ��\n1��������Ʒ\n2���칫��Ʒ\n����ѡ���ǣ� ");
			 productChoose = input.nextInt();
			switch(productChoose)
			{
			case 1:
				System.out.print("\n����ǰ��ѡ���ǣ� ������Ʒ\n"+treadmill.factory+"��ӭ����\n��ǰ��Ʒ:\n1��A���ܲ���:"+treadmill.AXprice+"\n2��B���ܲ���:"+treadmill.BXprice+"\n����ѡ���ǣ�" );
				int TsizeChoose = input.nextInt();
				switch(TsizeChoose)
				{
				case 1: 					
						System.out.print("��������������������\t");
						number = input.nextInt();						
					shop.sellsports(treadmill, number, "A");
					break;
				case 2: 				
					System.out.print("��������������������\t");
					number = input.nextInt();						
				shop.sellsports(treadmill, number, "B");
				}break;
			case 2:
				System.out.print("\n����ǰ��ѡ���ǣ� �칫��Ʒ\n"+printer.factory+"��ӭ����\n��ǰ��Ʒ:\n1��A���ӡ��:"+printer.AXprice+"\n2��B���ӡ��:"+printer.BXprice+"\n����ѡ���ǣ�" );
				int PsizeChoose = input.nextInt();
				switch(PsizeChoose)
				{
				case 1: 
						System.out.print("��������������������\t");
						number = input.nextInt();
					shop.selloffice(printer, number, "A");
					break;
				case 2: 				
					System.out.print("��������������������\t");
					number = input.nextInt();					
				shop.selloffice(printer, number, "B");
				}
			}
	}
	System.out.print("\n�Ƿ������\n1������\n2���˳�\n����ѡ���ǣ�\t");
	checknumber = input.nextInt();
	}while(checknumber==1);
	System.out.println("лл����ʹ�ã��ټ���");
}
}
