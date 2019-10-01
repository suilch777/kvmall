package kr.com.kv.domain;

public class CartVO {
	private String rmemberid;
	private KvproductVO pcode;
	private KvproductVO pname;
	private int cnt;
	
	public String getRmemberid() {
		return rmemberid;
	}
	public void setRmemberid(String rmemberid) {
		this.rmemberid = rmemberid;
	}
	public KvproductVO getPcode() {
		return pcode;
	}
	public void setPcode(KvproductVO pcode) {
		this.pcode = pcode;
	}
	public KvproductVO getPname() {
		return pname;
	}
	public void setPname(KvproductVO pname) {
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
		return "cartVO [rmemberid=" + rmemberid + ", pcode=" + pcode + ", pname=" + pname + ", cnt=" + cnt + "]";
	}

	
	
}
