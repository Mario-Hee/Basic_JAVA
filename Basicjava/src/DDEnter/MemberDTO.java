package problem.DDEnter;

import java.sql.Date;

public class MemberDTO {
	// 1.변수(DB Table 참조)
	private String ano;    //null 
	private String aname;    //null -공유
	private String major;   //null - 연기
	private String groupyn;   //null -y
	private String groupnm; //null -도깨비
	private int sal;         // 0 - 9000
	private Date regdate;    //null 전역변수이므로 자동으로 자바가 초기화 해준다
	
	// 2.생성자(Default, 전역변수 ALL)
	public MemberDTO() {} // 생성자메서드는 만들지않는다

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal, Date regdate) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
		this.regdate = regdate;
	}
	

	public MemberDTO(String aname, String major, String groupyn, String proupnm, int sal) {  // 메인의 매개변수의 다섯개값이 그대로 들어왔다!
		super();
		this.aname = aname; //지역변수! aname : 공유가 들어가 있다! 
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = proupnm;
		this.sal = sal;
	}
	
	
	

	public MemberDTO(String ano, String aname, String major, String groupyn, String groupnm, int sal) { // 여섯개의 매개변수
		super();
		this.ano = ano;
		this.aname = aname;
		this.major = major;
		this.groupyn = groupyn;
		this.groupnm = groupnm;
		this.sal = sal;
	}

	// 3. getter(), setter()
	public String getAno() {  //7개 변수의...
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGroupyn() {
		return groupyn;
	}

	public void setGroupyn(String groupyn) {
		this.groupyn = groupyn;
	}

	public String getGroupnm() {
		return groupnm;
	}

	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	// 4. toString()  // 값을 잘 입력 했는지 확인 할 수 있다! 값이 없다면 null이 뜬다.
	@Override
	public String toString() {
		return "MemberDTO [ano=" + ano + ", aname=" + aname + ", major=" + major + ", groupyn=" + groupyn + ", groupnm="
				+ groupnm + ", sal=" + sal + ", regdate=" + regdate + "]";
	}
	
	
	
	
	
	

	
}
