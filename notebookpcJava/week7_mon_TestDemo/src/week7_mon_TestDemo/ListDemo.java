package week7_mon_TestDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;


class  User implements Comparable<User>{
	String username;
	String psw;
	public User() {
		super();
	}
	public User(String username, String psw) {
		super();
		this.username = username;
		this.psw = psw;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", psw=" + psw + "]";
	}
	@Override
	public int compareTo(User o) {
		return 0;
	}
	
}


public class ListDemo {
	//集合 List Set Map
	//List Set 实现了 Collection  所有方法都是一样的 , Set是不重复的集合\
	//List: ArrayList:数组      LinkedList:双向链表      Vector:加了同步锁的线程安全实现类 效率偏低
	//Set： HashSet:不会排序  TreeSet：一定会排序 实现了comparable接口 重写了compareTo方法  对象不能为null 
	//Map: HashMap:不排序  TreeMap:排序  Hashtable   <键,值>  键用不重复
 	public static void main(String[] args) {
 		User u1 = new User("zjh","123");
		User u2 = new User("zyh","123");
		
		User u3 = new User("xxx","123");
 		
 		
 		List<User> list =new ArrayList<>();
		list.add(u1);
		list.add(u1);
		list.add(u3);
//		list.remove(u1);
//		System.out.println( list.contains(u1));;
		System.out.println("list:"+list);
		
		//HashSet
		Set<User> set = new HashSet<>();
		set.add(u1);
		set.add(u2);
		set.add(u3);
		System.out.println("set:"+set);
		//TreeSet
		Set<Integer> set2 = new TreeSet<>();
		set2.add(1);
		set2.add(5);
		set2.add(4);
		System.out.println("set2:"+set2);
//		
//		for (Integer i : set2) {
//			System.out.println(i);
//		}
		
		//Map
		Map<String, Integer> map = new HashMap<>();
		map.put("zjh", 123);
		map.put("zjh", 222);
		map.put("zyh", 222);
		System.out.println(map.containsKey("zjh"));;
		System.out.println(map);
		
		String str = "dkjakjdkasjdbjasvduas";
		Map<Character,Integer> map2 = new HashMap<>();
		
		for (int i = 0; i < str.length(); i++) {
			if(map2.containsKey(str.charAt(i)))
				map2.put(str.charAt(i), map2.get(str.charAt(i))+1);
				else map2.put(str.charAt(i),1);
		}
		System.out.println(map2);
		
		Set<Entry<Character, Integer>> es = map2.entrySet();
		
		for (Entry<Character, Integer> et : es) {
			System.out.println(et.getKey()+"————————出现次数："+et.getValue());
		}
 	}
}
