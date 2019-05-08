package zhan.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer uid;
	private String username;
	private String password;
	private String address;
	//一个用户可以有多个拜访记录
	private Set<Visit> setUserVisit = new HashSet<Visit>();
	
	public Set<Visit> getSetUserVisit() {
		return setUserVisit;
	}
	public void setSetUserVisit(Set<Visit> setUserVisit) {
		this.setUserVisit = setUserVisit;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", address=" + address + "]";
	}
}
