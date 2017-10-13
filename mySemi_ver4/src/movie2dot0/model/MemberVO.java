package movie2dot0.model;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String nick;
	private String address;
	private String birthday;
	private String tel;
	private String grade;
	private String favoriteGenre;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String name, String password, String nick, String address, String birthday, String tel,
			String grade, String favoriteGenre) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.nick = nick;
		this.address = address;
		this.birthday = birthday;
		this.tel = tel;
		this.grade = grade;
		this.favoriteGenre = favoriteGenre;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", nick=" + nick + ", address="
				+ address + ", birthday=" + birthday + ", tel=" + tel + ", grade=" + grade + ", favoriteGenre="
				+ favoriteGenre + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getFavoriteGenre() {
		return favoriteGenre;
	}

	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}
	
	
}
