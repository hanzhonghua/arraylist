package source.arraylist;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class ArrayListSource<E> extends AbstractList<E>    
	implements List<E>, RandomAccess, Cloneable, java.io.Serializable{    
	// 序列版本号    
	private static final long serialVersionUID = 8683452581122892189L;  
	
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEMENTDATA = {};
	private transient Object[] elementData;
	private int size;
	
	public ArrayListSource() {
        this.elementData = EMPTY_ELEMENTDATA;
    }
	public ArrayListSource(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new Object[initialCapacity];
    }
	public ArrayListSource(Collection<? extends E> c) {
        elementData = c.toArray();
        size = elementData.length;
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, size, Object[].class);
    }
	//将当前容器值设置为实际元素个数
	public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = Arrays.copyOf(elementData, size);
        }
    }
	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}