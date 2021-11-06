package Project;

public class Member {
	private String name;
	private int memberId;
	private int contact;
	
	public Member(String name, int contact, int memberId) {
		this.name = name;
		this.contact = contact;
		this.memberId = memberId;
	}
	
	public int getContact() {return this.contact;}
	public String getName() {return this.name;}
	public int getMemberId() {return this.memberId;}
	
}
