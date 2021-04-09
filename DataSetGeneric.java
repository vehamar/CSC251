
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataSetGeneric<E extends Measurable> extends ArrayList<E> {

	public DataSetGeneric() {
		
	}

	public DataSetGeneric(Collection<E> ds) {
		super(ds);
	}

	@SafeVarargs
	public DataSetGeneric(E... Es) {
		super(Arrays.asList(Es));
	}

	public List<E> getList() {
		return this;
	}

	public E getMax() {
		return isEmpty() ? null : Collections.max(this, Comparator.comparing(E::getMeasure));
	}

	public E getMin() {
		return isEmpty() ? null : Collections.min(this, Comparator.comparing(E::getMeasure));
	}

	public List<E> sort() {
		Object[] data = toArray();
		mergeSort(data);
		return (List<E>) Arrays.asList(data);
	}
	
	private void mergeSort(Object[] data) {
		if(data.length > 1) {
			int halfLength = data.length / 2;
			Object[] list1 = Arrays.copyOfRange(data, 0, halfLength);
			mergeSort(list1);
			Object[] list2 = Arrays.copyOfRange(data, halfLength, data.length);
			mergeSort(list2);
			merge(list1, list2, data);
		}
	}
	
	private void merge(Object[] list1, Object[] list2, Object[] data) {
		int index1 = 0;
		int index2 = 0;
		int index3 = 0;
		while(index1 < list1.length && index2 < list2.length) {
			if(((E)list1[index1]).getMeasure() < ((E)list2[index2]).getMeasure())
				data[index3++] = list1[index1++];
			else
				data[index3++] = list2[index2++];
		}
		while(index1 < list1.length)
			data[index3++] = list1[index1++];
		while(index2 < list2.length)
			data[index3++] = list2[index2++];
	}

	public List<E> sortBy(java.util.Comparator<? super E> comparator) {
		if (isEmpty()) {
			return null;
		}
		List<E> ds = new DataSetGeneric<>(this);
		ds.sort(comparator);
		return ds;
	}

	@Override
	public String toString() {
		String str = isEmpty() ? super.toString() : "\nDataSet\n";
		for (E e : this) {
			str += e + "\n";
		}
		return str;
	}

}
