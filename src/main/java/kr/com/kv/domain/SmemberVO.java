package kr.com.kv.domain;

import java.util.Date;

public class SmemberVO {
	
	private String smid;
	private String name;
	private String password;
	private String tel;
	private String accno;
	private String email;
	private Date regdate;
	private String addr1;
	private String addr2;
	
	
	
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getSmid() {
		return smid;
	}
	public void setSmid(String smid) {
		this.smid = smid;
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
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
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
	@Override
	public String toString() {
		return "SmemberVO [smid=" + smid + ", name=" + name + ", password=" + password + ", tel=" + tel + ", accno="
				+ accno + ", email=" + email + ", regdate=" + regdate + ", addr1=" + addr1 + ", addr2=" + addr2 + "]";
	}
		

}
