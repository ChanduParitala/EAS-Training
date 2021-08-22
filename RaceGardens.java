package EAS.java.handson;

/*
 * @Author: Chandan P
 * @Doc_String: implementation of RaceGardens case study from EAS handson.
 * Thanks for visiting!
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Random;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

class Person{
	String name, location, mailId;
	//no specific schedule for allowance of precise dates, so, customers can book on anyday.
	//Room number is system generated.
	LocalDate startDay, endDay;
	List<String> bookings = new ArrayList<String>();
	public Person() {};
	public Person(String name, String location, String mailId) {
		super();
		this.name = name;
		this.location = location;
	}
}

class Room{
	final String hotelName = "Sars Hotel";
	int roomNo, noOfPeople;
	double pay, bill=0;
	static ArrayList<Person> pList = new ArrayList<>();
	Person pObj = new Person();
	public Room(int roomNo, double pay, Person pObj, int noOfPeople, int days) {
		super();
		this.roomNo = roomNo;
		this.pay = pay;
		this.noOfPeople=noOfPeople;
		for(Person p : pList)
		{
			if(p.name.equalsIgnoreCase(pObj.name))
			{
				//because we don't have a database background, no data is stored after the app is terminated.
				pObj.startDay = LocalDate.now();
				pObj.endDay = LocalDate.now().plusDays(days);
				pObj.bookings.add("\n"+this.hotelName+", Room No.,"+this.roomNo+" on, "+LocalDate.now());
				p = pObj;
			}
		}
	}
	public Room(Person pObj)
	{
		this.pObj=pObj;
	}
}

class GuestRoom extends Room{

	//no specific schedule for allowance of precise dates, so, customers can book on anyday.
	//Room number is system generated.
	public LocalDate checkIn, checkOut;
	static ArrayList<Person> gpList = new ArrayList<>();
	Person pObj = new Person();
	
	public GuestRoom(int roomNo, double pay, Person pObj, int noOfPeople, int days, LocalDate checkIn, LocalDate checkOut) {
		super(roomNo, pay, pObj, noOfPeople, days);
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		
		for(Person p : gpList)
		{
			if(p.name.equalsIgnoreCase(pObj.name))
			{
				//because we don't have a database background, no data is stored after the app is terminated.
				pObj.startDay = LocalDate.now();
				pObj.endDay = LocalDate.now().plusDays(days);
				pObj.bookings.add("\n"+this.hotelName+", Room No.,"+this.roomNo+" on, "+LocalDate.now());
				p = pObj;
			}
		}
	}

	public GuestRoom(Person pObj)
	{
		super(pObj);
	}
}

class PartyHall extends GuestRoom{

	//no specific schedule for allowance of precise dates, so, customers can book on anyday.
	//Room number is system generated.
	public PartyHall(int roomNo, double pay, Person pObj, int noOfPeople, int days, LocalDate checkIn, LocalDate checkOut) {
		super(roomNo, pay, pObj, noOfPeople, days, checkIn, checkIn);
		
		for(Person p : GuestRoom.gpList)
		{
			if(p.name.equalsIgnoreCase(pObj.name))
			{
				//because we don't have a database background, no data is stored after the app is terminated.
				pObj.startDay = LocalDate.now();
				pObj.endDay = LocalDate.now().plusDays(days);
				pObj.bookings.add("\n"+this.hotelName+", Room No.,"+this.roomNo+" on, "+LocalDate.now());
				p = pObj;
			}
		}
	}
	
	public PartyHall(Person pObj)
	{
		super(pObj);
	}
}

class ConferenceHall extends GuestRoom{

	//no specific schedule for allowance of precise dates, so, customers can book on anyday.
	//Room number is system generated.
	public ConferenceHall(int roomNo, double pay, Person pObj, int noOfPeople, int days, LocalDate checkIn, LocalDate checkOut) {
		super(roomNo, pay, pObj, noOfPeople, days, checkIn, checkIn);
		
		for(Person p : GuestRoom.gpList)
		{
			if(p.name.equalsIgnoreCase(pObj.name))
			{
				//because we don't have a database background, no data is stored after the app is terminated.
				pObj.startDay = LocalDate.now();
				pObj.endDay = LocalDate.now().plusDays(days);
				pObj.bookings.add("\n"+this.hotelName+", Room No.,"+this.roomNo+" on, "+LocalDate.now());
				p = pObj;
			}
		}
	}
	
	public ConferenceHall(Person pObj)
	{
		super(pObj);
	}
}

class RaceGardensException extends Exception{
	public RaceGardensException(String msg)
	{
		super(msg);
	}
}

public class RaceGardens {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean flag=false;
		String y="";
		int choice=-1;
		System.out.println("Welcome to Race Gardens!");
		do {
			System.out.println("1. Register – registers a customer\r\n"+
								"2. Book – Book a room\r\n"+
								"3. Check Status – check for the rooms present status (Vacant / Booked)\r\n"+
								"4. Email – Change/ update an email address of the customer\r\n"+
								"5. All Bookings – Display all the bookings for a specific time period mentioned\r\n"+
								"6. All customers – Display all the registered customer details\r\n"+
								"7. Quit – Exit the program\r\n"
								);
			choice=in.nextInt();
			
			switch (choice) {
			case 1:
			{
				register();
				break;
			}
			case 2:
			{
				bookRoom();
				break;
			}
			case 3:
			{
				checkStatus();
				break;
			}
			case 4:
			{
				updateEmail();
				break;
			}
			case 5:
			{
				displayAllBooking();
				break;
			}
			case 6:
			{
				displayAllCustomers();
				break;
			}
			case 7:
			{
				System.out.println("Service ended thanks!..");
				flag=false;
				break;
			}

			default:
			{
				System.out.println("Invalid Input Try again");
				break;
			}
			}

			
			System.out.println("continue? y/n:\n");
			y=in.next();
		}while(y.equalsIgnoreCase("y"));
		
}

	private static void displayAllCustomers() {
		System.out.println("Enter your name: ");
		String name=in.next();
		Person pObj = new Person();
		boolean flag=false;
		ArrayList<Person> tempList = Room.pList;
		for(Person p: tempList)
		{
			if(p.name.equalsIgnoreCase(name))
			{
				pObj = p;
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Register to proceed");
			return;
		}
		Room rObj = new Room(pObj);
		LocalDate day=LocalDate.now();
		if(pObj.startDay == null)
		{
			System.out.println("Book a room to proceed");
			return;
		}
		System.out.println("Hey Mr."+name+" Here are the details of customers: ");
		Period maxDuration = Period.between(pObj.endDay, pObj.startDay);
		long maxDiff= maxDuration.getDays();
		for(Person i : rObj.pList)
		{
			System.out.println("Name: "+i.name+" location: "+i.location+" day of booking room, "+i.startDay+" for "+maxDiff+" days");
		}
		
	}

	private static void displayAllBooking() {
		System.out.println("Enter your name: ");
		String name=in.next();
		Person pObj = new Person();
		boolean flag=false;
		ArrayList<Person> tempList = Room.pList;
		for(Person p: tempList)
		{
			if(p.name.equalsIgnoreCase(name))
			{
				pObj = p;
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Register to proceed");
			return;
		}
		Room rObj = new Room(pObj);
		LocalDate day=LocalDate.now();
		if(pObj.startDay == null)
		{
			System.out.println("Book a room to proceed");
			return;
		}
		System.out.println("Enter the date from which you want see details of bookings: ");
		String date = in.next();
		LocalDate d = LocalDate.parse(date);
		System.out.println("Hey Mr."+name+" Your all Previous bookings: ");
		
		for(String i: pObj.bookings)
		{
			if(pObj.startDay.isAfter(d))
			System.out.println(i);
		}
		return;
	}

	private static void updateEmail() {
		System.out.println("Enter your name: ");
		String name=in.next();
		Person pObj = new Person();
		boolean flag=false;
		ArrayList<Person> tempList = Room.pList;
		for(Person p: tempList)
		{
			if(p.name.equalsIgnoreCase(name))
			{
				pObj = p;
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Register to change mailID");
			return;
		}
		System.out.println("Enter your previous mail to check you are the user: ");
		String exMail = in.next();
		if(!exMail.equals(pObj.mailId))
		{
			System.out.println("Wrong mail, sorry");
			return;
		}
		else {
			System.out.println("Good, Enter the new Mail Id: ");
			String mailId = in.next();
			
			pObj.mailId = mailId;
			System.out.println("Hey Mr."+pObj.name+" your mail id is: "+pObj.mailId);
			return;
		}
	}

	private static void checkStatus() {
		System.out.println("Enter your name: ");
		String name=in.next();
		Person pObj = new Person();
		boolean flag=false;
		ArrayList<Person> tempList = Room.pList;
		for(Person p: tempList)
		{
			if(p.name.equalsIgnoreCase(name))
			{
				pObj = p;
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Register to proceed");
			return;
		}
		Room rObj = new Room(pObj);
		LocalDate day=LocalDate.now();
		if(pObj.startDay == null)
		{
			System.out.println("Book a room to proceed");
			return;
		}
		Period duration = Period.between(day, pObj.startDay);
		long diff= duration.getDays();
		rObj.bill = diff*rObj.pay;
		System.out.println("Hey, Mr."+name+" You have been Allocated the room, "+rObj.roomNo+" till "+LocalDate.now()+" Your bill is: "+rObj.bill);
		Period maxDuration = Period.between(pObj.endDay, pObj.startDay);
		long maxDiff= maxDuration.getDays();
		System.out.println("Your check out date is: "+pObj.endDay+" with maximum bill "+ maxDiff*rObj.pay);
		return;
	}

	private static void bookRoom() {
		int roomNo;
		Random rand = new Random();
		roomNo = rand.nextInt(100);
		String hotelName;
		double pay;
		boolean flag=false;
		System.out.println("Enter your name: ");
		String name = in.next();
		ArrayList<Person> tempList = Room.pList;
		Person pObj = new Person();
		for(Person p: tempList)
		{
			if(p.name.equalsIgnoreCase(name))
			{
				pObj = p;
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("Register to book a room");
			return;
		}
		System.out.println("Hey, "+name+" please select either GuestRoom or HotelRoom, G/H?");
		String choice = in.next();
		if(choice.equals("H"))
		System.out.println("Select AC/ Non-AC? \t AC: Rs.1000 and Non-AC: Rs.750");
		else
		{
			System.out.println("Your reservation neccesity is occasional-booking or stay-booking O/S? ");
			String OS = in.next();
			if(OS.equals("O"))
				System.out.println("Select Party Hall/ Conference Hall? \t Party_Hall: Rs.12500 , Conference_Hall: Rs.15000");
			else
			System.out.println("Select AC/ Non-AC/ Deluxe ? \t AC: Rs.1000 , Non-AC: Rs.750 , Deluxe: Rs.1500");
		}
		String temp=in.next();
		if(temp.equalsIgnoreCase("AC"))
			pay=1000.0d;
		else if(temp.equalsIgnoreCase("Non-AC"))
			pay=750.0d;
		else if(temp.equalsIgnoreCase("Deluxe"))
			pay=1500.0d;
		else if(temp.equalsIgnoreCase("Party_Hall"))
			{
				pay=12500.0d;
				GuestRoom gObj = new PartyHall(roomNo, pay, pObj, 200, 1, LocalDate.now(), LocalDate.now().plusDays(1));
				System.out.println("Mr."+name+" "+"Room booked, "+gObj.roomNo+" in "+gObj.hotelName+" on, "+gObj.checkIn+" for Ocassional Celebration with max. 200 "+gObj.noOfPeople+" members.");
				System.out.println("Your reservation ends on, "+gObj.checkOut);
				return;
			}
		else
		{
			pay=15000.0d;
			GuestRoom gObj = new ConferenceHall(roomNo, pay, pObj, 20, 1, LocalDate.now(), LocalDate.now().plusDays(1));
			System.out.println("Mr."+name+" "+"Room booked, "+gObj.roomNo+" in "+gObj.hotelName+" on, "+gObj.checkIn+" for Conference with max. 20  "+gObj.noOfPeople+" members.");
			System.out.println("Your reservation ends on, "+gObj.checkOut);
			return;
		}		
		System.out.println("Enter Number of people residing: ");
		int noOfPeople;
		do {
			noOfPeople=in.nextInt();
			try {
				//not checking for integer as implicitly, we have InputMismatchException coming.
				if(noOfPeople<=0) throw new RaceGardensException("Enter a Valid number of people residing!!, try again");
				else 
				{
					flag=false;
					System.out.println("Good\n");
				}
			}
			catch(RaceGardensException e){
				e.printStackTrace();
				flag=true;
			}
			catch(Exception e) {
				e.printStackTrace();
				flag=true;
			}
		}while(flag);
		System.out.println("Enter days to reside: ");
		int days = in.nextInt();
		
		if(choice.equals("H"))
		{
			Room roomObj =  new Room(roomNo, pay,pObj,noOfPeople,days);
			System.out.println("Mr."+name+" "+"Room booked, "+roomObj.roomNo+" in "+roomObj.hotelName+" on, "+pObj.startDay+" residing "+roomObj.noOfPeople+" members.");
			System.out.println("Your reservation ends on, "+pObj.endDay);
			return;
		}
		else
		{
			GuestRoom gObj = new GuestRoom(roomNo, pay, pObj, noOfPeople, days, LocalDate.now(), LocalDate.now().plusDays(days));
			System.out.println("Mr."+name+" "+"Room booked, "+gObj.roomNo+" in "+gObj.hotelName+" on, "+gObj.checkIn+" residing "+gObj.noOfPeople+" members.");
			System.out.println("Your reservation ends on, "+gObj.checkOut);
			return;
		}
		
	}
		

	private static void register() {
		String name, location, mailId;
		boolean flag = false;
		System.out.println("Enter your name: ");
		name=in.next();
		System.out.println("Enter your email: ");
		do {
			mailId=in.next();
			try {
				String regexp = "^(.+)@(.+)$";
				Pattern pattern = Pattern.compile(regexp);
				Matcher match = pattern.matcher(mailId);
				if(!match.matches()) throw new RaceGardensException("Enter a Valid e-Mail Id please!!, try again");
				else 
				{
					flag=false;
					System.out.println("Good\n");
				}
			}
			catch(RaceGardensException e){
				e.printStackTrace();
				flag=true;
			}
			catch(Exception e) {
				e.printStackTrace();
				flag=true;
			}
		}while(flag);
		System.out.println("Enter your location: ");
		location=in.next();
		
		Person pObj = new Person(name, location, mailId);
		Room.pList.add(pObj);
		GuestRoom.gpList.add(pObj);
		System.out.println("Registered! ");
		return;
	}
}
