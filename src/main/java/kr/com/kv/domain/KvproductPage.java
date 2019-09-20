package kr.com.kv.domain;

import java.util.List;



public class KvproductPage {
	
	private int total; //?쟾泥? 寃뚯떆?뙋 湲??쓽 媛??닔
	private int currentPage; //?쁽?옱 ?럹?씠吏? 踰덊샇
	private List<KvproductVO> content; //?쁽?옱 ?솕硫댁뿉 display ?맆 寃뚯떆?뙋 由ъ뒪?듃?궡?슜
	private int totalPages; //?쟾泥? ?럹?씠吏? ?닔 
	private int startPage; //?떆?옉踰덊샇
	private int endPage; //?걹踰덊샇
	private int pageSize = 10;//?븳 ?솕硫댁뿉 ?몴?떆?맆 ?럹?씠吏? 媛??닔
	
	// size: ?븳 ?럹?씠吏??뿉 display?맆 寃뚯떆湲??쓽 媛??닔
	public KvproductPage(int total, int currentPage, int size, List<KvproductVO> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if(total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		}else {
			// 123 : 13?럹?씠吏?
			totalPages = total / size; //123/10 = 12
			if(total % size > 0) {
				totalPages++; //13
			}
			//?쁽?젣 ?럹?씠吏? 踰덊샇媛? 12?씪 寃쎌슦, modVal 2媛? ?맖
			int modVal = currentPage % pageSize;
			// 12/10 = 1-> 1* 10 =10 -> 10 + 1 = 11
			startPage = currentPage / pageSize * pageSize + 1;
			
			// currentPage = 20, startPage = 21
			if(modVal == 0) { //?쁽 ?럹?씠吏??쓽 ?젣?씪 留덉?留? 踰덊샇?씤媛??
				startPage -= pageSize; //?떆?옉 11
			}
			
			// ?떆?옉 ?럹?씠吏? 11 : ?걹 20
			endPage = startPage + (pageSize -1);
			
			//寃뚯떆臾쇱씈 媛??닔 : 123, 珥? ?럹?씠吏? 踰덊샇 :13
			// start 11, endPage 20
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	
	public int getTotal() {
		return total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public List<KvproductVO> getContent() {
		return content;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	public boolean hasNoArticles() {
		return total == 0;
	}
	
	public boolean hasArticles() {
		return total > 0;
	}
	@Override
	public String toString() {
		return "SpmsPage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + ", pageSize=" + pageSize + "]";
	}

}
