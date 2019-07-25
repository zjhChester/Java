package 任务实现;

public abstract class Beverage {
	public final static int SMALL = 1;
	public final static int MEDIUM = 2;
	public final static int LARGE = 3;

	protected String description = "饮料";
	private int capacity = SMALL;
	
	public String getdescription(){
		return description;
	}
	
	public void setCapacity(int s){
		capacity = s;
	}
	public int getCapacity(){
		return capacity;
	}
	
	public abstract double price();
	public abstract String type();
}

class JUHUACHA extends Beverage{
	public JUHUACHA(String desc){
		description = desc;
	}
	public double price()
	{
		if(getCapacity() == Beverage.SMALL)
			return 6;
		else if(getCapacity() == Beverage.MEDIUM)
			return 8;
		else if(getCapacity() == Beverage.LARGE)
			return 10;
		else return 0;
	}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "小杯";
		else if(getCapacity() == Beverage.MEDIUM)
			return "中杯";
		else if(getCapacity() == Beverage.LARGE)
			return "大杯";
		else return "Null";
	}
}

class LemonJuice extends Beverage{
	public LemonJuice(String desc){
		description = desc;
	}
	public double price()
	{
		if(getCapacity() == Beverage.SMALL)
			return 5;
		else if(getCapacity() == Beverage.MEDIUM)
			return 7;
		else if(getCapacity() == Beverage.LARGE)
			return 9;
		else return 0;
	}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "小杯";
		else if(getCapacity() == Beverage.MEDIUM)
			return "中杯";
		else if(getCapacity() == Beverage.LARGE)
			return "大杯";
		else return "Null";
	}
}

class NaiCha extends Beverage{
	public NaiCha(String desc){
		description = desc;
	}
	public double price()
	{
		if(getCapacity() == Beverage.SMALL)
			return 6;
		else if(getCapacity() == Beverage.MEDIUM)
			return 8;
		else if(getCapacity() == Beverage.LARGE)
			return 10;
		else return 0;
	}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "小杯";
		else if(getCapacity() == Beverage.MEDIUM)
			return "中杯";
		else if(getCapacity() == Beverage.LARGE)
			return "大杯";
		else return "Null";
	}
}

class OrangeJuice extends Beverage{
	public OrangeJuice(String desc){
		description = desc;
	}
	public double price()
	{
		if(getCapacity() == Beverage.SMALL)
			return 5;
		else if(getCapacity() == Beverage.MEDIUM)
			return 7;
		else if(getCapacity() == Beverage.LARGE)
			return 9;
		else return 0;
	}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "小杯";
		else if(getCapacity() == Beverage.MEDIUM)
			return "中杯";
		else if(getCapacity() == Beverage.LARGE)
			return "大杯";
		else return "Null";
	}
}

 abstract class TiaoLiao extends Beverage{
	public abstract String getDescription();
}

 class BingTang extends TiaoLiao{
	Beverage beverage;
	public BingTang(Beverage b){
		beverage = b;
	}
	public String getDescription(){
		return beverage.getdescription()+"加冰糖";
	}
	public double price()
		{
			if(getCapacity() == Beverage.SMALL)
				return 0.5 + beverage.price();
			else if(getCapacity() == Beverage.MEDIUM)
				return 1 + beverage.price();
			else if(getCapacity() == Beverage.LARGE)
				return 1.5 + beverage.price();
			else return 0;
		}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "加冰糖";
		else if(getCapacity() == Beverage.MEDIUM)
			return "加冰糖";
		else if(getCapacity() == Beverage.LARGE) 
			return "加冰糖";
		else return "Null";
	}
 }
 
 class Milk extends TiaoLiao
 {
	Beverage beverage;
	public Milk(Beverage b){
		beverage = b;
	}
	public String getDescription(){
		return beverage.getdescription()+"加牛奶";
	}
	public double price()
		{
			if(getCapacity() == Beverage.SMALL)
				return 1 + beverage.price();
			else if(getCapacity() == Beverage.MEDIUM)
				return 1.5 + beverage.price();
			else if(getCapacity() == Beverage.LARGE)
				return 2 + beverage.price();
			else return 0;
		}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "加牛奶";
		else if(getCapacity() == Beverage.MEDIUM)
			return "加牛奶";
		else if(getCapacity() == Beverage.LARGE)
			return "加牛奶";
		else return "Null";
	}
 }
 
 class YeGuo extends TiaoLiao
 {
	Beverage beverage;
	public YeGuo(Beverage b){
		beverage = b;
	}
	public String getDescription(){
		return beverage.getdescription()+"加椰果";
	}
	public double price()
		{
			if(getCapacity() == Beverage.SMALL)
				return 1 + beverage.price();
			else if(getCapacity() == Beverage.MEDIUM)
				return 1.5 + beverage.price();
			else if(getCapacity() == Beverage.LARGE)
				return 2 + beverage.price();
			else return 0;
		}
	public String type(){
		if(getCapacity() == Beverage.SMALL)
			return "加椰果";
		else if(getCapacity() == Beverage.MEDIUM)
			return "加椰果";
		else if(getCapacity() == Beverage.LARGE)
			return "加椰果";
		else return "Null";
	}
 }
 

 