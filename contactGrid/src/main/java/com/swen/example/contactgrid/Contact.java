package com.swen.example.contactgrid;

public class Contact {
    private String mName;
    private String mTelNo;
    
    public Contact(String name, String telNo) {
    	mName = name;
    	mTelNo = telNo;
    }
    
    public String getName() {
    	return mName;
    }
    
    public String getTelNo() {
    	return mTelNo;
    }
}
