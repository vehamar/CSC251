
public class Person implements Measurable {
	
	private int age = 0;
	
	public Person(int age) {
		this.age = age;
	}

	@Override
	public int getMeasure() {
		 return age;
	}
	
	@Override
	public boolean equals(Object o) {
		Person otherPerson = (Person) o;
		return this.age == otherPerson.age;
	}
	
	@Override
	public String toString() {
		return "Person's age: " + age + "years";
	}

}
