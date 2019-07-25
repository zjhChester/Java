package com.intface;

public interface shapemethon {
	public double area(double height, double lenth,double width);
	public double length(double height, double lenth,double width); 
}

abstract class shape{
	String name;
	public shape(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
}

class circle extends shape implements shapemethon{
	String name;
	public circle(String name) {
		super(name);
		this.name = name;
	}
	double S,C;
	
	public double area(double r, double lenth,double width) {
		S = r*r*Math.PI;
		return S;
	}
	public double length(double r, double lenth,double width) {
		C = Math.PI*2*r;
		return C;
	}
	
}
class Rectangle extends shape  implements shapemethon{
	public Rectangle(String name) {
		super(name);
		this.name = name;
	}


	double S,C;

	public double area(double height, double lenth,double width) {
		S = lenth * width;
		return S;
	}


	public double length(double height, double lenth,double width) {
		C = 2*(width+lenth);
		return C;
	}
	
}
class triangle extends shape implements shapemethon{
//等腰直角三角形
	public triangle(String name) {
		super(name);
		
	}
	double S,C;
	
	public double area(double height, double button, double width) {
		S = button * height*0.5;
		return S;
	}


	public double length(double height, double button, double width) {
		C = height*button*Math.sqrt(2)*button;
		return C;
	}
	
}