package week4_linklist_homework_10_1_holiday;

public interface linkListInterface {
	
	
	public void clear();  //��յ�ǰ����
	public boolean isEmpty(); // �жϵ�ǰ�����Ƿ�Ϊ��
	public int length();//��ѯ��ǰ����ĳ���
	public Object get(int i)throws Exception;//���ݽڵ�iȥ��ȡ��ǰ��������
	public void insert(int i,Object x)throws Exception;//�ڵ�i������ǰ�����x��Ԫ��
	public void remove(int i)throws Exception;//ɾ����ǰ���Ϊi���������ֵ
	public int indexOf(Object x);//����������Ϊx�Ľ���ָ����
	public void display();//��ӡ�����ǰ����Ľṹ
	
}
