package week7_mon_TestDemo;

public class StringDemo {

	// string stringbuffer stringbuilder
	//�ַ����ĳ��÷���
	public static void main(String[] args) {
		
//		
//		
//		StringBuffer sb1 =new StringBuffer("zhangjiahao");
//		StringBuffer sb2 =sb1;
//		sb2.append("xxx"); //ƴ��
//		System.out.println(sb1);
//		
//	//string ֵ�Ĳ�����
//		String str1= new String("string1");
//		String str2 = str1;
//		str2 += "xxx";
//		System.out.println(str1);
		
		
		//string ��ĳ��÷���
		
		String str = "zhangjia haozzz1";
		
//		System.out.println(str.indexOf("z")); // ���Ҹ�Ԫ�س��ֵ��׵�ַ
//		System.out.println(str.endsWith("o"));//�ж�ĩβԪ�ص�ֵ�Ƿ�Ϊ
//		System.out.println(str.replace("z", "chen")); //�滻���о�Ԫ��Ϊ��Ԫ��
		
		//�����ַ�������ʽ
//		char[] charArray = str.toCharArray(); //����ǰ�ַ���ת��Ϊchar������
//		System.out.println(charArray.length);
//		for (int i = 0; i < charArray.length; i++) {
//			System.out.println(charArray[i]);
//		}
//		System.out.println();
//		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		String[] split = str.split("z| ");//�ָ���
		System.out.println(split.length);
		for (String string : split) {
			System.out.println(string);
		}
		
		
		
	}
}
