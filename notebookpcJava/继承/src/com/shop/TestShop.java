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
			System.out.println("\n当前销货信息：\n销货产品： "+size+"类"+office.PName+"\n销货数量： "+number+"\n销货单价： "+office.AXprice+"\n当前资金余额： "+money);
		}
		else if(office.size=="B") {
			money += number*office.BXprice;
			System.out.println("\n当前销货信息：\n销货产品： "+size+"类"+office.PName+"\n销货数量： "+number+"\n销货单价： "+office.BXprice+"\n当前资金余额： "+money);
		}
	}
	void sellsports(treadmill sports,int number,String size){
		sports.size = size;
		if(sports.size=="A") {
			money += number*sports.AXprice;
			System.out.println("\n当前销货信息：\n销货产品： "+size+"类"+sports.PName+"\n销货数量： "+number+"\n销货单价： "+sports.AXprice+"\n当前资金余额： "+money);
		}
		else if(sports.size=="B") {
			money += number*sports.BXprice;
			System.out.println("\n当前销货信息：\n销货产品： "+size+"类"+sports.PName+"\n销货数量： "+number+"\n销货单价： "+sports.BXprice+"\n当前资金余额： "+money);
		}
	}
	void buyoffice(printer office,int number,String size){
		office.size = size;
		if(office.size=="A") {
			money -= number*office.ADprice;
			System.out.println("\n当前进货信息：\n进货产品： "+size+"类"+office.PName+"\n进货数量： "+number+"\n进货单价： "+office.ADprice+"\n当前资金余额： "+money);
		}
		else if(office.size=="B") {
			money -= number*office.BDprice;
			System.out.println("\n当前进货信息：\n进货产品： "+size+"类"+office.PName+"\n进货数量： "+number+"\n进货单价： "+office.BDprice+"\n当前资金余额： "+money);
		}
	}
	void buysports(treadmill sports,int number,String size){
		sports.size = size;
		if(sports.size=="A") {
			money -= number*sports.ADprice;
			System.out.println("\n当前进货信息：\n进货产品： "+size+"类"+sports.PName+"\n进货数量： "+number+"\n进货单价： "+sports.ADprice+"\n当前资金余额： "+money);
		}
		else if(sports.size=="B") {
			money -= number*sports.BDprice;
			System.out.println("\n当前进货信息：\n进货产品： "+size+"类"+sports.PName+"\n进货数量： "+number+"\n进货单价： "+sports.BDprice+"\n当前资金余额： "+money);
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
	shop shop = new shop("川北商霸","ZWSQ",5000000);
	printer printer = new printer("打印机","局怀办公南厂","A",0,0,1200,1500,1500,1700);
	treadmill treadmill = new treadmill("跑步机","局怀体育北厂","A",0,0,3500,4000,3400,3900);
	int number = 0;
	int checknumber=0;
	do
	{
	System.out.println(shop.SName+"欢迎你!\n欢迎来到商品进货/销货后台管理系统！\n");
	System.out.print("请选择产品操作选项：\n1、进货\n2、销货\n您的选择是： ");
	int choose = input.nextInt();
	switch(choose)
	{
	case 1:System.out.print("\n您当前的选择是： 进货\n您想进货什么产品：\n1、体育用品\n2、办公用品\n您的选择是： ");
			int productChoose = input.nextInt();
			switch(productChoose)
			{
			case 1:
				System.out.print("\n您当前的选择是： 体育用品\n"+treadmill.factory+"欢迎您！\n当前产品:\n1、A类跑步机:"+treadmill.ADprice+"\n2、B类跑步机:"+treadmill.BDprice+"\n您的选择是：" );
				int TsizeChoose = input.nextInt();
				switch(TsizeChoose)
				{
				case 1: 
					do{
						if(number*treadmill.ADprice>shop.getmoney())
							System.out.println("资金余额不足！请重新输入购入数量！");
						System.out.print("请输入您需要购进的数量：\t");
						number = input.nextInt();
					}while(number*treadmill.ADprice>shop.getmoney());
			
					shop.buysports(treadmill, number, "A");
					break;
				case 2: 
				do{
					if(number*treadmill.BDprice>shop.getmoney())
						System.out.println("资金余额不足！请重新输入购入数量！");
					System.out.print("请输入您需要购进的数量：\t");
					number = input.nextInt();
				}while(number*treadmill.BDprice>shop.getmoney());
		
				shop.buysports(treadmill, number, "B");
				}break;
			case 2:
				System.out.print("\n您当前的选择是： 办公用品\n"+printer.factory+"欢迎您！\n当前产品:\n1、A类打印机:"+printer.ADprice+"\n2、B类打印机:"+printer.BDprice+"\n您的选择是：" );
				int PsizeChoose = input.nextInt();
				switch(PsizeChoose)
				{
				case 1: 
					do{
						if(number*printer.ADprice>shop.getmoney())
							System.out.println("资金余额不足！请重新输入购入数量！");
						System.out.print("请输入您需要购进的数量：\t");
						number = input.nextInt();
					}while(number*printer.ADprice>shop.getmoney());
			
					shop.buyoffice(printer, number, "A");
					break;
				case 2: 
				do{
					if(number*printer.BDprice>shop.getmoney())
						System.out.println("资金余额不足！请重新输入购入数量！");
					System.out.print("请输入您需要购进的数量：\t");
					number = input.nextInt();
				}while(number*printer.BDprice>shop.getmoney());
		
				shop.buyoffice(printer, number, "B");
				}
			}break;
case 2:	System.out.print("\n您当前的选择是： 销货货\n您想进货什么产品：\n1、体育用品\n2、办公用品\n您的选择是： ");
			 productChoose = input.nextInt();
			switch(productChoose)
			{
			case 1:
				System.out.print("\n您当前的选择是： 体育用品\n"+treadmill.factory+"欢迎您！\n当前产品:\n1、A类跑步机:"+treadmill.AXprice+"\n2、B类跑步机:"+treadmill.BXprice+"\n您的选择是：" );
				int TsizeChoose = input.nextInt();
				switch(TsizeChoose)
				{
				case 1: 					
						System.out.print("请输入您卖出的数量：\t");
						number = input.nextInt();						
					shop.sellsports(treadmill, number, "A");
					break;
				case 2: 				
					System.out.print("请输入您卖出的数量：\t");
					number = input.nextInt();						
				shop.sellsports(treadmill, number, "B");
				}break;
			case 2:
				System.out.print("\n您当前的选择是： 办公用品\n"+printer.factory+"欢迎您！\n当前产品:\n1、A类打印机:"+printer.AXprice+"\n2、B类打印机:"+printer.BXprice+"\n您的选择是：" );
				int PsizeChoose = input.nextInt();
				switch(PsizeChoose)
				{
				case 1: 
						System.out.print("请输入您卖出的数量：\t");
						number = input.nextInt();
					shop.selloffice(printer, number, "A");
					break;
				case 2: 				
					System.out.print("请输入您卖出的数量：\t");
					number = input.nextInt();					
				shop.selloffice(printer, number, "B");
				}
			}
	}
	System.out.print("\n是否继续？\n1、继续\n2、退出\n您的选择是：\t");
	checknumber = input.nextInt();
	}while(checknumber==1);
	System.out.println("谢谢您的使用！再见！");
}
}
