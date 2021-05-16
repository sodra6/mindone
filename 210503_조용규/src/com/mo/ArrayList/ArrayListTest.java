package com.mo.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		MyArrayListSample<String> myList = new MyArrayListSample<String>();

		list.add("apple");
		myList.add("apple");
		
		list.add("orange");
		myList.add("orange");
		
		System.out.println("----------------------------------------------------");
		//contain 출력
		System.out.println("나는 해당 객체를 갖고 있습니까? : "+list.contains("orange"));
		System.out.println("나는 해당 객체를 갖고 있습니까? : "+myList.contains("orange"));
		System.out.println("----------------------------------------------------");
		
		//clear실행
		list.clear();
		myList.clear();
		System.out.println(list);
		System.out.println(myList);
		list.add("감자");
		myList.add("감자");
		
		System.out.println(list.set(0,"오렌지"));
		System.out.println(myList.set(0,"오렌지"));
		
		System.out.println("----------------------------------------------------");
		
		//add출력
		for(int i = 0; i < 20; i++) {
			list.add(i+ "item");
			System.out.println("list 에 " + i+"item" + "을 추가했어요.");
		}
		
		for(int i = 0; i < 20; i++) {
			myList.add(i+ "item");
			System.out.println("myList 에 " + i+"item" + "을 추가했어요.");
		}
		
		System.out.println("----------------------------------------------------");
		//size출력
		System.out.println("내 사이즈는 "+list.size()+"입니다.");
		System.out.println("내 사이즈는 "+myList.size()+"입니다.");
		System.out.println("----------------------------------------------------");

		//remove출력
		for(int i = list.size(); i > 0; i--) {
			list.remove(i+ "item");
			System.out.println("list 에 " + i+"item" + "을 삭제했어요.");
		}
		for(int i = myList.size(); i > 0; i--) {
			myList.remove(i+ "item");
			System.out.println("myList 에 " + i+"item" + "을 삭제했어요.");
		}
		System.out.println("----------------------------------------------------");
		
		System.out.println(list.size());
		System.out.println(myList.size());
		System.out.println("----------------------------------------------------");

		//get출력
		System.out.println("0번지의 값은 "+list.get(0)+"입니다.");
		System.out.println("0번지의 값은 "+myList.get(0)+"입니다.");
		System.out.println("----------------------------------------------------");
		
		//set출력
		list.set(0, "오렌지0");
		myList.set(0, "오렌지0");
		System.out.println("set으로 설정한 0번지의 값 : "+list.get(0));//set은 리턴값이 x, set으로 설정하면 get으로 받는다.
		System.out.println("set으로 설정한 0번지의 값 : "+myList.get(0));
		System.out.println("----------------------------------------------------");
		
		for(int i = 0; i<myList.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("----------------------------------------------------");
		for(int i = 0; i<myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		System.out.println("----------------------------------------------------");
		
		
		//add(index, param)출력
		list.add(1, "사과");
		myList.add(1, "사과");
		System.out.println("해당 번지에 추가한 값 : "+list.get(1));
		System.out.println("해당 번지에 추가한 값 : "+myList.get(1));
		System.out.println("----------------------------------------------------");
		
		//remove(Object o)출력
		System.out.println(list.remove("사과"));
		System.out.println(myList.remove("사과"));
		
		list.add(0,"오렌지1");
		myList.add(0,"오렌지1");
		
		list.add(1,"딸기2");
		myList.add(1,"딸기2");
		
		list.add(0,"오렌지0");
		myList.add(0,"오렌지0");

		list.add(0,"오렌지2");
		myList.add(0,"오렌지2");
		
		list.add(0,"오렌지3");
		myList.add(0,"오렌지3");
		
		System.out.println("----------------------------------------------------");
		//indexOf 출력
		System.out.println("오렌지는 앞에서 몇번째에 있을까요? : "+list.indexOf("오렌지1"));
		System.out.println("오렌지는 앞에서 몇번째에 있을까요? : "+myList.indexOf("오렌지1"));
		System.out.println("----------------------------------------------------");
		//lastIndexOf 출력
		System.out.println("가장 뒤에 있는 오렌지는 몇번째에 있을까요? : "+list.lastIndexOf("오렌지0"));
		System.out.println("가장 뒤에 있는 오렌지는 몇번째에 있을까요? : "+myList.lastIndexOf("오렌지0"));
	}
	
}

