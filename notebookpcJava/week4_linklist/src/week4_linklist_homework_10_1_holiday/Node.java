package week4_linklist_homework_10_1_holiday;

public class Node {
	public Object data;
	public Node next;

	public Node() {
		this(null, null);
	}// �޲ι���

	public Node(Object data) {
		this(data, null);
	}// ��������ĵ��ι���

	public Node(Object data, Node next) { // �вι���
		this.data = data;
		this.next = next;
	}

}
