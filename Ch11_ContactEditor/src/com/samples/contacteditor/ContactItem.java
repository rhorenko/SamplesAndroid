package com.samples.contacteditor;

import java.util.HashMap;

public class ContactItem extends HashMap<String, String> {
    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    
    public ContactItem(String name, String phone) {
        super();
        super.put(NAME, name);
        super.put(PHONE, phone);
    }   
    
    public String getName() {
        return super.get(NAME);
    }

    public String getPhone() {
        return super.get(PHONE);
    }
    
    public void setName(String name) {
        super.put(NAME, name);
    }
    
    public void setPhone(String phone) {
        super.put(NAME, phone);
    }
}
