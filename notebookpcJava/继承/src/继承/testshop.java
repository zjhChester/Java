package �̳�;
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
		printer office = new printer("����","����",'L',1700,2500);
		treadmill sports = new treadmill("�ܲ���","����Ƥ�ﳧ",'s',4000,5000);
		shop s1 = new shop("����Ƥ�ﳧ","����",2000000);
		System.out.println("CSZW����Ϊ������");
		int check = 1;
		do
		{
				System.out.println("����Ҫ����һ����Ʒ���в�����\n1��������Ʒ\n2���칫��Ʒ");
				int choose = 0;
			
				choose = input.nextInt();
			
				switch(choose)
				{
				case 1:System.out.println("����ǰѡ��Ϊ��������Ʒ\n��ǰ������Ʒ����Ʒ�����ܲ���\n������ô������\n1������\n2������"); 
						int choose1 = 0;
						choose1 = input.nextInt();
						switch(choose1)
						{
						case 1:  
						int number=0;
						do
						{
							if(number*sports.Dprice>s1.money)
								System.out.println("�ʽ��㣡");
							System.out.println("���������������");
							
							number = input.nextInt();
						}while(number*sports.Dprice>s1.money);
						sports.inProduct(s1, number);
						
						System.out.println("1����ӡ������Ϣ");
							System.out.println("��Ʒ����\t�ܲ���\n��������:\t"+number+"\n���ۣ�\t"+sports.Dprice+"\n�ܽ��:"+number*sports.Dprice+"\nʣ���ʽ�\t"+s1.money);break;
						case 2:
							int number1 = 0;
						
							if(number1*sports.Dprice>s1.money)
								System.out.println("�ʽ��㣡");
							System.out.println("�뵱��������������");
							
							number1 = input.nextInt();
						sports.outProduct(s1, number1);
						
						System.out.println("1����ӡ������Ϣ");
							System.out.println("��Ʒ����\t�ܲ���\n��������:\t"+number1+"\n���ۣ�\t"+sports.Xprice+"\n�ܽ��:"+number1*sports.Xprice+"\nʣ���ʽ�\t"+s1.money);
						break;
						}break;
				case 2:System.out.println("����ǰѡ��Ϊ���칫��Ʒ\n��ǰ�칫��Ʒ����Ʒ���д�ӡ��\n������ô������\n1������\n2������"); 
				int choose2 = 0;
				choose2 = input.nextInt();
				switch(choose2)
				{
				case 1:  
				int number=0;
				do
				{
					if(number*office.Dprice>s1.money)
						System.out.println("�ʽ��㣡");
					System.out.println("���������������");
					
					number = input.nextInt();
				}while(number*office.Dprice>s1.money);
				office.inProduct(s1, number);
				
				System.out.println("1����ӡ������Ϣ");
					System.out.println("��Ʒ����\t��ӡ��\n��������:\t"+number+"\n���ۣ�\t"+office.Dprice+"\n�ܽ��:"+number*office.Dprice+"\nʣ���ʽ�\t"+s1.money);break;
				case 2:
					int number1 = 0;
				
					if(number1*office.Dprice>s1.money)
						System.out.println("�ʽ��㣡");
					System.out.println("�뵱��������������");
					
					number1 = input.nextInt();
					office.outProduct(s1, number1);
				
				System.out.println("1����ӡ������Ϣ");
					System.out.println("��Ʒ����\t��ӡ��\n��������:\t"+number1+"\n���ۣ�\t"+office.Xprice+"\n�ܽ��:"+number1*office.Xprice+"\nʣ���ʽ�\t"+s1.money);
				break;
				}break;
				}
			}while(check==1);
	}
}
