package com.score;
/*class Date{
	int year,month,day;
	Date(int year ,int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
		System.out.println(year+""+month+""+day);
	}
	
}*/
class dog{
	private String name;
    private double weight;
	dog(String name ,double weight){
		this.name = name;
		
		this.weight = weight;
	}
	String getname()
	{
		return this.name;
	}
	double getweight(){
		return this.weight;
	}
}
public class Score {
public static void main(String[] args) {
	dog[] d = new dog[4];
	
	d[0] = new dog("»¨»¨",4.5f);
	d[1] = new dog("°×°×",4.7f);
	d[2] = new dog("ºÚºÚ",4.9f);
	d[3] = new dog("ºìºì",4.4f);
	
	double max=0;
	double min = 0;
	min = d[0].getweight();
	
	for(int i=0;i<d.length;i++)
	{
		if (max<d[i].getweight())
			max =  d[i].getweight();
	
			
		if (min>d[i].getweight())
			min = d[i].getweight();
	}
	System.out.println(max+"\t"+min);
}
	
}
