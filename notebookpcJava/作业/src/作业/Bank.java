package ��ҵ;
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
				System.out.println("��¼�ɹ���\n��ӭ����JAVA���У�");
				connected = 1;
			}
			else System.out.println("�������������������");
		}
		else System.out.println("����ʧ�ܣ����鿨�ţ�");
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
			System.out.print("������ȡ���  ");
			 getMoney = input.nextDouble();
			if(getMoney == 0)
			{
				checkNumber=1;
				System.out.println("������Ľ��Ϊ 0 Ԫ��������������룡");
			}
			else if(getMoney > balance)
			{
				checkNumber=1;
				System.out.println("���㣬������������룡");
			}
			else 
			{
				balance -= getMoney;
			}
		}while(checkNumber!=0);
		System.out.println("ȡ��ɹ���");
	}
	void moveBalance()
	{
		int checkMoveBalance=0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.print("����������ת���˺ţ�");
			int ID = input.nextInt();
			if(ID == cardNumber) 
			{
				checkMoveBalance =0;
				checkMoveBalance ++;
				System.out.println("�����ܸ��Լ�ת�ˣ�����������");
			}
			else if(ID == 2222 || ID == 1111) break;
			else
			{
				checkMoveBalance =0;
				checkMoveBalance ++;
				System.out.println("��������˺����������ԣ�");
			}
		}while(checkMoveBalance!=0);
		int checkmoney=0;
		System.out.print("У�쿨�ųɹ���");
		do
		{
			System.out.print("������ת�˽�\t");
			inputBalance = input.nextDouble();
			if(inputBalance>balance) 
			{
				checkmoney++;
				System.out.println("�����ת�˽��������������������룡");
			}
			else if(inputBalance==0)
			{
				checkmoney++;
				System.out.println("�������ת�˽��Ϊ0������������룡");
			}
			else break;
		}while(checkmoney!=0);
		balance -=inputBalance;
		System.out.println("ת�˳ɹ���");
	}
	void display()
	{
		System.out.println("*******************");
		System.out.println("����� 6225 8888 6666 3333 "+cardNumber+" \n�û�����!�������ÿ���Ϣ���£�\n"+"���ţ� 6225 8888 6666 3333 "+cardNumber+"\n��  "+balance+" Ԫ");
	}
}
