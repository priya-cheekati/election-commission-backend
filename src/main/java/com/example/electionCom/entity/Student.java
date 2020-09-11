package com.example.electionCom.entity;

public class Student {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String passportNumber;
    
    public Student() {
        super();
    }
    public Student(Long id, String username, String password, String name, String passportNumber) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.passportNumber = passportNumber;
    }
    public Student(String username, String password, String name, String passportNumber) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.passportNumber = passportNumber;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
    @Override
    public String toString() {
        return String.format("Student [id=%s, password=%s, name=%s, passportNumber=%s]", id, password, name, passportNumber);
    }
}