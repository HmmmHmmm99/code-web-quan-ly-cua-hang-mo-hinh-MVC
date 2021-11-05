package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="itemSale")
public class ItemSale implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name = "title", length=250)
	private String title;
	
	@Column(name = "description", length=250)
	private String description;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "path", length=250)
	private String path;
	
	@Column(name = "stock")
	private int stock;
		
	public ItemSale(int id, String title, String description, float price, String path, int stock) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.path = path;
		this.stock = stock;
	}
	
	

	public ItemSale(String title, String description, float price, int stock) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}



	public ItemSale(String title, String description, float price, String path, int stock) {
		super();
		this.title = title;
		this.description = description;
		this.price = price;
		this.path = path;
		this.stock = stock;
	}



	public ItemSale() {
		super();
	}
	
	public ItemSale(String title) {
		super();
		this.title = title;
	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ItemSale [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", path=" + path + ", stock=" + stock + "]";
	}
	
}
