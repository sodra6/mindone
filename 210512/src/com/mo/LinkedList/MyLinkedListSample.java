package com.mo.LinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedListSample<E> implements List<E> {

	private final int DEFAULT_ARRAY_RANGE = 0;
	private int size;
	private Node head = null;
	private Node tail = null;
	private E[] array;

	// Inner �겢�옒�뒪�쓽 �꽑�뼵
	class Node {

		private E value; // Node �쓽 媛�
		private Node prevNode; // �씠�쟾 Node
		private Node nextNode; // �쁽�옱 Node

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}

	public MyLinkedListSample() {

	}

	@Override
	public int size() {
		return size;
	}
	
	/**
	 * head가 없으면 null리턴.
	 */
	@Override
	public boolean isEmpty() {
		
		return head==null;
	}
	
	/**
	 * 반복문을 null이 아닐때까지 해드부터 돌며 다음 해당 노드의 값을 비교하고
	 * 다르면 다음 노드값으로 이동하여 반복비교
	 * 같은값이 있으면 @return true
	 * 같은값이 없으면 @return false
	 */
	@Override
	public boolean contains(Object o) {
        for (Node addr = head; addr != null; addr=addr.nextNode) {
            if(o.equals(addr.value))
            	return true;
        }
        return false;
	}
	
	/**
	 * nextNode의 값이 null인곳 까지 for문을 돌며 값을찾고
	 * 새로운 배열에 size크기만큼의 새로운 배열을 만들어서
	 * 해당 size크기와 같은 배열에 value값을 넣는다.
	 * array를 return해준다
	 */
	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
		for (Node addr = head; addr !=null; addr=addr.nextNode) {
			for (int i = 0; i<size; i++) {
				array[i]=addr.value;
			}
		}
		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		
		return null;
	}

	/**
	 * 마지막에 생성된 노드를 연결
	 * 마지막값의 nextNode의 값을 null로 설정
	 * 마지막값이었던 값의 nextNode값을 newNode의 prevNode값으로 설정
	 * size증가
	 */
	@Override
	public boolean add(E e) {
		Node newNode = new Node();
		if (size != 0) {
			tail.nextNode = newNode;
			tail = newNode;
			newNode.value=e;
			size++;
		} else {
			newNode.nextNode = head;
			head = newNode;
			newNode.value=e;
			size++;
			if (head.nextNode == null) {
				tail = head;
			}
		}
		return newNode!=null;
	}
	
	/**
	 * 
	 */
	@Override
	public void add(int index, E e) {
		if(index==size) {
			add(e);
		}else if(index<size){
			Node newNode = new Node();
	        
			Node addr = head;
	        for (int i = 0; i < index; i++) {
	            addr = addr.nextNode;
	        }
	        addr.nextNode=newNode;
	        newNode.nextNode=addr.nextNode.nextNode;
	        newNode.value=e;
	        size++;
	        if(newNode.nextNode==null) {
	        	tail=newNode;
	        }
			
		}else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}
	
	/**
	 * 삭제하려는 노드의 이전 노드의 
	 * nextNode값을 삭제하고
	 * 뒤의 노드값을 앞의 노드값으로 변경
	 * 해당번지를 초기화
	 * 사이즈를 줄여준다.
	 * 문제점 : 삭제를 해도 값이 남아있다. 왤까?
	 */
	@Override
	public E remove(int index) {
		
		if(index==0) {
			Node temp = head;
			head = temp.nextNode;
			E deleteValue = temp.value;
			temp=null;
			size--;
	        return deleteValue;
		}
			Node addr = head;
				for (int i = 0; i < index-1; i++) {
					addr = addr.nextNode;
				}
			Node deleteNode = addr.nextNode;
			addr.nextNode=addr.nextNode.nextNode;
			E deleteValue = deleteNode.value;
			if(deleteNode==tail)
				tail=addr;
			deleteNode=null;
			size--;
			return deleteValue;
	}
	
	/**
	 * 처음부터 끝가지 반복문을돌며 인자로 받은 o가 있는지 확인
	 * 있다면 이전값의 nextNode를 다음nextNode의 값을 가르킴
	 * 사이즈를 줄여준다.
	 */
	@Override
	public boolean remove(Object o) {
	    for (Node addr = head; addr!=null; addr=addr.nextNode) {
	    	if(o.equals(addr.value))
	    		addr=addr.nextNode.nextNode;
        		size--;
	    		return true;
	    }
		return false;
	}

	@Override
	public void clear() {
		head = null;
		head.nextNode=null;
		size=0;

	}
	
	/**
	 * 인자로 받은 index값 만큼 반복문을 돌려서
	 * head부터 index값만큼 이동하여 node값을 찾고
	 * 해당노드값의 value값을 리턴하여준다.
	 */
	@Override
	public E get(int index) {
        Node addr = head;
        for (int i = 0; i < index; i++) {
            addr = addr.nextNode;
        }
        Node temp = addr;
        return temp.value;
	}
	/**
	 * for문을 돌며 해당 인덱스의 nextNode와 value를 얻음
	 * 해당 value를 paramValue로 변경
	 * 기존 value값을 다른곳에 저장후
	 * return값으로 변경되기 전 값을 return
	 */
	@Override
	public E set(int index, E paramValue) {
		Node newNode = new Node();
        Node addr = head;
        for (int i = 0; i < index; i++) {
            addr = addr.nextNode;
        }
        newNode.value=addr.value;
        addr.value=paramValue;
		return newNode.value;
	}

	/**
	 * for문을 돌며 해당객체가 있는지 확인
	 * for문을 돈 횟수만큼이 해당 인덱스
	 */
	@Override
	public int indexOf(Object o) {
		Node addr = head;
		int index=0;
        for (int i = 0; i < size; i++) {
	            addr = addr.nextNode;
	            index++;
	            Node temp = addr;
	            if(temp.value.equals(o)) {
	            	return index; 
	            }
	        }
        return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node addr = head;
		int index=0;
        for (int i = size-1; i >=0; i++) {
	            addr = addr.nextNode;
	            index++;
	            Node temp = addr;
	            if(temp.value.equals(o)) {
	            	return index; 
	            }
	        }
		return -1;
	}

	@Override
	public Iterator<E> iterator() {
		// �젣�쇅�궗�빆
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return false;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		// �젣�쇅 �궗�빆
		return null;
	}

}
