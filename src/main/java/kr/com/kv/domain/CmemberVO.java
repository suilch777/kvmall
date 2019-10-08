package kr.com.kv.domain;

import java.util.Date;

public class CmemberVO {
	
	private String cmid;
	private String name;
	private String password;
	private String tel;
	private String email;
	private Date regdate;
	private String addr;
	public String getCmid() {
		return cmid;
	}
	public void setCmid(String cmid) {
		this.cmid = cmid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Cmember [cmid=" + cmid + ", name=" + name + ", password=" + password + ", tel=" + tel + ", email="
				+ email + ", regdate=" + regdate + ", addr=" + addr + "]";
	}
	
	
	

}
