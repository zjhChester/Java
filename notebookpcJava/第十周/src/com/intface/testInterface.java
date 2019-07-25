package com.intface;


public class testInterface {
 public static void main(String args[]){
	 circle b = new circle("圆");
	System.out.println("圆的面积为"+b.area(5, 0, 0));
	System.out.println("圆的周长为"+ b.length(5, 0, 0));
	
	Rectangle r = new Rectangle("矩形");
	System.out.println("矩形的面积为"+ r.area(5, 6, 7));
	System.out.println("矩形的周长为"+ r.length(5, 6, 7));
	
	
	triangle t = new triangle("等腰直角三角形");
	System.out.println("三角形的面积为"+ t.area(5, 5, 0));
	System.out.println("三角形的周长为"+ t.length(5, 5, 0));
	
 }
}
