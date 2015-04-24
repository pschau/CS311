
	import java.util.Arrays;

	public class ArrayList<E> {
	  private int size = 0;
	  private static final int CAP = 10;
	  private Object elements[];
	  
	  public ArrayList() {
	    elements = new Object[CAP];
	  }
	  
	  //adds object to array and enlarges array if full
	  public void add(E e) {
	    if (size == elements.length) {
	      enlarge();
	    }  
	    elements[size++] = e;
	  }
	  //returns size of arraylist
	  public int size(){
		  return size;
	  }
	  
	  //enlarges the array by two
	  private void enlarge() {
	    int newSize = elements.length * 2;
	    elements = Arrays.copyOf(elements, newSize);
	  }

	  //returns element by index
	  @SuppressWarnings("unchecked")
	  public E get(int i) {
	    if (i>= size || i <0) {
	      throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
	    }
	    return (E) elements[i];
	  }
	}
	 

