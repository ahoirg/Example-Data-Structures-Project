import java.util.*;

public class List {
	student_list head = null , tail = null;
	int counter=0;//for find()method
	
	ArrayList<String> array = new ArrayList<String>();//for list_distinct_names() method
	
	public int menu(){
		
		System.out.println("Please choose one of the options:");
		System.out.println("Press 0 to Exit");
		System.out.println("Press 1 to Add student");
		System.out.println("Press 2 to Delete student");
		System.out.println("Press 3 to Find student");
		System.out.println("Press 4 to List all students");
		System.out.println("Press 5 to List distinct names");
		System.out.println("Press 6 to List name counts");
		System.out.println("Press 7 to About");
		System.out.println("Enter your selection:");
		
		Scanner input = new Scanner(System.in);
		int temp = input.nextInt();
		return temp;	
  }
	
	public void add(int number , String name , String surname){
		
		student_list s = new student_list(number , name , surname);
		student_list temp = head;
			
		if(head ==null){
		   head = s;
		   tail = s;
		}
		   else{
			   while(temp!=null){
				   if(temp.get_number()==s.get_number()){
					   // Already written notice to the other class.
					   break;
				   }
				   temp=temp.next;
			   }
			   if(temp==null){
				   tail.next = s;
				   tail = s;
				   System.out.println("Students added to the List.");
				}
			}
	}//for add


	public void delete(int number){
		student_list temp = head , previous = head;
		if(head == null)
			System.out.println("List is empty");
		else{
			while(temp != null){
				if(temp.number == number){
					break;
				}
				previous = temp;
				temp = temp.next;
			}
			if(temp == null){
				System.out.println("The number you entered is not registered in the list.");
			}
			else{
				if(head == tail){
					head = null;
					tail = null;
			     }
					else{
						if(temp == head){
							head = temp.next;
						}
						else{
							if(temp  == tail){
								tail = previous;
								previous.next = null;
							}
								else{
									previous.next = temp.next;
									}
						}
				}
		  }
	}
	}// for public void delete
	
	public void find(int number){
		student_list temp = head;
		if(head==null)
			System.out.println("list is empty");
			else {
				while(temp!=null){
					counter++;
					if(temp.get_number() == number)
						break;
						else 
							temp=temp.next;
					
				}
				if(temp!=null){
						System.out.println(temp.get_number()+"  "+temp.get_name()+"  "+temp.get_surname());
						System.out.println("Found in hops "+ counter +"th. in List");
				}
				    else
				    	System.out.println("No student of this number.");
					
			}
		counter=0;//We clean for the next use.
	}
	
	public void list_all_students(){
		student_list temp = head ;
		while(temp != null){
			System.out.println(temp.number+" "+temp.name+" "+temp.surname);
			temp =  temp.next;
							}
	}
	
	
	public void list_distinct_names(){
		student_list temp = head;
		String name;
		while(temp != null){
			if(array.size()==0){
				array.add(temp.get_name());
				temp=temp.next;
			}
			
				else{
					name=temp.get_name(); 
					if(array.contains(name)){
						System.out.println("");
					}
						else{
							array.add(temp.get_name());
						}
					temp=temp.next;	
					
				}
		}
		
		Collections.sort(array);
		
		for(String n : array){
		    System.out.println(n);
		}
		
		array.clear();//We clean for the next use.
	}

	public void distinct_name_count(){
		student_list temp = head;
		while(temp != null){
			if(array.size()==0){
				array.add(temp.get_name());
				temp=temp.next;
			}
			else{
				array.add(temp.get_name());	
				temp=temp.next;	
					
				}
		}
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String name : array) {
			Integer count = map.get(name);
			map.put(name, (count == null) ? 1 : count + 1);
		}
		
		System.out.println("Different names and number of repeating");
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
		printMap(treeMap); // 185. line
		
		
		array.clear(); //We clean for the next use.
	}
	
	public static void printMap(Map<String, Integer> map){ 

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Name: " + entry.getKey() + ":"
				+ entry.getValue());
		}
			
	  }
	
	public void author(){
		System.out.println("Programmer\t\t Number\n"
				+"---");
	}
}

	class student_list extends students{
	
	student_list next;
	
	public student_list(int number, String name, String surname) {
		this.number = number;
		this.name = name;
		this.surname = surname;
		this.next = null;
	}
	student_list get_next(){
		return next;
	}
}

