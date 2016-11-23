package source.arraylist;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class ArrayListSource<E> extends AbstractList<E>
		implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
	// 序列版本号
	private static final long serialVersionUID = 8683452581122892189L;

	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private transient Object[] elementData;
	private int size;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

	public ArrayListSource() {
		this.elementData = EMPTY_ELEMENTDATA;
	}

	public ArrayListSource(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		this.elementData = new Object[initialCapacity];
	}

	public ArrayListSource(Collection<? extends E> c) {
		elementData = c.toArray();
		size = elementData.length;
		if (elementData.getClass() != Object[].class)
			elementData = Arrays.copyOf(elementData, size, Object[].class);
	}

	// 将当前容器值设置为实际元素个数
	public void trimToSize() {
		modCount++;
		if (size < elementData.length) {
			elementData = Arrays.copyOf(elementData, size);
		}
	}

	// 确定ArrayList容量
	public void ensureCapacity(int minCapacity) {
		int minExpand = (elementData != EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;

		if (minCapacity > minExpand) {
			modCount++;

			if (minCapacity - elementData.length > 0)
				grow(minCapacity);
		}
	}

	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		newCapacity = hugeCapacity(minCapacity);
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	// 容器最大容量214748347 ： 2147483639
	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}
	
	// 添加元素
	public boolean add(E e) {
		ensureCapacityInternal(size + 1); // Increments modCount!!
		elementData[size++] = e;
		return true;
	}

	// 在index下标添加元素
	public void add(int index, E element) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		ensureCapacityInternal(size + 1); // Increments modCount!!
		// 复制数组
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = element;
		size++;
	}
	private void ensureCapacityInternal(int minCapacity) {
		if (elementData == EMPTY_ELEMENTDATA) {
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		}
		ensureExplicitCapacity(minCapacity);
	}
	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;

		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	@SuppressWarnings("unchecked")
	@Override
	// 获取元素
	public E get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		return (E) elementData[index];
	}

	@Override
	public int size() {
		return 0;
	}

	// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 是否包含某元素
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		final int a = Integer.MAX_VALUE - 8;
		System.out.println(a);
	}
}