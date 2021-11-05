package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name = "username", length=250)
	private String username;
	
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "description", length=250)
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;


	public Comment(int id, String username, String date, String description) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
		this.description = description;
	}


	public Comment() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", username=" + username + ", date=" + date + ", description=" + description
				+ ", item=" + item + "]";
	}

	
	
	
}
