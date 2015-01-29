/**
 * @Title: Person.java
 * @Package com.lala.domain
 * Copyright: Copyright (c) 2011 
 * @author ly
 * @date Jan 29, 2015 3:43:31 PM
 * @version V1.0
 */

package com.lala.domain;

import org.springframework.data.annotation.Id;

/**
 * @ClassName: Person
 * @author ly
 * @date Jan 29, 2015 3:43:31 PM
 *
 */

public class Person 
{
	@Id
	private String id;
	private String account;
	private String nick;
	private String email;
	private Integer status;
	public Person(){}
	public Person(String account, String nick, String email, Integer status) 
	{
		this.account = account;
		this.nick = nick;
		this.email = email;
		this.status = status;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
