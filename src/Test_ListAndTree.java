import java.util.Scanner;

public class Test_ListAndTree {

	public static void main(String[] args) {
		
		List data = new List();
		Tree tree = new Tree();
		
		Scanner input = new Scanner(System.in);
		
		int choice;
		
		do{
			choice = data.menu();
			switch(choice){
				
				case 0: 
					System.out.println("Are you sure you want to log out?\n" 
						+
						"If you are sure, press zero.\n"
						+"To return to the menu press any key other than 0.\n"
						+
						"Enter your selection:");
					choice = input.nextInt();
					if(choice == 0){ // The condition is achieved "while loop" will be broken.
						System.out.println("\nCheck-out was performed."
								+	"\n\nHave a nice day");
								}//for if
					break;
					
				case 1:
					System.out.println("Enter the student number:");
					int number = input.nextInt();
					System.out.println("Enter the student name:");
					String name = input.next();
					System.out.println("Enter the student surname");
					String surname = input.next();
					data.add(number, name, surname);
					student_tree st = new student_tree(number, name, surname);
					tree.add_tree(st);
					break;
						
				case 2:
					System.out.println("Please enter the student number to be deleted:");
					int delete_no = input.nextInt();
					data.delete(delete_no);
					tree.delete_tree(delete_no);
					break;
					
				case 3: System.out.println("Please enter the student number:");
						number = input.nextInt();
						System.out.println("Search to list");
						data.find(number);
						System.out.println("Search to tree");
						tree.find_tree(number);
						break;
						
				case 4:
					int temp;
					do{
						System.out.println("What would you like to search the data?\n"
											+ "Press 1 for only list.\n"
											+ "Press 2 for only tree.\n"
											+ "Press 3 both  list and  trees");
						temp = input.nextInt();
						if(temp==1){
							System.out.println("Students List");
							System.out.println("No"+" "+"Name"+" "+"Surname");
							data.list_all_students();
							}
								else if(temp==2){
									System.out.println("\nBinary Search Tree");
									tree.traversal();
									}
								else if(temp==3){
									System.out.println("Students List");
									System.out.println("No"+" "+"Name"+" "+"Surname");
									data.list_all_students();
									System.out.println("\nBinary Search Tree");
									tree.traversal();
								}
										else{
											System.out.println("Please select one of two options!");
										}
								
					}while(temp != 1 && temp != 2 && temp != 3);
					break;
					
				case 5:
					System.out.println("Different names");
					data.list_distinct_names();
					break;
					
				case 6:
					data.distinct_name_count();
					break;
					
				case 7:
					data.author();
					break;
					
				default:
					System.out.println("Entered figure does not represent any property!\n");
					break;
					
			}
		}while(choice != 0 );
	}
}
