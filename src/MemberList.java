import java.util.*;

public class MemberList {
	private ArrayList<Member> memberArray;
	
	public MemberList() {
		this.memberArray =new ArrayList<>();
	}
	
	public int registerMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the customer's name?");
		String name = sc.nextLine();
		System.out.println("What is the customer's contact number?");
		String contactNo = sc.nextLine();
		for(int i=0; i<memberArray.size(); i++) {
			if(memberArray.get(i).getContact().equals(contactNo))
				return memberArray.size();
		}
		int memberId = memberArray.size() + 1001; //memberID to start from 1001
		Member newMember =new Member(name,contactNo,memberId);
		memberArray.add(newMember);
		
		return memberId;
	}
	
	public int getSize() {return memberArray.size();}
	
	void removeMember(int memberId) {
		memberArray.remove(memberId-1);
	}
	
	public int checkMember(int memberId, String contact) {
		int index = memberId - 1001;
		if(memberArray.get(index).getMemberId()==memberId && memberArray.get(index).getContact().equals(contact))
			return 1;
		else return 0;
	}
	
	void getMember(int memberId) {
		int index = memberId - 1001;
		System.out.println("Member found.");
		System.out.println("Member ID: " + memberArray.get(index).getMemberId());
		System.out.println("Name: " + memberArray.get(index).getName());
		System.out.println("Contact Number: " + memberArray.get(index).getContact());
	}
}
