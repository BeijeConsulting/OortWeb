package it.beije.oort.web.bassanelli.phonebook_application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

	public static final String TABLE_CONTACT = Contact.class.getSimpleName();
	public static final String FIELD_ID = "id";
	public static final String FIELD_NAME = "name";
	public static final String FIELD_SURNAME = "surname";
	public static final String FIELD_MOBILE = "mobile";
	public static final String FIELD_EMAIL = "email";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = FIELD_ID)
	private int id;

	@Column(name = FIELD_NAME)
	private String name;

	@Column(name = FIELD_SURNAME)
	private String surname;

	@Column(name = FIELD_MOBILE)
	private String mobile;

	@Column(name = FIELD_EMAIL)
	private String email;

	public Contact() {
	}

	public Contact(String name, String surname, String mobile) {
		this(name, surname, mobile, "");
	}

	public Contact(String name, String cognome, String mobile, String email) {
		this.name = name;
		this.surname = cognome;
		this.mobile = mobile;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		setId(Integer.parseInt(id));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return this.toString("ID;NAME;SURNAME;MOBILE;EMAIL");
	}

	public String toString(String pattern) {

		String[] fields = pattern.split(";", -1);

		StringBuilder builder = new StringBuilder("[ ");

		for (int i = 0; i < fields.length; i++) {

			switch (fields[i].toUpperCase()) {
			case "ID":
				builder.append("ID: ").append(this.id).append(" ");
				break;
			case "NAME":
				builder.append("NAME: ").append(this.name).append(" ");
				break;
			case "SURNAME":
				builder.append("SURNAME: ").append(this.surname).append(" ");
				break;
			case "MOBILE":
				builder.append("MOBILE: ").append(this.mobile).append(" ");
				break;
			case "EMAIL":
				builder.append("EMAIL: ").append(this.email).append(" ");
				break;
			}
		}

		return builder.append("]").toString();
	}
	
}
