package com.mo.LinkedList;

public class LinkedList {

	public static void main(String[] args) {
		
		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
		MyLinkedListSample<String> myList = new MyLinkedListSample<String>();
		
		//add()
		for(int i=0;i<15;i++) {
			list.add(i+"번");
			System.out.println("list에 "+i+"item 을 추가");
		}
		for(int i=0;i<15;i++) {
			myList.add(i+"번");
			System.out.println("myList�� "+i+"item 을 추가");
		}
		
		//get()
		for(int i=0;i<15;i++) {
			System.out.println("list의 "+i+"번째 : "+list.get(i));
		}
		for(int i=0;i<15;i++) {
			System.out.println("myList의 "+i+"번째 : "+myList.get(i));
		}
		
		//set()
		for(int i=0;i<15;i++) {
			System.out.println("list의 "+i+"번째를 수정 : "+list.set(i,i+100+"만"));
		}
		for(int i=0;i<15;i++) {
			System.out.println("myList의 "+i+"번째를 수정 : "+myList.set(i,i+100+"만"));
		}
		
		//size()
		System.out.println("list의 size는 "+list.size());
		System.out.println("myList의 size는 "+myList.size());
		//indexOf
		System.out.println(list.indexOf("103만")+"번에 위치");
		System.out.println(myList.indexOf("103만")+"번에 위치");
		
		//lastIndexOf
		System.out.println(list.lastIndexOf("104만")+"번에 위치");
		System.out.println(myList.lastIndexOf("104만")+"번에 위치");

		//remove
		for(int i=list.size()-1; i>=0; i--) {
			list.remove(i);
			System.out.println("list의 "+i+"item 을 삭제");
		}
		for(int i=myList.size()-1; i>=0; i--) {
			myList.remove(i);
			System.out.println("myList의 "+i+"item 을 삭제");
		}
		
		//remove("")
		System.out.println(list.remove("104만"));
		System.out.println(myList.remove("104만"));
		

		//isEmpty()
		System.out.println(list.isEmpty()?"비어있다.":"비어있지않다.");
		System.out.println(myList.isEmpty()?"비어있다.":"비어있지않다.");

		//contain()
		System.out.println(list.contains("100만"));
		System.out.println(myList.contains("100만"));
		
		//toArray
		
		//size()
		System.out.println("list의 size는 "+list.size());
		System.out.println("myList의 size는 "+myList.size());
		System.out.println(list.toArray());
		System.out.println(myList.toArray());
		
		
	}
}
