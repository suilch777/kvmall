package kr.com.kv.domain;

public class CartVO {
	private String cmid;
	private String smid;
	private String pcode;
	private String pname;
	private int cnt;
	
	

	
	public String getCmid() {
		return cmid;
	}
	public void setCmid(String cmid) {
		this.cmid = cmid;
	}
	public String getSmid() {
		return smid;
	}
	public void setSmid(String smid) {
		this.smid = smid;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CartVO [cmid=" + cmid + ", smid=" + smid + ", pcode=" + pcode + ", pname=" + pname + ", cnt=" + cnt
				+ "]";
	}
	
	
}
