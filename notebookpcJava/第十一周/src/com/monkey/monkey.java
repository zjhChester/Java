package com.monkey;

public class monkey {
		public static void main(String[] args) 
		{
			//iΪ����
			int x;
			for(int i=0;i<50000;i++)
			{
				if(i%5==1)
				{
					x = (i-1)*4/5; //��1ֻ����
					if(x%5==1)
					{
						x = (x-1)*4/5;//��2ֻ����
						if(x%5==1)
						{
							x = (x-1)*4/5;//��3ֻ���� 
							if(x%5==1)
							{
								x = (x-1)*4/5;//��4ֻ���� 
								if(x%5==1)
								{
									//��5ֻ���� 
									System.out.println(i);
								}
							}
						}
					}
				}
			}
			
			
			
		}
}
