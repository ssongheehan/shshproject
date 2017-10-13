package movie2dot0.model;

public class BoardVO {
	private String rv_no;
	private String mv_no;
	private String content;
	private String id;
	private String timePosted;
	private int hits;
	private String title;
	public BoardVO() {
		super();
	}
	public BoardVO(String rv_no, String mv_no, String content, String id, String timePosted, int hits, String title) {
		super();
		this.rv_no = rv_no;
		this.mv_no = mv_no;
		this.content = content;
		this.id = id;
		this.timePosted = timePosted;
		this.hits = hits;
		this.title = title;
	}
	
	public BoardVO(String rv_no, String content, String id, String timePosted, int hits, String title) {
		super();
		this.rv_no = rv_no;
		this.content = content;
		this.id = id;
		this.timePosted = timePosted;
		this.hits = hits;
		this.title = title;
	}
	@Override
	public String toString() {
		return "BoardVO [rv_no=" + rv_no + ", mv_no=" + mv_no + ", content=" + content + ", id=" + id + ", timePosted="
				+ timePosted + ", hits=" + hits + ", title=" + title + "]";
	}
	public String getRv_no() {
		return rv_no;
	}
	public void setRv_no(String rv_no) {
		this.rv_no = rv_no;
	}
	public String getMv_no() {
		return mv_no;
	}
	public void setMv_no(String mv_no) {
		this.mv_no = mv_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
