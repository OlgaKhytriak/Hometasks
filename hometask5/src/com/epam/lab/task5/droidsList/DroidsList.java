package com.epam.lab.task5.droidsList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.epam.lab.task5.droidsShip.models.*;

public class DroidsList<E extends Droid> implements List<E> {
	private int size = 0;
	private Node<E> first;
	private Node<E> last;

	public DroidsList() {
	}

	private static class Node<E> {
		E item;
		Node<E> next;
		Node<E> prev;

		Node() {
		}

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
	
	@Override
	public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
	}
	Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
	@Override
	public boolean add(E e) {
		Node<E> newNode = new Node<E>();
		newNode.item = e;
		if (size() == 0) {
			newNode.next = newNode;
			newNode.prev = newNode;
			first = newNode;
			last = first;
		} else {
			newNode.prev = last;
			newNode.next = first;
			first.prev = newNode;
			last.next = newNode;
			last = newNode;
		}
		size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		checkPositionIndex(index);
		if (0 == index) {
			addFirst(element);
		} else if (size == index) {
			addLast(element);
		} else {
			Node<E> newNode = new Node<E>();
			newNode.item = element;
			Node<E> afterNode = first;
			for (int i = 0; i < index; i++) {
				afterNode = afterNode.next;
			}
			Node<E> beforeNode = afterNode.prev;
			beforeNode.next = newNode;
			afterNode.prev = newNode;
			newNode.next = afterNode;
			newNode.prev = beforeNode;
			size++;
		}
	}

	private void addLast(E element) {
		Node<E> newNode = new Node<E>();
		newNode.item = element;
		newNode.next = last;
		newNode.prev = last;
		first.prev = newNode;
		last.next = newNode;
		last = newNode;
		size++;
	}

	private void addFirst(E element) {
		Node<E> newNode = new Node<E>();
		newNode.item = element;
		newNode.next = first;
		newNode.prev = last;
		last.next = newNode;
		first.prev = newNode;
		first = newNode;
		size++;
	}

	private boolean isPositionIndex(int index) {
		return index >= 0 && index <= size;
	}
	private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

	private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
	private void checkPositionIndex(int index) {
		if (!isPositionIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
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
		// TODO Auto-generated method stub

	}

	
	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
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
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}
