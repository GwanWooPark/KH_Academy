package com.paging.dto;

public class Board {
	
	private int myno;
	private String myname;
	private String mytitle;
	
	public Board() {
		
	}
	
	public Board(int myno, String myname, String mytitle) {
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
	}
	public int getMyno() {
		return myno;
	}
	public void setMyno(int myno) {
		this.myno = myno;
	}
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMytitle() {
		return mytitle;
	}
	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

}
