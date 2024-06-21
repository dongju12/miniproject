
public class DTO {

	// 필드값
	private String id;
	private String pw;
	private String name;
	private String MBTI1;
	private boolean login;
	private String mbti1;
	private String mbti2;
	private String mbti3;
	private String title;
	private String path;
	
	
	
	public DTO(String path) {
		this.path = path;
	}




	// 생성자 메소드
	public DTO(String MBTI1, String id, String pw) {
		this.MBTI1 = MBTI1;
		this.id = id;
		this.pw = pw;
	}
	
	
	

	public DTO(String MBTI1,String id, String pw, String name) {
		this.MBTI1 = MBTI1;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	public String getMbti1() {
		return mbti1;
	}




	public void setMbti1(String mbti1) {
		this.mbti1 = mbti1;
	}




	public String getMbti2() {
		return mbti2;
	}




	public void setMbti2(String mbti2) {
		this.mbti2 = mbti2;
	}




	public String getMbti3() {
		return mbti3;
	}




	public void setMbti3(String mbti3) {
		this.mbti3 = mbti3;
	}




	public DTO(String name,String mbti1, String mbti2, String mbti3, String pw) {
		
		this.mbti1 = mbti1;
		this.mbti2 = mbti2;
		this.mbti3 = mbti3;
		
		
		
	}


	public DTO() {

	}

	public DTO(boolean login) {
		
	}

	// 게터세터

	public String getMBTI1() {
		return MBTI1;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public void setMBTI1(String MBTI1) {
		this.MBTI1 = MBTI1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
