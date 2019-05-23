package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.dummyapi;

public class Phone{
	private String mobile;
	private String office;
	private String home;

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setOffice(String office){
		this.office = office;
	}

	public String getOffice(){
		return office;
	}

	public void setHome(String home){
		this.home = home;
	}

	public String getHome(){
		return home;
	}

	@Override
 	public String toString(){
		return 
			"Phone{" + 
			"mobile = '" + mobile + '\'' + 
			",office = '" + office + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}
