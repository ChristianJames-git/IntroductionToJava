/** MyArrayList
 *  
 *  Students should complete all methods in the interface MyList.
 *  
 *  Add helper methods (private/protected) where useful. 
 *  Suggestions:  shiftUp, shiftDown, checkIndexRange, etc.
 *
 */
public class MyVector<E> extends MyAbstractList<E> implements MyList<E> {

	E[] array;
	protected static final int INITIAL_CAPACITY = 10;
	protected static final int INITIAL_CAPACITY_INCREMENT = 5;
	protected int increment;
	protected int capacity;
	
	public MyVector() {
		this(INITIAL_CAPACITY);
		this.capacity = INITIAL_CAPACITY;
		this.increment = INITIAL_CAPACITY_INCREMENT;
	}

	@SuppressWarnings("unchecked")
	public MyVector(int initialCapacity) {
		super();
		array = (E[]) new Object[initialCapacity]; // let fail if bad parameter
		size = 0;
		this.capacity = initialCapacity;
		this.increment = INITIAL_CAPACITY_INCREMENT;
	}

	@SuppressWarnings("unchecked")
	public MyVector(int initialCapacity, int increment) {
		super();
		array = (E[]) new Object[initialCapacity];
		size = 0;
		this.increment = increment;
		this.capacity = initialCapacity;
	}
	/**
	 * Appends the specified E to the end of this list
	 *
	 * @param data
	 *            element to insert
	 * @return boolean success
	 */
	@Override
	public boolean add(E data) {
		if (data != null) {
			if (this.size == this.array.length) {
				this.resize();
			}
			this.array[this.size++] = data;
		}
		return true;
	}
	
	/**
	 * Appends the specified E to the list at the specified index
	 * 
	 * @param index
	 *            position to insert data
	 * @param data
	 *            element to insert
	 * @return boolean success
	 */
	@Override
	public boolean add(int index, E data) {
		if (data != null) {
			if (this.size == this.array.length) {
				this.resize();
			}
			shiftUpAndInsert(index, data);
		}
		return false;
	}

	/**
	 * Let the garbage collector do the heavy lifting!
	 */
	@SuppressWarnings("unchecked")
	public void clear() {
		this.array = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;
	}

	/**
	 * Shift elements down to make room for insert and then insert
	 * @param index, data
	 * @return boolean
	 */
	public boolean shiftUpAndInsert(int index, E data) {
		for (int i = 0; i < this.size; i++) {
			if ((this.size - i) == index) {
				this.array[index] = data;
				this.size++;
				return true;
			}
			this.array[this.size - i] = this.array[this.size - 1 - i];
		}
		return false;
	}

	/**
	 * Remove element and shift down to fill gap
	 * @param index
	 */
	public void shiftDownAndRemove(int index) {
		for (int i = index; i < this.size - 1; i++) {
			this.array[i] = this.array[i + 1];
		}
		this.size--;
	}

	/**
	 * Returns true if this list contains the specified E
	 * 
	 * @param data
	 * @return boolean
	 */
	@Override
	public boolean contains(E data) {
		if (data != null) {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i].equals(data))
					return true;
			}
		}
		return false;
	}

	/**
	 * Returns the E at the specified position in this list
	 * 
	 * @param index
	 * @return E
	 * @throws Exception
	 *             if index out of range
	 */
	@Override
	public E get(int index) throws Exception {
		if (checkRange(index)) {
			for (int i = 0; i < this.array.length; i++) {
				if (i == index)
					return this.array[i];
			}
		}
		return null;
	}

	/**
	 * Returns the E at the specified position in this list and deletes it
	 * from the list
	 * 
	 * @param index
	 *            element to remove
	 * @return E element removed if found, else null
	 * @throws Exception
	 *             if index out of range
	 */
	@Override
	public E remove(int index) throws Exception {
		if (this.array[index] != null) {
			E element = this.array[index];
			shiftDownAndRemove(index);
			return element;
		}
		else
			throw new Exception();
	}

	/**
	 * Returns the index of the first occurrence of the specified E in this
	 * list, or -1 if this list does not contain the E
	 * 
	 * @param data
	 *            element to search for
	 * @return int position of data if found, else -1
	 */
	@Override
	public int indexOf(E data) {
		if (data != null) {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i].equals(data))
					return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(E data) {
		int index = -1;
		if (data != null) {
			for (int i = 0; i < this.size; i++) {
				if (this.array[i].equals(data))
					index = i;
			}
		}
		return index;
	}

	/**
	 * Trims the capacity of this instance to be the list's current size. An
	 * application can use this operation to minimize the storage of an
	 * instance.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void trimToSize() {
		E[] newArray = (E[]) new Object[this.size];
		this.capacity = this.size;
		for (int i = 0; i < this.size; i++) {
			newArray[i] = this.array[i];
		}
	}
	
	@Override
	public String toString() {

		String s = "[";
		if (!isEmpty()) {
			for (int i=0; i< size-1; i++)
				s += array[i] + ", ";
			s += array[size-1];
		}
		return s += "]";
	}

	/**
	 * Grow array
	 */
	private void resize() {
		try {
			this.array = this.doubleArraySizeAndCopy();
		} catch (OutOfMemoryError e) {
			e.printStackTrace();
		}
	}

	/**
	 * Double size and copy elements.  
	 * @return E[]
	 */
	@SuppressWarnings("unchecked") // uncomment for generic type
	private E[] doubleArraySizeAndCopy() {
		E[] temp = (E[]) new Object[this.array.length * 2];
		this.capacity = this.array.length * 2;
		for (int i = 0; i < this.array.length; i++) {
			temp[i] = this.array[i];
		}
		/* Alternately, could  use:
		 *    temp = Arrays.copyOf(array, temp.length);
		 */
		return temp;
	}

	private boolean checkRange(int index) throws Exception {
		if (index < 0)
			throw new IllegalArgumentException("Index cannot be negative");
		if (index >= this.size)
			throw new IndexOutOfBoundsException("Cannot access " + index + " element");
		return true;
	}	

	public String getID () {
		return "Program 6, Christian James";
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getIncrement() {
		return this.increment;
	}
}
