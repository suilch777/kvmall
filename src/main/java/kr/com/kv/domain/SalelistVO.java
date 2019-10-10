package kr.com.kv.domain;

public class SalelistVO {
private String pcode;
private String smid;
private String cmid;
private String pname;
private int price;
private int cnt;


public String getPcode() {
	return pcode;
}
public void setPcode(String pcode) {
	this.pcode = pcode;
}
public String getSmid() {
	return smid;
}
public void setSmid(String smid) {
	this.smid = smid;
}
public String getCmid() {
	return cmid;
}
public void setCmid(String cmid) {
	this.cmid = cmid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
@Override
public String toString() {
	return "Salelist [pcode=" + pcode + ", smid=" + smid + ", cmid=" + cmid + ", pname=" + pname + ", price=" + price
			+ ", cnt=" + cnt + "]";
}


}
