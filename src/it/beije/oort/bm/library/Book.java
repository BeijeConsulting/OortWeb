package it.beije.oort.bm.library;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book implements Comparable<Book>, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_book")
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@ManyToOne(optional=false)
	@Column
	private Author author;
	@ManyToOne(optional=false)
	@Column
	private Publisher publisher;
	@Column
	private String year;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Publisher getPublisher() {
		return publisher;
	}


	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		if(year.length() != 4) throw new IllegalArgumentException("Year must be 4 digits long.");
		try {
			Integer.parseInt(year);
		}catch(NumberFormatException ex) {
			throw new IllegalArgumentException("Year must be a number!");
		}
		this.year = year;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| ").append("id: ").append(id).append(" | ")
			.append("title : ").append(this.title).append(" | ")
			.append("description : ").append(this.description).append(" | ")
			.append("author : ").append(this.author).append(" | ")
			.append("publisher : ").append(this.publisher).append(" |\n")
			.append("\t| Biography : ").append(year).append(" |");
		
		return builder.toString();
	}
	
	@Override
	public int compareTo(Book b) {
		int comp = this.title.compareTo(b.getTitle());
		if(comp == 0) {
			comp = this.publisher.compareTo(b.getPublisher());
			if(comp==0) {
				comp = this.year.compareTo(getYear());
			}
		}
		return comp;
	}

}
