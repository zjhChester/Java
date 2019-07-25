package 作业;
import java.util.Scanner;
public class testBank
{
	public static void main(String[] args)
	{
		Bank b1 = new Bank();
		Bank b2 = new Bank();
		
		b1.cardNumber = 2222;
		b1.password = 123456;
		b1.balance = 5000;
		b2.cardNumber = 1111;
		b2.password = 654321;
		b2.balance = 1000;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int checkNumber = 0;
		int newN;
		do
		{
			
			System.out.println("*******************");
			System.out.print("欢迎来到JAVA银行！\n请输入您的卡号后四位：");
			newN = input.nextInt();
			
			if(newN == 1111) 
			{
				System.out.print("请输入密码：");
				int newP = input.nextInt();
				b2.connect(newN, newP);
				if(b2.connected==1) b2.display();
			}
			else if(newN == 2222)
			{
				System.out.print("请输入密码：");
				int newP = input.nextInt();
				b1.connect(newN, newP);
				if(b1.connected==1) b1.display();
			}
			else 
				{
					checkNumber = 1;
					System.out.println("读卡失败，请重新输入卡号后四位：");
				}
		}while(!(b1.connected!=0 || b2.connected!=0));
		
		int choose;
		do
		{
			System.out.print("1、取款\n2、转账\n3、退卡\n4、换卡\n请选择：  ");
			choose = input.nextInt();
			switch(choose)
			
			{
			case 1:
				if(newN == 1111) 
				{
					b2.getMoney();
					System.out.println("1、查看取款结果");
					int result = input.nextInt();
					if(result == 1)
					{
						System.out.println("*******************");
						System.out.println("取款详情:\n取款 账号： 6225 8888 6666 3333 "+b2.cardNumber+"\n取款金额:  "+b2.getMoney+" 元\n当前余额：  "+b2.balance+" 元");
					}
				}
				else if(newN == 2222)
				{
					b1.getMoney();
					System.out.println("1、查看取款结果");
					int result = input.nextInt();
					if(result == 1)
					{
						System.out.println("*******************");
						System.out.println("取款详情:\n取款账号： 6225 8888 6666 3333 "+b1.cardNumber+"\n取款金额:  "+b1.getMoney+" 元\n当前余额：  "+b1.balance+" 元");
					}
				}break;
				
			case 2:
				if(newN == 1111)	
				{
					b2.moveBalance();
					b1.balance+=b2.inputBalance;
					System.out.println("1、查看转账结果");
					int result = input.nextInt();
					if(result == 1)
					{
						System.out.println("*******************");
						System.out.println("转账详情:\n转出账号： 6225 8888 6666 3333 "+b2.cardNumber+"\n转入账号： 6225 8888 6666 3333  "+b1.cardNumber+"\n转账金额:  "+b2.inputBalance+" 元\n当前余额：  "+b2.balance+" 元");
					}
				}
				else if(newN == 2222)
				{
					b1.moveBalance();
					b2.balance+=b1.inputBalance;
					System.out.println("1、查看转账结果");
					int result = input.nextInt();
					if(result == 1) 
					{
						System.out.println("*******************");
						System.out.println("转账详情:\n转出账号： 6225 8888 6666 3333  "+b1.cardNumber+"\n转入账号： 6225 8888 6666 3333  "+b2.cardNumber+"\n转账金额:  "+b1.inputBalance+" 元\n当前余额：  "+b1.balance+" 元");
					}
					break;
				}
			case 3: break;
			case 4:
				do
				{
					checkNumber = 0;
					System.out.println("*******************");
					System.out.print("欢迎来到JAVA银行！\n请输入您的卡号后四位：");
					newN = input.nextInt();
					
					if(newN == 1111) 
					{
						System.out.print("请输入密码：");
						int newP = input.nextInt();
						if (newP != b2.password) checkNumber = 1;
						b2.connect(newN, newP);
						if(b2.connected==1) b2.display();
					}
					else if(newN == 2222)
					{
						System.out.print("请输入密码：");
						int newP = input.nextInt();
						if (newP != b1.password) checkNumber = 1;
						b1.connect(newN, newP);
						if(b1.connected==1) b1.display();
					}
					else 
						{
							checkNumber = 1;
							System.out.println("读卡失败，请重新输入卡号后四位");
						}
				}while(checkNumber!=0);break;
				default :System.out.println("输入序号有误 请重新输入"); 
		}
		}while(choose!=3);
		System.out.println("谢谢您的使用！");
	}
}
