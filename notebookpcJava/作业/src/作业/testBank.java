package ��ҵ;
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
			System.out.print("��ӭ����JAVA���У�\n���������Ŀ��ź���λ��");
			newN = input.nextInt();
			
			if(newN == 1111) 
			{
				System.out.print("���������룺");
				int newP = input.nextInt();
				b2.connect(newN, newP);
				if(b2.connected==1) b2.display();
			}
			else if(newN == 2222)
			{
				System.out.print("���������룺");
				int newP = input.nextInt();
				b1.connect(newN, newP);
				if(b1.connected==1) b1.display();
			}
			else 
				{
					checkNumber = 1;
					System.out.println("����ʧ�ܣ����������뿨�ź���λ��");
				}
		}while(!(b1.connected!=0 || b2.connected!=0));
		
		int choose;
		do
		{
			System.out.print("1��ȡ��\n2��ת��\n3���˿�\n4������\n��ѡ��  ");
			choose = input.nextInt();
			switch(choose)
			
			{
			case 1:
				if(newN == 1111) 
				{
					b2.getMoney();
					System.out.println("1���鿴ȡ����");
					int result = input.nextInt();
					if(result == 1)
					{
						System.out.println("*******************");
						System.out.println("ȡ������:\nȡ�� �˺ţ� 6225 8888 6666 3333 "+b2.cardNumber+"\nȡ����:  "+b2.getMoney+" Ԫ\n��ǰ��  "+b2.balance+" Ԫ");
					}
				}
				else if(newN == 2222)
				{
					b1.getMoney();
					System.out.println("1���鿴ȡ����");
					int result = input.nextInt();
					if(result == 1)
					{
						System.out.println("*******************");
						System.out.println("ȡ������:\nȡ���˺ţ� 6225 8888 6666 3333 "+b1.cardNumber+"\nȡ����:  "+b1.getMoney+" Ԫ\n��ǰ��  "+b1.balance+" Ԫ");
					}
				}break;
				
			case 2:
				if(newN == 1111)	
				{
					b2.moveBalance();
					b1.balance+=b2.inputBalance;
					System.out.println("1���鿴ת�˽��");
					int result = input.nextInt();
					if(result == 1)
					{
						System.out.println("*******************");
						System.out.println("ת������:\nת���˺ţ� 6225 8888 6666 3333 "+b2.cardNumber+"\nת���˺ţ� 6225 8888 6666 3333  "+b1.cardNumber+"\nת�˽��:  "+b2.inputBalance+" Ԫ\n��ǰ��  "+b2.balance+" Ԫ");
					}
				}
				else if(newN == 2222)
				{
					b1.moveBalance();
					b2.balance+=b1.inputBalance;
					System.out.println("1���鿴ת�˽��");
					int result = input.nextInt();
					if(result == 1) 
					{
						System.out.println("*******************");
						System.out.println("ת������:\nת���˺ţ� 6225 8888 6666 3333  "+b1.cardNumber+"\nת���˺ţ� 6225 8888 6666 3333  "+b2.cardNumber+"\nת�˽��:  "+b1.inputBalance+" Ԫ\n��ǰ��  "+b1.balance+" Ԫ");
					}
					break;
				}
			case 3: break;
			case 4:
				do
				{
					checkNumber = 0;
					System.out.println("*******************");
					System.out.print("��ӭ����JAVA���У�\n���������Ŀ��ź���λ��");
					newN = input.nextInt();
					
					if(newN == 1111) 
					{
						System.out.print("���������룺");
						int newP = input.nextInt();
						if (newP != b2.password) checkNumber = 1;
						b2.connect(newN, newP);
						if(b2.connected==1) b2.display();
					}
					else if(newN == 2222)
					{
						System.out.print("���������룺");
						int newP = input.nextInt();
						if (newP != b1.password) checkNumber = 1;
						b1.connect(newN, newP);
						if(b1.connected==1) b1.display();
					}
					else 
						{
							checkNumber = 1;
							System.out.println("����ʧ�ܣ����������뿨�ź���λ");
						}
				}while(checkNumber!=0);break;
				default :System.out.println("����������� ����������"); 
		}
		}while(choose!=3);
		System.out.println("лл����ʹ�ã�");
	}
}
