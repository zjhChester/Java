package week4_linklist_homework_10_1_holiday;

public class linkListDemo implements linkListInterface{

	Node head; //Ψһ����
	
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
		//�����ӡ
		System.out.println("�����ӡ");
		Object [] nz = new Object[linkListDemo.length()];
		for(int i=0;i<nz.length;i++)
		{
			nz[i] = linkListDemo.get(i);
		}
		for(int i=nz.length-1;i>=0;i--)
		{
			System.out.println(nz[i]);
		}
		//ɾ������ż�����
		System.out.println("ɾ������ż�����");
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
		while(node!=null) //��������
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
			throw new Exception("��"+i+"��Ԫ�ز����ڣ�");
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
		if(j>i-1 && node==null) throw new Exception("�����λ�÷Ƿ���");
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
			throw new Exception("ɾ��λ�÷Ƿ���");
		node.next = node.next.next; // ����i-1�����ָ��i+1�Ľ��  ʹi�����������
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
