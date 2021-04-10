import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataSetGenericTester {
	
	private Rocks r1 = new Rocks(15);
	private Rocks r2 = new Rocks(20);
	private Rocks r3 = new Rocks(45);
	private Rocks r4 = new Rocks(65);
	private Rocks r5 = new Rocks(120);
	private Book b1 = new Book(50);
	private Book b2 = new Book(60);
	private Book b3 = new Book(70);
	private Book b4 = new Book(80);
	private Book b5 = new Book(90);
	private Person person1 = new Person(5);
	private Person person2 = new Person(10);
	private Person person3 = new Person(20);
	private Person person4 = new Person(30);
	private Person person5 = new Person(40);
	
	@Test
	public void testSort_Rocks() {
		DataSetGeneric<Rocks> r = new DataSetGeneric<>();
		r.add(r3);
		r.add(r2);
		r.add(r1);
		r.add(r5);
		r.add(r4);
		DataSetGeneric<Rocks> expectedRocks = new DataSetGeneric<>();
		expectedRocks.add(r1);
		expectedRocks.add(r2);
		expectedRocks.add(r3);
		expectedRocks.add(r4);
		expectedRocks.add(r5);
		assertEquals(expectedRocks, r.sort());
	}
	
	@Test
	public void testSort_Book() {
		DataSetGeneric<Book> b = new DataSetGeneric<>();
		b.add(b4);
		b.add(b1);
		b.add(b3);
		b.add(b5);
		b.add(b2);
		DataSetGeneric<Book> expectedBooks = new DataSetGeneric<>();
		expectedBooks.add(b1);
		expectedBooks.add(b2);
		expectedBooks.add(b3);
		expectedBooks.add(b4);
		expectedBooks.add(b5);
		assertEquals(expectedBooks, b.sort());
	}
	
	@Test
	public void testSort_Person() {
		DataSetGeneric<Person> personList = new DataSetGeneric<>();
		personList.add(person3);
		personList.add(person2);
		personList.add(person5);
		personList.add(person1);
		personList.add(person4);
		DataSetGeneric<Person> expectedPerson = new DataSetGeneric<>();
		expectedPerson.add(person1);
		expectedPerson.add(person2);
		expectedPerson.add(person3);
		expectedPerson.add(person4);
		expectedPerson.add(person5);
		assertEquals(expectedPerson, personList.sort());
	}
	
	@Test
	public void testGetList() {
		DataSetGeneric<Rocks> r = new DataSetGeneric<>();
		r.add(r4);
		r.add(r1);
		r.add(r5);
		List<Rocks> expected = new ArrayList<>();
		expected.add(new Rocks(65));
		expected.add(new Rocks(15));
		expected.add(new Rocks(120));
		assertEquals(expected, r.getList());
	}
	
	@Test
	public void testGetList_EmptyList() {
		DataSetGeneric<Rocks> r = new DataSetGeneric<>();	
		DataSetGeneric<Rocks> expected = new DataSetGeneric<>();	
		assertEquals(expected, r.getList());
	}
	
	@Test
	public void testGetMin() {
		DataSetGeneric<Rocks> r = new DataSetGeneric<>();
		r.add(r2);
		r.add(r3);
		r.add(r1);
		assertEquals(r1, r.getMin());
	}
	
	@Test
	public void testGetMax() {
		DataSetGeneric<Rocks> r = new DataSetGeneric<>();
		r.add(r2);
		r.add(r3);
		r.add(r1);
		assertEquals(r3, r.getMax());
	}
	
	@Test
	public void testSortByRocks() {
		// sorting a large-med-small Rocks list in ascending order
		DataSetGeneric<Rocks> lms = new DataSetGeneric<>();
		lms.add(r3);
		lms.add(r2);
		lms.add(r1);
		List<Rocks> expected = new ArrayList<>();
		expected.add(r1);
		expected.add(r2);
		expected.add(r3);
		assertEquals(expected, lms.sortBy(new RocksComparator()));
	}
	
	@Test
	public void testToString() {
		DataSetGeneric<Rocks> r = new DataSetGeneric<>();
		r.add(r2);
		r.add(r3);
		r.add(r1);
		String expected = "DataSetGeneric:\nsize(): 3\ngetMin(): Rock weight: " 
				+ "15g\ngetMax(): Rock weight: 45g" 
				+ "\n[Rock weight: 20g, Rock weight: 45g, Rock weight: 15g]";
		assertEquals(expected, r.toString());	
	}
	
	public class RocksComparator implements Comparator<Rocks>, Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int compare(Rocks r1, Rocks r2) {
			int weight1 = r1.getMeasure();
			int weight2 = r2.getMeasure();
			
			if (weight1 < weight2) {
				return -1;
			}
			else if (weight1 == weight2) {
				return 0;
			}
			else {
				return 1;
			}
		}
	}
}

