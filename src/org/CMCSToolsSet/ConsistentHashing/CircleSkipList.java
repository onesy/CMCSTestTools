package org.CMCSToolsSet.ConsistentHashing;

import java.util.ArrayList;
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
@SuppressWarnings("hiding")
public class CircleSkipList<E extends HashNode<E>> implements List<HashNode<E>> {
	
	/**
	 * Consistent Hashing的环状空间,单元是HashNode
	 */
	private LinkedList<HashNode<E>> CircleSpace = new LinkedList<HashNode<E>>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <HashNode, T> CircleSkipList<?>  getInstance(Class<T> clazz, long[] Hashes,T[] Values){
		return new CircleSkipList(Hashes, Values);
	}
	
	private <T> CircleSkipList(long[] Hashes, T[] values){
		ArrayList<SerialNoValueBean<T>> tmpArray = new ArrayList<SerialNoValueBean<T>>();
		ArrayList<SerialNoValueBean<T>> tmp2Array = new ArrayList<SerialNoValueBean<T>>();
		for(int i = 0; i < Hashes.length; i ++){
			tmpArray.add(new SerialNoValueBean<T>(Hashes[i],values[i]));
		}
		for(int i = 0 ; i < tmp2Array.size() ; i ++){
			SerialNoValueBean<T> bigOne = tmpArray.get(0);
			for(int j = 0; j < tmpArray.size(); j ++){
				if(tmpArray.get(j).Hash < tmpArray.get(j + 1).Hash){
					bigOne = tmpArray.get(j + 1);khbjhgjyhv
				}
			}
		}
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
	public Iterator<HashNode<E>> iterator() {
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
	public HashNode<E> get(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HashNode<E> remove(int index) {
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
	public ListIterator<HashNode<E>> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<HashNode<E>> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<HashNode<E>> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(HashNode<E> e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends HashNode<E>> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends HashNode<E>> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HashNode<E> set(int index, HashNode<E> element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, HashNode<E> element) {
		// TODO Auto-generated method stub
		
	}

}
