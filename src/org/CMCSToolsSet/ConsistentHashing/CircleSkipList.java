package org.CMCSToolsSet.ConsistentHashing;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 为了实现Consistent Hashing，所以专门写了跳表类
 * @author onesy
 * @param <T>
 *
 * @param <HashNode>
 */
public class CircleSkipList<HashNode> implements List<HashNode> {
	
	/**
	 * Consistent Hashing的环状空间,单元是HashNode
	 */
	private LinkedList<HashNode> CircleSpace = new LinkedList<HashNode>();
	
	private CircleSkipList(int size){
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<HashNode> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(HashNode e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends HashNode> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends HashNode> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashNode get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashNode set(int index, HashNode element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, HashNode element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashNode remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<HashNode> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<HashNode> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HashNode> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
