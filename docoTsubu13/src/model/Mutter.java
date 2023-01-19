package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private int id;
	private String userName;
	private String text;
	private String fd;

	public Mutter() {
	}

	public Mutter(String userName, String text) {
		this.userName = userName;
		this.text = text;
	}
	
	
	public Mutter(String userName, String text, String fd) {
		this.userName = userName;
		this.text = text;
		this.fd = fd;
	}
	
	public Mutter(int id, String userName, String text) {
		this.id = id;
		this.userName = userName;
		this.text = text;
	}
	
	public Mutter(int id, String userName, String text, String fd) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.fd = fd;
	}

	
	public String toString() {
		return fd + " " + id + ": " + userName + ": " + text;
	}
	
	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}

	public String getFd() {
		return fd;
	}

}
