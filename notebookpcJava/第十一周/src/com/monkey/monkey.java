package com.monkey;

public class monkey {
		public static void main(String[] args) 
		{
			//i为总数
			int x;
			for(int i=0;i<50000;i++)
			{
				if(i%5==1)
				{
					x = (i-1)*4/5; //第1只丢了
					if(x%5==1)
					{
						x = (x-1)*4/5;//第2只丢了
						if(x%5==1)
						{
							x = (x-1)*4/5;//第3只丢了 
							if(x%5==1)
							{
								x = (x-1)*4/5;//第4只丢了 
								if(x%5==1)
								{
									//第5只丢了 
									System.out.println(i);
								}
							}
						}
					}
				}
			}
			
			
			
		}
}
