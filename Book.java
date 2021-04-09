

public class Book implements Measurable {
	
	private String author;
	private String title;
	private int pages;
	public static final Book small = new Book("David", "bite sized thoughts", 40);
	public static final Book medium = new Book("Zack", "nothing special", 300);
	public static final Book large = new Book("Hugo", "ideas on time, space, and matter", 1200);
	
	public Book(String auth, String titl, int pag) {
		author = auth;
		title = titl;
		pages = pag;
	}
	
	public Book(int pag) {
		this("defaultAuthor", "defaultTitle", pag);
	}

	public int getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", pages=" + pages + "]\n";
	}

	// this is a really poor way to compare Book objects, but it will work for us
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (pages != other.pages)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int getMeasure() {
		return getPages();
	}

}
