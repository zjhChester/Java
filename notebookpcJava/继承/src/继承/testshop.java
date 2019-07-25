package 继承;
import java.util.Scanner;
class shop{
	String SName;
	String BName;
	double money;
	shop(String SName,String BName,double money){
		this.SName = SName;
		this.BName = BName;
		this.money = money;
	}
}
class sportgoods{
	String PName;
	String factory;
	char size;
	double Dprice;
	double Xprice;
sportgoods(String PName,String factory,char size,double Dprice,double Xprice){
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
	char size;
	double Dprice;
	double Xprice;
	officesupplies(String PName,String factory,char size,double Dprice,double Xprice){
		this.PName = PName;
		this.factory = factory;
		this.size = size;
		this.Dprice = Dprice;
		this.Xprice = Xprice;
	}
}

class treadmill extends sportgoods{
	treadmill(String PName,String factory,char size,double Dprice,double Xprice){
		super(PName,factory,size,Dprice,Xprice);
	
	}
	
	void inProduct(shop s1,int number){
		s1.money -=number*Dprice;
	}
	void outProduct(shop s1,int number){
		s1.money +=number*Xprice;
	}
}
class printer extends officesupplies{
	printer(String PName,String factory,char size,double Dprice,double Xprice){
		super(PName,factory,size,Dprice,Xprice);
	
	}
	void inProduct(shop s1,int number){
		s1.money -=number*Dprice;
	}
	void outProduct(shop s1,int number){
		s1.money +=number*Xprice;
	}
}
public class testshop {
			
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		printer office = new printer("东厂","西厂",'L',1700,2500);
		treadmill sports = new treadmill("跑步机","川北皮革厂",'s',4000,5000);
		shop s1 = new shop("江南皮革厂","王贺",2000000);
		System.out.println("CSZW集团为您服务！");
		int check = 1;
		do
		{
				System.out.println("您需要对哪一种商品进行操作：\n1、体育用品\n2、办公用品");
				int choose = 0;
			
				choose = input.nextInt();
			
				switch(choose)
				{
				case 1:System.out.println("您当前选择为：体育用品\n当前体育用品的商品仅有跑步机\n您想怎么操作：\n1、进货\n2、销货"); 
						int choose1 = 0;
						choose1 = input.nextInt();
						switch(choose1)
						{
						case 1:  
						int number=0;
						do
						{
							if(number*sports.Dprice>s1.money)
								System.out.println("资金不足！");
							System.out.println("请输入进货数量：");
							
							number = input.nextInt();
						}while(number*sports.Dprice>s1.money);
						sports.inProduct(s1, number);
						
						System.out.println("1、打印进货信息");
							System.out.println("产品名：\t跑步机\n进货数量:\t"+number+"\n单价：\t"+sports.Dprice+"\n总金额:"+number*sports.Dprice+"\n剩余资金：\t"+s1.money);break;
						case 2:
							int number1 = 0;
						
							if(number1*sports.Dprice>s1.money)
								System.out.println("资金不足！");
							System.out.println("请当年你销货数量：");
							
							number1 = input.nextInt();
						sports.outProduct(s1, number1);
						
						System.out.println("1、打印销货信息");
							System.out.println("产品名：\t跑步机\n销货数量:\t"+number1+"\n单价：\t"+sports.Xprice+"\n总金额:"+number1*sports.Xprice+"\n剩余资金：\t"+s1.money);
						break;
						}break;
				case 2:System.out.println("您当前选择为：办公用品\n当前办公用品的商品仅有打印机\n您想怎么操作：\n1、进货\n2、销货"); 
				int choose2 = 0;
				choose2 = input.nextInt();
				switch(choose2)
				{
				case 1:  
				int number=0;
				do
				{
					if(number*office.Dprice>s1.money)
						System.out.println("资金不足！");
					System.out.println("请输入进货数量：");
					
					number = input.nextInt();
				}while(number*office.Dprice>s1.money);
				office.inProduct(s1, number);
				
				System.out.println("1、打印进货信息");
					System.out.println("产品名：\t打印机\n进货数量:\t"+number+"\n单价：\t"+office.Dprice+"\n总金额:"+number*office.Dprice+"\n剩余资金：\t"+s1.money);break;
				case 2:
					int number1 = 0;
				
					if(number1*office.Dprice>s1.money)
						System.out.println("资金不足！");
					System.out.println("请当年你销货数量：");
					
					number1 = input.nextInt();
					office.outProduct(s1, number1);
				
				System.out.println("1、打印销货信息");
					System.out.println("产品名：\t打印机\n销货数量:\t"+number1+"\n单价：\t"+office.Xprice+"\n总金额:"+number1*office.Xprice+"\n剩余资金：\t"+s1.money);
				break;
				}break;
				}
			}while(check==1);
	}
}
