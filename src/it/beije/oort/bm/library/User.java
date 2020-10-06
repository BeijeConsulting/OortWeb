package it.beije.oort.bm.library;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Comparable<User>, Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int id;
	@Column
	private String surname;
	@Column
	private String name;
	@Column(name = "fiscal_code")
	private String fc;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private boolean admin;
	@Column
	private String password;
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("| ").append("id: ").append(id).append(" | ")
			.append("surname : ").append(this.surname).append(" | ")
			.append("name : ").append(this.name).append(" | ")
			.append("fiscal code : ").append(this.fc).append(" | ")
			.append("address : ").append(this.address).append(" | ")
			.append("phone n� : ").append(this.phone).append(" | ")
			.append("e-mail : ").append(this.email).append(" |");	
		return builder.toString();
	}
	
	@Override
	public int compareTo(User u) {
		int comp = this.surname.compareTo(u.getSurname());
		if(comp == 0) {
			return this.name.compareTo(u.getName());
		}
		return comp;
	}

}
