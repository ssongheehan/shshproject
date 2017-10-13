package movie2dot0.model;

public class MovieVO {
	private String no;
	private String name;
	private String openDate;
	private String info;
	private String director;
	private String genre;
	private String grade;
	private String content;
	private String hits;
	private String runningTime;
	private int openFlag;
	public MovieVO() {
		super();
	}
	public MovieVO(String no, String name, String openDate, String info, String director, String genre, String grade,
			String content, String hits, String runningTime, int openFlag) {
		super();
		this.no = no;
		this.name = name;
		this.openDate = openDate;
		this.info = info;
		this.director = director;
		this.genre = genre;
		this.grade = grade;
		this.content = content;
		this.hits = hits;
		this.runningTime = runningTime;
		this.openFlag = openFlag;
	}
	
	public MovieVO(String no, String name, String openDate) {
		super();
		this.no = no;
		this.name = name;
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "MovieVO [no=" + no + ", name=" + name + ", openDate=" + openDate + ", info=" + info + ", director="
				+ director + ", genre=" + genre + ", grade=" + grade + ", content=" + content + ", hits=" + hits
				+ ", runningTime=" + runningTime + ", openFlag=" + openFlag + "]";
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHits() {
		return hits;
	}
	public void setHits(String hits) {
		this.hits = hits;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public int getOpenFlag() {
		return openFlag;
	}
	public void setOpenFlag(int openFlag) {
		this.openFlag = openFlag;
	}
	
	
}
