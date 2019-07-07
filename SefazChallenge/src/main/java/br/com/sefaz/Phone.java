package br.com.sefaz;

public class Phone {
	
	private int ddd;
	private String number;
	private String type;
	
	
	
	public Phone(int ddd, String number, String type) {
		this.ddd = ddd;
		this.number = number;
		this.type = type;
	}
	
	
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
}
