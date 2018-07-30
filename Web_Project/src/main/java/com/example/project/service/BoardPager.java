package com.example.project.service;

public class BoardPager {
	public static final int PAGE_SCALE = 10; //한 페이지당 게시글을 몇 개 넣을 것인지 
	public static final int BLOCK_SCALE = 3; //글이 되게 많아졌어, 1,2,3,4,5,6,7,8,9,10이렇게 줄줄이잖아 근데 그럼 몇개씩 1~10까지 11~20까지 보여지는 페이지 수를 한 블락으로 볼 것이다.
	
	private int curPage;
	private int prevPage;
	private int nextPage;
	private int totPage;//전체 페이지 갯수
	private int totBlock;//전체 페이지 블록 갯수
	private int curBlock;//현재 페이지 블록
	private int prevBlock;//이전 페이지 블록
	private int nextBlock;//다음 페이지 블록
	private int pageBegin;
	private int pageEnd;
	private int blockBegin;//현재 페이지 블록의 시작번호
	private int blockEnd;
	public BoardPager() {
		super();
	}
	public BoardPager(int count, int curPage) {
		curBlock = 1;//블록값 초기화
		this.curPage = curPage;
		setTotPage(count);
		setBlockRange();
		setPageRange();
		setTotBlock();
	}
	public void setBlockRange() {
		curBlock = (int)Math.ceil((curPage-1)/BLOCK_SCALE)+1; //현재페이지가 몇블록인지 수식
		blockBegin = (curBlock-1)*BLOCK_SCALE+1; //if 2번째 블록이라면 11페이지 부터 시작이란 소리
		blockEnd = blockBegin+BLOCK_SCALE-1;
		if(blockEnd > totPage)
			blockEnd = totPage;
		prevPage = (curPage==1)?1:(curBlock-1)*BLOCK_SCALE;
		nextPage = curBlock>totBlock?(curBlock*BLOCK_SCALE):(curBlock*BLOCK_SCALE)+1; 
		if(nextPage>=totPage)nextPage=totPage;
	}
	public void setPageRange() {
		pageBegin = (curPage-1)*PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int count) {
		totPage = (int)Math.ceil(count*1.0/PAGE_SCALE);
	}
	public int getTotBlock() {
		return totBlock;
	}
	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage/BLOCK_SCALE);
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getPrevBlock() {
		return prevBlock;
	}
	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}
	public int getNextBlock() {
		return nextBlock;
	}
	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public int getBlockBegin() {
		return blockBegin;
	}
	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}
	public int getBlockEnd() {
		return blockEnd;
	}
	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	public static int getPageScale() {
		return PAGE_SCALE;
	}
	public static int getBlockScale() {
		return BLOCK_SCALE;
	}
}
