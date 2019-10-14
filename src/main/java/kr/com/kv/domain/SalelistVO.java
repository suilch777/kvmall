package kr.com.kv.domain;

import java.util.Date;
import java.util.List;

public class SalelistVO {
private String pcode;
private String smid;
//private String cmid;
private CmemberVO cmid;
private String pname;
private int totalprice;
private int cnt;
private Date paydate;
private Date fwddate;
private Date rcvdate;
private Date stldate;
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
public CmemberVO getCmid() {
	return cmid;
}
public void setCmid(CmemberVO cmid) {
	this.cmid = cmid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
public Date getPaydate() {
	return paydate;
}
public void setPaydate(Date paydate) {
	this.paydate = paydate;
}
public Date getFwddate() {
	return fwddate;
}
public void setFwddate(Date fwddate) {
	this.fwddate = fwddate;
}
public Date getRcvdate() {
	return rcvdate;
}
public void setRcvdate(Date rcvdate) {
	this.rcvdate = rcvdate;
}
public Date getStldate() {
	return stldate;
}
public void setStldate(Date stldate) {
	this.stldate = stldate;
}
@Override
public String toString() {
	return "SalelistVO [pcode=" + pcode + ", smid=" + smid + ", cmid=" + cmid + ", pname=" + pname + ", totalprice="
			+ totalprice + ", cnt=" + cnt + ", paydate=" + paydate + ", fwddate=" + fwddate + ", rcvdate=" + rcvdate
			+ ", stldate=" + stldate + "]";
}


}