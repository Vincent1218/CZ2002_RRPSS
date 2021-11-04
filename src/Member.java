
public class Member {
	private String name;
	private int memberId;
	private String contact;
	
	public Member(String name, String contact, int memberId) {
		this.name = name;
		this.contact = contact;
		this.memberId = memberId;
	}
	
	public String getContact() {
		return this.contact;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMemberId() {
		return this.memberId;
	}
	
}
