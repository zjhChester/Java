package week7_mon_TestDemo;

public class StringDemo {

	// string stringbuffer stringbuilder
	//字符串的常用方法
	public static void main(String[] args) {
		
//		
//		
//		StringBuffer sb1 =new StringBuffer("zhangjiahao");
//		StringBuffer sb2 =sb1;
//		sb2.append("xxx"); //拼接
//		System.out.println(sb1);
//		
//	//string 值的不变性
//		String str1= new String("string1");
//		String str2 = str1;
//		str2 += "xxx";
//		System.out.println(str1);
		
		
		//string 类的常用方法
		
		String str = "zhangjia haozzz1";
		
//		System.out.println(str.indexOf("z")); // 查找该元素出现的首地址
//		System.out.println(str.endsWith("o"));//判断末尾元素的值是否为
//		System.out.println(str.replace("z", "chen")); //替换所有旧元素为新元素
		
		//遍历字符串的形式
//		char[] charArray = str.toCharArray(); //将当前字符串转换为char型数组
//		System.out.println(charArray.length);
//		for (int i = 0; i < charArray.length; i++) {
//			System.out.println(charArray[i]);
//		}
//		System.out.println();
//		for (int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i));
//		}
		
		String[] split = str.split("z| ");//分隔符
		System.out.println(split.length);
		for (String string : split) {
			System.out.println(string);
		}
		
		
		
	}
}
