package DirectedGraph;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class Pair<T> implements Collection<T>, Serializable {
	
	private T first;
	private T second;
	
	public Pair(T one, T two) {
		if(one == null || two == null)
			throw new IllegalArgumentException("You passed null values to the pair!");
		first = one;
		second = two;
	}
	
	public Pair(Collection<? extends T> values) {
		if(values == null)
			throw new IllegalArgumentException("Cannot pass null values!");
		if(values.size() == 2) {
			if(values.contains(null))
				throw new IllegalArgumentException("Cannot pass null values!");
			Iterator<? extends T> iter = values.iterator();
			first = iter.next();
			second = iter.next();
		}
		else 
			throw new IllegalArgumentException("A pair can only be created by a collection of two items");
	}
	
	public Pair(T[] values) {
		if(values == null)
			throw new IllegalArgumentException("Cannot pass null values!");
		if(values.length == 2) {
			if(values[0] == null || values[1] == null)
				throw new IllegalArgumentException("Cannot pass null values!");
			first = values[0];
			second = values[1];
		}
		else 
			throw new IllegalArgumentException("A pair can only be created by an array of two items");
	}

	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	
	@Override
	public boolean equals(Object o) {		
		if(o == this)
			return true;
		
		if(o instanceof Pair){
			Pair otherPair = (Pair) o;
			Object otherFirst = otherPair.getFirst();
			Object otherSecond = otherPair.getSecond();
			return (this.first == otherFirst || (this.first != null && this.first.equals(otherFirst)))
				&& (this.second == otherSecond || (this.second != null && this.second.equals(otherSecond)));			
		} else {		
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int hashCode = 1;
			hashCode = 31*hashCode + (first==null ? 0 : first.hashCode());
			hashCode = 31*hashCode + (second==null ? 0 : second.hashCode());
		return hashCode;
	}
	
	@Override
	public String toString() {
		return "<" + first.toString() + ", " + second.toString() + ">";
	}	
	
	
	@Override
	public boolean add(T o) {
		throw new UnsupportedOperationException("Pairs cannot be mutated");		
	}		

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		throw new UnsupportedOperationException("Pairs cannot be mutated");	
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("Pairs cannot be mutated");			
	}

	@Override
	public boolean contains(Object o) {
		return (first == o || first.equals(o) || second == o || second.equals(o));
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(c.size() > 2)
			return false;
		Iterator<?> iter = c.iterator();
		Object c_first = iter.next();
		Object c_second = iter.next();
		return this.contains(c_first) && this.contains(c_second);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new PairIterator();
	}

	@Override
	public boolean remove(Object arg0) {
		throw new UnsupportedOperationException("Pairs cannot be mutated");
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Pairs cannot be mutated");
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		throw new UnsupportedOperationException("Pairs cannot be mutated");
	}

	@Override
	public int size() {
		return 2;
	}

	@Override
	public Object[] toArray() {
		Object[] to_return = new Object[2];
		to_return[0] = first;
		to_return[1] = second;
		return to_return;
	}

	@Override
	public <S> S[] toArray(S[] a) {
		S[] to_return = a;
		Class<?> type = a.getClass().getComponentType();
		if(a.length < 2)
			to_return = (S[])java.lang.reflect.Array.newInstance(type, 2);
		to_return[0] = (S)first;
		to_return[1] = (S)second;
		
		if(to_return.length > 2)
			to_return[2] = null;
		return to_return;
	}
	
	private class PairIterator implements Iterator<T> {

		int position;
		
		private PairIterator() {
			position = 0;
		}
		
		public boolean hasNext() {
			return position > 2;
		}
		
		public T next() {
			position++;
			if(position == 1)
				return first;
			else if(position == 2)
				return second;
			else
				return null;
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Pairs cannot be mutated");
		}
	}
}
