package br.com.sefaz;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean (name = "userBean")
@ViewScoped
public class UserBean {
	
	private String name;
	private String email;
	private String password;
	ArrayList<Phone> phones = new ArrayList<Phone>();
	
	
	
	public UserBean(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public UserBean() {
		
	}
	
	public String addPhone(String ddd, String number, String type) {
		Phone phone = new Phone(Integer.parseInt(ddd), number, type);
		phones.add(phone);
		return "";
		
		
	}
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<Phone> getPhones() {
		return phones;
	}
	public void setPhones(ArrayList<Phone> phones) {
		this.phones = phones;
	}
	
	
	

}
