package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.dummyapi;

import java.util.List;

public class PResponse {
	private List<ContactsItem> contacts;

	public void setContacts(List<ContactsItem> contacts){
		this.contacts = contacts;
	}

	public List<ContactsItem> getContacts(){
		return contacts;
	}

	@Override
 	public String toString(){
		return 
			"PResponse{" +
			"contacts = '" + contacts + '\'' + 
			"}";
		}
}