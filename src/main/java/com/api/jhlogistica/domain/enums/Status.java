package com.api.jhlogistica.domain.enums;

public enum Status {
	
	CONCLUDED(1, "Transport concluded"), 
	PROCESSING(2, "Transport processing"), 
	CANCELED(3, "Transport canceled");
	
	private int cod;
	private String description;
	
	private Status(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	public String getDescription() {
		return description;
	}
	
	public static Status toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		for (Status x : Status.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid id: " + cod);
	}
}