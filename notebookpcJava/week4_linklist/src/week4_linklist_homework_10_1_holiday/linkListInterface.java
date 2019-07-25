package week4_linklist_homework_10_1_holiday;

public interface linkListInterface {
	
	
	public void clear();  //清空当前链表
	public boolean isEmpty(); // 判断当前链表是否为空
	public int length();//查询当前链表的长度
	public Object get(int i)throws Exception;//根据节点i去获取当前结点的数据
	public void insert(int i,Object x)throws Exception;//在第i个结点的前面插入x的元素
	public void remove(int i)throws Exception;//删除当前结点为i的数据域的值
	public int indexOf(Object x);//查找数据域为x的结点的指针域
	public void display();//打印输出当前链表的结构
	
}
