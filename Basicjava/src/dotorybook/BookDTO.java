package problem.dotorybook;

import java.sql.Date;

public class BookDTO {

	private String bno;
	private String bname;
	private int price;
	private String company;	
	private String writer;
	private Date regdate;
	
	public BookDTO() {} // 생성자 만들때 디폴트로 기본 생성자 하나는 꼭 만든다

	// 2.생성자(Default, 전역변수 ALL)
	public BookDTO(String bno, String bname, int price, String company, String writer, Date regdate) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.price = price;
		this.company = company;
		this.writer = writer;
		this.regdate = regdate;
	}
	

	
	
	public BookDTO(String bname, int price, String company, String writer) {
		super();
		this.bname = bname;
		this.price = price;
		this.company = company;
		this.writer = writer;
	}
	
	

	public BookDTO(String bno, String bname, int price, String company, String writer) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.price = price;
		this.company = company;
		this.writer = writer;
	}

	// 3. getter(), setter()
	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
		return "BookDTO [bno=" + bno + ", bname=" + bname + ", price=" + price + ", company=" + company + ", writer="
				+ writer + ", regdate=" + regdate + "]";
	}
	
	
	

}
