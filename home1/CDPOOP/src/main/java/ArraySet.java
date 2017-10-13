import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import com.sun.istack.internal.Nullable;

public class ArraySet<E> extends AbstractSet<E> implements Set<E> {
	public static void main(String[] args) {

		ArraySet<String> arraySet = new ArraySet<>();
		Iterator itr = arraySet.iterator();

		arraySet.add("1");
		arraySet.add("2");
		arraySet.add("2");
		arraySet.add("4");
		arraySet.add("5");
		arraySet.add("6");
		/*arraySet.add(7);
		arraySet.add(8);*/

		System.out.println("array after add method");
		arraySet.show();
		itr.next();
		itr.remove();
		System.out.println("array after remove method");
		arraySet.show();
	}

	protected Object[] array;

	ArraySet() {
		array = new Object[0];
	}

	public Iterator<E> iterator() {
		return new MyIterator();
	}

	public void show() {
		for (Object arr : array) {
			System.out.println(arr);
		}
	}

	public int size() {
		return array.length;
	}

	public boolean add(@Nullable E element) {
		int length = array.length;
		if (indexOf(element, array, 0, length) >= 0) {
			return false;
		}
		Object[] newArray = Arrays.copyOf(array, length + 1);
		newArray[length] = element;
		array = newArray;
		return true;
	}

	private int indexOf(Object element, Object[] array, int fromIndex, int toIndex) {
		assert array != null;
		if (element == null) {
			for (int i = fromIndex; i < toIndex; ++i) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = fromIndex; i < toIndex; ++i) {
				if (element.equals(array[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	private void remove() {
		throw new ConcurrentModificationException();
	}

	public static void checkElement(boolean expression) {
		if (!expression) {
			throw new NoSuchElementException();
		}
	}

	private class MyIterator implements Iterator<E> {
		private int cursor;

		public MyIterator() {
			cursor = 0;
		}

		@Override
		public boolean hasNext() {
			return cursor < array.length;
		}

		@Override
		public E next() {
			checkElement(hasNext());
			return (E) array[cursor++];
		}

		@Override
		public void remove() {
			array = Arrays.stream(array).filter(e -> !e.equals(array[cursor])).toArray(Object[]::new);
			cursor--;
		}
	}
}