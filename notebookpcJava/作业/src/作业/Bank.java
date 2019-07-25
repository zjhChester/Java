package 作业;
import java.util.Scanner;
class Bank {
	
	int cardNumber;
	int password;
	double balance;
	int connected;
	double inputBalance;
	double getMoney; 
	Bank(){
		cardNumber = 0;
		password = 0;
		balance = 0;
		connected = 0;
		inputBalance = 0;
		getMoney = 0; 
	}
	int connect(int newN, int newP)
	{
		if(cardNumber == newN)
		{	
			connected = 0;
			if(password == newP)
			{
				System.out.println("登录成功！\n欢迎来到JAVA银行！");
				connected = 1;
			}
			else System.out.println("密码错误！请检查输入密码");
		}
		else System.out.println("读卡失败，请检查卡号！");
		return connected;
	}
	void getMoney()
	{
		int checkNumber=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		do
		{	
			checkNumber = 0;
			System.out.print("请输入取款金额：  ");
			 getMoney = input.nextDouble();
			if(getMoney == 0)
			{
				checkNumber=1;
				System.out.println("您输入的金额为 0 元，请检查后重新输入！");
			}
			else if(getMoney > balance)
			{
				checkNumber=1;
				System.out.println("余额不足，请检查后重新输入！");
			}
			else 
			{
				balance -= getMoney;
			}
		}while(checkNumber!=0);
		System.out.println("取款成功！");
	}
	void moveBalance()
	{
		int checkMoveBalance=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.print("请输入您的转账账号：");
			int ID = input.nextInt();
			if(ID == cardNumber) 
			{
				checkMoveBalance =0;
				checkMoveBalance ++;
				System.out.println("您不能给自己转账！请重新输入");
			}
			else if(ID == 2222 || ID == 1111) break;
			else
			{
				checkMoveBalance =0;
				checkMoveBalance ++;
				System.out.println("您输入的账号有误，请重试！");
			}
		}while(checkMoveBalance!=0);
		int checkmoney=0;
		System.out.print("校检卡号成功！");
		do
		{
			System.out.print("请输入转账金额：\t");
			inputBalance = input.nextDouble();
			if(inputBalance>balance) 
			{
				checkmoney++;
				System.out.println("输入的转账金额大于您的余额！请重新输入！");
			}
			else if(inputBalance==0)
			{
				checkmoney++;
				System.out.println("您输入的转账金额为0请检查后重新输入！");
			}
			else break;
		}while(checkmoney!=0);
		balance -=inputBalance;
		System.out.println("转账成功！");
	}
	void display()
	{
		System.out.println("*******************");
		System.out.println("尊进的 6225 8888 6666 3333 "+cardNumber+" \n用户您好!您的信用卡信息如下：\n"+"卡号： 6225 8888 6666 3333 "+cardNumber+"\n余额：  "+balance+" 元");
	}
}
