package com.alibaba.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.bean.User;
@Component
public class UserMapper{
	Map<String, User> MS = new HashMap<String, User>();
	public UserMapper() {
		User user = new User(new Long(1),"张三","123456");
		MS.put("张三", user);
	}
	public User findUserByName(String username) {
		if(MS.containsKey(username))return MS.get(username);
		else return null;
	}
	public void regist(User user) {
		MS.put(user.getUsername(), user);
	}
	public Long login(User user) {
		if(MS.containsKey(user.getUsername())&&MS.get(user.getUsername()).getPassword().equals(user.getPassword()))return MS.get(user.getUsername()).getId();
		return null;
	}
	
}