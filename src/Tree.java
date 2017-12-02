import java.util.*;
public class Tree{

	public student_tree root;
	private int hops=0;//for find() method
	
	ArrayList<String> array = new ArrayList<String>(); // for tree_distinct_name_count() method
	
	public int control(){
		if(root==null)
			return 0;
		else
			return 1;
	}
	
	public void add_tree(student_tree dataTree){
		
		if(control()==0){
			root=dataTree;
		}
		
			else{
			
				student_tree temp=root;
			
				while(true){
					
				if(temp.get_number() < dataTree.get_number()){
					if(temp.get_right()==null){
						temp.set_right(dataTree);
						break;
					}
					else
						temp=temp.get_right();
				}
					else if(temp.get_number() == dataTree.get_number()) { // No two students with the same number.
						System.out.println("Any student with that number has already been registered.\n"
										+"Two students with the same number can not be recorded.");
						break;
					}
					else{
						if(temp.get_left()==null){
							temp.set_left(dataTree);
							break;
						}
						else 
							temp=temp.get_left();
						
					}
					}//for while
				}
			}//public void add_tree
	

	public void delete_tree(int delete_no) {
		student_tree temp=root;
		delete(temp,delete_no);
	} 	
	
	public void delete(student_tree temp ,int number) 
    {
        if (temp == null) return;
        else{
        	if (temp.get_number() > number )
        		delete(temp.left , number);
        	else if (temp.get_number() < 0)
        		delete(temp.right , number);
        	else {
        		if (temp.left != null && temp.right != null)
        		{
        			
        			student_tree maxLeft = max (temp.left);
        			
        			int no=maxLeft.get_number();
        			String name=maxLeft.get_name();
        			String surname=maxLeft.get_surname();
                
        			temp.set_number(no);
        			temp.set_name(name);
        			temp.set_surname(surname);
                
        			maxLeft=null;
        		}
        		else if(temp.left == null && temp.right != null) {
        			delete(temp.right,number);
        		}
        		else if(temp.left != null && temp.right == null) {
        			delete(temp.left,number);
        		}
        		else {
        			temp = null;
        		}
        	}    
        }
    }

				private student_tree max(student_tree temp) {
					if(temp.right == null)
						return temp;
				else
					return max(temp.right);
		
				}

						
	public void find_tree(int no){
		student_tree temp=root;
		while (temp != null){
			hops++;
			if(temp.get_number() == no){
				System.out.println(temp.get_number()+" "+temp.get_name()+" "+temp.get_surname());
				System.out.println("Number found the in " + hops + "th. hops in tree:");
				break;
			}
				else if(temp.get_number()<no)
					temp=temp.get_right();	
				
					else
						temp=temp.get_left();
			}
		if(temp==null){
			System.out.println("No Records Found");
		}
		
		
	}
	
	public void traversal(){
		student_tree temp= root;
		System.out.println("number     name   surname");
		System.out.println("\nPREORDER");
		preorder(temp);
		System.out.println("\nPOSTORDER");
		postorder(temp);
		System.out.println("\nINORDER");
		inorder(temp);
		
	}

	private void preorder(student_tree temp) {
		if(temp!=null) { 
		    System.out.println(temp.get_number()+" "+temp.get_name()+" "+temp.get_surname()); 
		    preorder(temp.get_left());       
		    preorder(temp.get_right());      
		  } 
	}

	private void postorder(student_tree temp) {
		  if(temp!=null) { 
			    postorder(temp.get_left());     
			    postorder(temp.get_right());      
			    System.out.println(temp.get_number()+" "+temp.get_name()+" "+temp.get_surname());
			  }
	}

	private void inorder(student_tree temp) {
		if(temp!=null) { 
		    inorder(temp.get_left());        
		    System.out.println(temp.get_number()+" "+temp.get_name()+" "+temp.get_surname()); 
		    inorder(temp.get_right());          
		  } 
	}
	
}

	class student_tree extends students{
		
			student_tree left;
			student_tree right;
			
		public student_tree(int number, String name, String surname) {
		this.number = number;
		this.name = name;
		this.surname = surname;
	}
		public student_tree get_left() 
		{
		        return left; 
		}
		
		public void set_left(student_tree left) 
	    {
	        this.left=left; 
	    }
		
	    
		public student_tree get_right() 
		{
		        return right; 
		}
		
		public void set_right(student_tree right) 
		{
				this.right=right; 
		}
}