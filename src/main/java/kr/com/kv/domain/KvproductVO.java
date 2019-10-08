package kr.com.kv.domain;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;




public class KvproductVO {
	private String pcode;
	private String smemberid;
	private String pname;
	private String pcontent;
	private int price;
	private int dcprice;
	private String color;
	private int size;
	private int stock;
	private String pic;
	private List<String> files;
	
	
	
	
	public String getSmemberid() {
		return smemberid;
	}
	public void setSmemberid(String smemberid) {
		this.smemberid = smemberid;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public KvproductVO() {
		super();
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
	public void setfiles(ArrayList<String> list) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "KvproductVO [pcode=" + pcode + ", smemberid=" + smemberid + ", pname=" + pname + ", pcontent="
				+ pcontent + ", price=" + price + ", dcprice=" + dcprice + ", color=" + color + ", size=" + size
				+ ", stock=" + stock + ", pic=" + pic + ", files=" + files + "]";
	}
	
		
	
}
