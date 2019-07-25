package week4_linklist_homework_10_1_holiday;

public class Node {
	public Object data;
	public Node next;

	public Node() {
		this(null, null);
	}// 无参构造

	public Node(Object data) {
		this(data, null);
	}// 带数据域的单参构造

	public Node(Object data, Node next) { // 有参构造
		this.data = data;
		this.next = next;
	}

}
