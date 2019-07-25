package week4_linklist_homework_10_1_holiday;

public class linkListDemo implements linkListInterface{

	Node head; //唯一变量
	
	public static void main(String[] args) throws Exception {
		linkListDemo linkListDemo = new linkListDemo();
		linkListDemo.insert(0, 5);
		linkListDemo.insert(0, 20);
		linkListDemo.insert(0, 51);
		linkListDemo.insert(0, 22);
		linkListDemo.insert(0, 84);
		linkListDemo.insert(0, 59);
		linkListDemo.display();
		System.out.println(linkListDemo.isEmpty());
		System.out.println(linkListDemo.length());
		System.out.println(linkListDemo.get(2));
		linkListDemo.remove(2);
		System.out.println("");
		linkListDemo.display();
		//逆向打印
		System.out.println("逆向打印");
		Object [] nz = new Object[linkListDemo.length()];
		for(int i=0;i<nz.length;i++)
		{
			nz[i] = linkListDemo.get(i);
		}
		for(int i=nz.length-1;i>=0;i--)
		{
			System.out.println(nz[i]);
		}
		//删除所有偶数结点
		System.out.println("删除所有偶数结点");
		for (int i = 0; i < nz.length; i++) {
			if((int)nz[i]%2 == 0)
			{
				linkListDemo.remove(i);
			}
		}
		linkListDemo.display();
	}

	public linkListDemo() {
		
		head = new Node();
	}
	
	@Override
	public void clear() {
		head.data = null;
		head.next = null;
	}

	@Override
	public boolean isEmpty() {

		return head.next==null;
	}

	@Override
	public int length() {
		int j=0;
		Node node = head.next;
		while(node!=null) //遍历链表
		{
			node = node.next;
			j++;
		}
		return j;
	}

	@Override
	public Object get(int i) throws Exception {
		Node node = head.next;
		int j=0;
		while(node!=null&&j<i)
		{
			node = node.next;
			j++;
		}
		if(j>i&&node==null) 
			throw new Exception("第"+i+"个元素不存在！");
		return node.data;
	}

	@Override
	public void insert(int i, Object x)throws Exception {
		Node node = head;
		int j= -1;
				
		while(node!=null&&j<i-1)
		{
			node = node.next;
			j++;
		}
		if(j>i-1 && node==null) throw new Exception("插入的位置非法！");
		Node s= new Node(x);
		s.next = node.next;
		node.next = s;
	}

	@Override
	public void remove(int i) throws Exception {
		Node node = head;
		int j =-1;
		while(node!=null&&j<i-1)
		{
			node = node.next;
			j++;
		}
		if(j>i-1&&node==null)
			throw new Exception("删除位置非法！");
		node.next = node.next.next; // 将第i-1个后继指向i+1的结点  使i结点脱离链表
	}

	@Override
	public int indexOf(Object x) {
		Node node  = head.next;
		int j =0;
		while(node!=null && !node.data.equals(x))
		{
			node = node.next;
			j++;
		}
		if(node!=null)  return j;
		else return -1;
		
	}

	@Override
	public void display() {
		Node node = head.next;
		while(node!=null)
		{
			System.out.println(node.data+"\t"+node.next+"   ");
			node = node.next;
		}
		System.out.println("");
	}
	
	
	
	
	
}
