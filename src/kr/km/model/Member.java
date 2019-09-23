package kr.km.model;

import java.util.Date;

public class Member {
	private String memberid;
	private String name;
	private String password;
	private String tel;
	private String email;
	private Date regdate;
	
	
	public Member() {
		super();
	}
	
	public Member(String memberid, String name, String password, Date regdate) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.password = password;
		this.regdate = regdate;
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

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Member [memberid=" + memberid + ", name=" + name + ", password=" + password + ", regdate=" + regdate
				+ "]";
	}
	
}
