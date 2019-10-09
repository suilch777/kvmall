package kr.com.kv.domain;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;




public class KvproductVO {
	private String pcode;
	private String pname;
	private String pcontent;
	private int price;
	private int dcprice;
	private int stock;
	private String color;
	private int size;
	private String pic;
	private String smid;
	private Date regdate;
	private List<String> files;
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
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDcprice() {
		return dcprice;
	}
	public void setDcprice(int dcprice) {
		this.dcprice = dcprice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getSmid() {
		return smid;
	}
	public void setSmid(String smid) {
		this.smid = smid;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "KvproductVO [pcode=" + pcode + ", pname=" + pname + ", pcontent=" + pcontent + ", price=" + price
				+ ", dcprice=" + dcprice + ", stock=" + stock + ", color=" + color + ", size=" + size + ", pic=" + pic
				+ ", smid=" + smid + ", regdate=" + regdate + ", files=" + files + "]";
	}
	
	
	
	
	
}