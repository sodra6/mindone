package com.mo.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayListSample<E> implements List<E> {

	private int size;
	private int capacity;
	private E[] array;
	private E[] newArr;
	
	@SuppressWarnings("unchecked")
	public MyArrayListSample() {
		size = 0;
		capacity = 10;
		array = (E[]) new Object[capacity];
		
	}

	/**
	 * size를 리턴한다.
	 */
	@Override
	public int size() {

		return size;
	}

	/**
	 *  객체가 비어있는지 여부를 판단한다.
	 *  size가 0이면 true를 리턴
	 *  그 이외는 false를 리턴
	 */
	@Override
	public boolean isEmpty() {

		if (size == 0)
			return true;
		else
			return false;
	}

	/**
	 * 파라미터로 전달된 요소가 존재하는지 판단한다.
	 * @param 존재하는지 판단할 요소 객체
	 * @return boolean (true, false)
	 */
	@Override
	public boolean contains(Object o) {
		if(indexOf(o) > 0) {
			return true;
		}
		return false;
//		int test = indexOf(o); //숫자 이거나 -1
//		for(int i =0; i<size; i++) {
//			if(array[i]==o) 
//				return true; 
//		}
//		return false;
	}

	@Override
	public Object[] toArray() {
		
		Object[] result = array;
		
		return result;
	}
	
	/**
	 * 현재 사이즈와 초기용량을 비교한다.
	 * 초기용량보다 사이즈가 같을 때
	 * 초기용량에 10을 더해서 저장해놓고
	 * 새로운 용량을 가진 새로운 배열을 생성한다.
	 * 생성된 배열에 기존배열의 값을 복사해놓고
	 * 새로운 배열에 현재 add 로 들어온 객체를 추가한뒤
	 * 사용한 임시 배열공간은 삭제한다.
	 * size 크기를 하나 늘린다.
	 */
	@Override
	public boolean add(E param) {

		if(size==capacity) {
			capacity= size+10;
			newArr = (E[]) new Object[capacity];
			for(int i=0; i<size; i++) {
				newArr[i]=array[i];
			}
				
			array = (E[])new Object[capacity];
			for(int i=0; i<size; i++) {
				array[i]=newArr[i];
			}
			newArr = null;
			array[size] = param;
			size++;
			
		}else {
			array[size]= param; 
			size++;
		}//if~else end
		
		return true;	
	}
	/**
	 * 해당 인덱스에 e를 추가한다.
	 * size가 capacity보다 크면 add()를 호출
	 * 기존값이 있다면 기존배열을 복사
	 * 해당인덱스부터 뒤의 값까지 기존 배열에 인덱스+1 에 붙어넣기
	 * 해당인덱스에 값을 인자값으로 변경
	 * 복사한 배열을 뒤에 붙이기
	 */
	@Override
	public void add(int index, E e) {
		
			newArr=array;
			for(int i=size-1; i>=index; i--) {
				array[i+1]=newArr[i];
			}
			array[index]=e;
			size++;

	}
	
	/**
	 * 삭제할 인덱스값을 새로운 결과값에 복사
	 * 새로운 배열에 해당 인덱스 뒤의 값을 복사한다.
	 * 해당인덱스 주소의 값을 지운다.(null값)
	 * 복사한값을 해당인덱스붙어 붙인다
	 * 마지막 인덱스값을 null로 바꾼다.
	 * 사이즈를 줄여준다.
	 */
	@Override
	public E remove(int index) {
		
		E removeArray = array[index];
		
		for(int i=index+1; i<=size-1; i++) {
			
			array[i-1] = array[i];
		}
		size--;
		array[size]=null;

		
		return removeArray;
	}//해당인덱스의 값을 지우기

	/**
	 * @param 으로 받은 값이 배열에 있는지 검사
	 * 있다면 해당값을 지우고 true를 리턴
	 * 없다면 false를 리턴
	 */
	@Override
	public boolean remove(Object o) {
		if(indexOf(o)>0) {
			remove(indexOf(o));
			return true;
		}else 
			return false;
		
	}
		
	/**
	 * 전체배열을 for문으로 돌며 값을 null로 변환
	 * size를 0으로 바꿈
	 */
	@Override
	public void clear() {
		
		for(int i=0; i<size; i++) {
			array[i] = null;
		}
		capacity=0;
		size=0;
	}//전부 초기화

	/**
	 * @param index로받은 해당 번지의 값을
	 * 가져오기
	 */
	@Override
	public E get(int index) {
		
		E result = array[index];
		
		return result;
	}//해당인덱스의 객체를 가져오기
	
	/**
	 * 해당 인덱스의 값을, e로 변경후
	 * 기존값을 호출, 근데 인덱스가 증가?하는것 같은데?
	 * 
	 */
	@Override
	public E set(int index, E e) {
		if(e==null) {
			E result = array[index];
			array[index]=e;
			return result;
		}else {
			array[index] = e;
			return e;
		}
		
		
	}
	
	/**
	 * 앞부터 배열의 사이즈 만큼 for문을 돌면서
	 * 객체가 존재한다면 가장 앞에있는 해당 배열의 index를 리턴
	 * 아니면 -1을 리턴
	 */
	@Override
	public int indexOf(Object o) {
		
		for(int i=0; i<size; i++) {
			if(array[i].equals(o)) 
				return i;
		}
		return -1;
	}
	
	/**
	 * 배열의 사이즈 만큼  for문을 돌며
	 * 객체가 존재한다면 가장 뒤에 있는 해당 배열의 index를 리턴
	 * 없다면 -1을 리턴
	 */
	@Override
	public int lastIndexOf(Object o) {
		for(int i=size-1; i>=0; i--) {
			if(array[i].equals(o)) 
				return i;
		}
		return -1;
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		// 제외사항 해보면 좋겠다.
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// 제외사항
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// 제외 사항
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		// 제외 사항
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		// 제외 사항
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// 제외 사항
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		// 제외 사항
		return false;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		// 제외 사항
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		// 제외 사항
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		// 제외 사항
		return null;
	}

}
