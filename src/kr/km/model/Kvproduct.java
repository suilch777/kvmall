package kr.km.model;

import java.sql.Blob;




public class Kvproduct {
	private String pcode;
	private String pname;
	private String pcontent;
	private int price;
	private int dcprice;
	private String color;
	private int size;
	private String pic;
	private int stock;
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Kvproduct() {
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Kvproduct [pcode=" + pcode + ", pname=" + pname + ", pcontent=" + pcontent + ", price=" + price
				+ ", dcprice=" + dcprice + ", color=" + color + ", size=" + size + ", pic=" + pic + ", stock=" + stock
				+ "]";
	}
	
	
	
	
	
}
