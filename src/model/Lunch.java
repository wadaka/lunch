package model;

import java.io.Serializable;

public class Lunch  implements Serializable{
	private int id;
	private String name;
	private String menu;
	public Lunch() {}
	public Lunch(String name,String menu) {
		this.name=name;
		this.menu=menu;
	}
	public Lunch(int id,String name,String menu) {
		this(name,menu);
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}

}
