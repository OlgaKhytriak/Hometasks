package com.epam.lab.task4.stringcontainer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StringsContainer implements List<String> {

	private static final String[] EMPTY_CONTAINER = {};
	private String[] container;

	public StringsContainer(int initialSize) {
		if (initialSize > 0) {
			this.container = new String[initialSize];
		} else if (initialSize == 0) {
			this.container = EMPTY_CONTAINER;
		} else {
			throw new IllegalArgumentException(String.format("Irregular Capacity: %s", initialSize));
		}
	}

	public StringsContainer() {
		container = new String[0];
	}

	public StringsContainer(String[] initialArray) {
		container = new String[initialArray.length];
		System.arraycopy(initialArray, 0, container, 0, initialArray.length);
	}

	@Override
	public int size() {
		return container.length;
	}

	@Override
	public boolean isEmpty() {
		if (0 == size()) {
			return true;
		} else
			return false;
	}

	// додаЇ елемент в к≥нець
	@Override
	public boolean add(String e) {
		boolean copyDone = false;
		if (isEmpty()) {
			String[] tempContainer = new String[1];
			tempContainer[0] = e;
			container = tempContainer;
			copyDone = true;
		} else {
			// container=addToEnd(container,e);
			add(size(), e);
			copyDone = true;
		}
		return copyDone;
	}

	// додаЇ елемент у задану позиц≥ю
	@Override
	public void add(int index, String element) {
		String[] tempLeft = new String[index];
		String[] tempRight = new String[size() - index];
		String[] tempElement = { element };
		String[] newArr = new String[size() + 1];
		System.arraycopy(container, 0, tempLeft, 0, index);
		System.arraycopy(container, index, tempRight, 0, size() - index);
		System.arraycopy(tempLeft, 0, newArr, 0, tempLeft.length);
		System.arraycopy(tempElement, 0, newArr, index, 1);
		System.arraycopy(tempRight, 0, newArr, index + 1, tempRight.length);
		container = newArr;
	}
//повертаЇ  елемент за ≥ндексом
	@Override
	public String get(int index) {
		 rangeCheck(index);
	return container[index];
	}
	
	private void rangeCheck(int index) {
        if ((index >= size())||(index<0))
            throw new IndexOutOfBoundsException();
    }
	

	// додаЇ в к≥нець масиву 1 елемент
	/*
	 * private String[] addToEnd(String[] receiver, String element) { String[]
	 * tempContainer=new String[1]; tempContainer[0]=element; String[] newArr = new
	 * String[receiver.length + tempContainer.length]; System.arraycopy(receiver, 0,
	 * newArr, 0, receiver.length); System.arraycopy(tempContainer, 0, newArr,
	 * receiver.length, tempContainer.length); receiver=newArr; return receiver; }
	 */

	
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<String> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<String> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<String> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	public String[] getContainer() {
		/// !!! ¬» »Ќ”“»
		return container;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

}
