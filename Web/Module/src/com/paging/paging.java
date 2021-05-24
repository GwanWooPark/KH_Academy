package com.paging;

public class paging {

	public static String setPaging(int viewcount, int listsize, int page, String url) {
		//viewcount : 한 페이지에 보여줄 갯수, listsize : list의 총 갯수, page : 현재 페이지, String url : page 이동할 url

		// 총 페이지수
		int countallpage = listsize/viewcount;
		System.out.println("총페이지 수 :"+countallpage);
		
		String res = "<div id=\"pagaing\">\r\n"
				+ "<ul class=\"pagination\">";

		// 페이지 체크
		int tencount = page/10;
		System.out.println("tencount :" +tencount);
		
		//?가 url에 포함되어 있으면 & 없으면 ?를 가장 뒤에 붙여준다.
		if(url.indexOf("?")>=0) {
			url = url.concat("&");
		}else {
			url = url.concat("?");
		}
		
		if(page>=10) {
			res = res.concat("<li><a href='"+url+"page="+(tencount*10-1)+"'><<</a></li>\n");
		}
		if((tencount*10)+10>countallpage) {
			for(int i = tencount*10; i<=countallpage;i++) {
				if(page==i) { // 현재페이지 색칠하기
					String pagination = "<li class=\"active\"><a style=\"background-color: salmon;border-color: salmon;\"  href='"+url+"page="+i+"'>"+(i+1)+"</a></li>\n";
					System.out.println(pagination);
					res = res.concat(pagination);	
				}else {
					String pagination = "<li><a href='"+url+"page="+i+"'>"+(i+1)+"</a></li>\n";
					System.out.println(pagination);
					res = res.concat(pagination);							
				}	
			}
		}else {
			for(int i = tencount*10; i<=tencount*10+9;i++) {
				if(page == i) {
					String pagination = "<li class=\"active\"><a style=\"background-color: salmon;border-color: salmon;\"  href='"+url+"page="+i+"'>"+(i+1)+"</a></li>\n";
					System.out.println(pagination);
					res = res.concat(pagination);						
				}else {
					String pagination = "<li><a href='"+url+"page="+i+"'>"+(i+1)+"</a></li>\n";
					System.out.println(pagination);
					res = res.concat(pagination);	
					
				}		
			}
			res = res.concat("<li><a href='"+url+"page="+(tencount*10+10)+"'>>></a></li>\n");
		}
		System.out.println(res);
		res = res.concat("</ul>\r\n</div>");
		return res;
	}
}
