package ผฬณะ;

class Point{
private double x;
private double y;
public Point()
{
    x = 0;
    y = 0;
}
public Point(double x,double y)
{
    this.x = x;
    this.y = y;
}
public void setX(double x)
{
    this.x = x;
}
public double getX()
{
    return x;
}
public void setY(double y)
{
    this.y = y;
}
public double getY()
{
    return y;
}
}
class Circle{
private double r;
private Point p0;
public Circle()
{
    p0 = new Point();
    r = 10;
}
public Circle(double r)
{
    p0 = new Point(0.0,0.0);
    this.r = r;
}
public Circle(Point p,double r)
{
    p0 = p;
    this.r = r;
}
public void setP0(double x,double y)
{
    p0.setX(x);
    p0.setY(y);
}
public Point getP0()
{
    return p0;
}
public void setR(double r)
{
    this.r = r;
}
public double  getR()
{
    return r;
}
boolean contains(Point p)
{
    double x = p.getX()-p0.getX();
    double y = p.getY()-p0.getY();
    if(x*x+y*y>r*r)
        return false;
    else
        return true;
}
public double area()
{
    return 3.14*r*r;
}
}

public class TestCircle{
public static void main(String args[]){
    Circle c1 = new Circle(new Point(1.0,2.0),2.0);
    Circle c2 = new Circle(5.0);
    Circle c3 = new Circle();
    System.out.println("C1("+c1.getP0().getX()+","+c1.getP0().getY()+"),"+c1.getR());
    System.out.println("C2("+c2.getP0().getX()+","+c2.getP0().getY()+"),"+c2.getR());
    System.out.println("C3("+c3.getP0().getX()+","+c3.getP0().getY()+"),"+c3.getR());
    System.out.println("C1 area:"+c1.area());
    Point p1 = new Point(5.2,6.3);
    System.out.println(c1.contains(p1));
}
}