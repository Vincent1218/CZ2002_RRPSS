package Project;

import java.util.*;

public class MemberList {
	private ArrayList<Member> memberArray;
	
	public MemberList() {this.memberArray =new ArrayList<>();}
	
	public void registerMember()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the customer's name?");
		String name = sc.nextLine();
		int counter=0; //counter to count number of failed inputs
		int contactNo=0;
		while(counter<3) //number of failed inputs to max out at 3
		{
			System.out.println("What is the customer's contact number?");
			try {contactNo = sc.nextInt(); //exception handling
			sc.nextLine();}
			catch(InputMismatchException ex)
			{
				if(counter<2)
				{
					System.out.println("Incorrect Entry.Please Try Again..");
					System.out.println("");
				}
				sc.next();
				++counter;
				continue;
			}
				counter = 0;
				if(counter == 0) {break;}
		}
		if(counter==3) 
		{
			System.out.println("Incorrect Entry. Return to main program.."); 
			return;
		}
		
		for(int i=0; i<memberArray.size(); i++){
			if(memberArray.get(i).getContact()==contactNo){
					System.out.println("Contact number already registered. Member ID is " + memberArray.get(i).getMemberId());
					return;
			}
		}
		
		int memberId = memberArray.size() + 1001; //memberID to start from 1001
		Member newMember =new Member(name,contactNo,memberId);
		memberArray.add(newMember);
		System.out.println("Registration successful. The Member ID is: " + memberId);
	}
	
	public int getSize() {return memberArray.size();}
	
//	void removeMember(int memberId) {
//		memberArray.remove(memberId-1);
//	}
//
//	public int checkMember(int memberId, int contact) {
//		int index = memberId - 1001;
//		if((memberArray.get(index).getMemberId() == memberId) && (memberArray.get(index).getContact()==contact)) //to check if inputs match records
//			return 1;
//		else return 0;yes
//	}
	
	public void getMember(int memberId) {
		int index = memberId - 1001;
		memberArray.get(index);
		System.out.println("Member found.");
		System.out.println("Member ID: " + memberArray.get(index).getMemberId());
		System.out.println("Name: " + memberArray.get(index).getName());
		System.out.println("Contact Number: " + memberArray.get(index).getContact());
	}
}
