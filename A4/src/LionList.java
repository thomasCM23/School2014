/*Justin Yip #7032870
 *Thomas Chapados Muermans #6775179
 *Assignment 4
 *Roman Lion Feeding
 */
import java.util.NoSuchElementException;


public class LionList {
	
	private static int count=0;
	
	//Node class
	private class Node1{
		
		private String item;
		private Node1 link;
		
		public Node1(){
			item = null;
			link = null;
		}
		public Node1(String newItem, Node1 linkValue){
			item = newItem;
			link = linkValue;
		}
	}
	//iterator
	public class LionIterator{
		private Node1 position;
		private Node1 previous;
		
		
		public LionIterator(){
			position = head;
			previous = null;
		}
		//Allows to restart list
		public void restart(){
			position = head;
			previous = null;
		}
		//next element in list
		public String next(){
			try{
				if(!hasNext()){
					throw new NoSuchElementException();
				}
			}catch(NoSuchElementException e){
				System.err.println("There are no more elements.");
				System.exit(0);
			}
			String toReturn = position.item;
			previous = position;
			position = position.link;
			return toReturn;
		}
		//Checks if list has next element
		public boolean hasNext(){
			return (position != null);
		}
		//Delete an element in the list
		public void delete(){
			try{
				if(position == null){
					throw new IllegalStateException();
				}
				else if(previous == null){
					head = position.link;
				}
				else{
					previous.link = position.link;
					position = position.link;
				}
			}catch(IllegalStateException e){
				System.err.println("There is no element to delete.");
				System.exit(0);
			}
		}
		//Delete every third element in the list
		public void deleteThird(){
			int sizeList = size();
			count +=3;
			while(count>sizeList){
				count = count-sizeList;
			}
			if(sizeList==1){
				System.out.print("The winner is: ");
				outputList();
				
			}else{
				int countNode = 1;
				restart();
				while(position != null){
					if(countNode == count){
						System.out.println(position.item+" is eliminated");
						delete();
						count -= 1;
						break;
					}
					next();
					countNode++;
				}
				if(size()!=1){
					
					outputList();	
					System.out.println();
				}
			}
		}
	}
	
	private Node1 head;
	//Returns LionIterator class
	public LionIterator iterator(){
		return new LionIterator();
	}
	
	public LionList(){
		head = null;
	}
	
	//add node at start of list 
	public void addToStart(String itemName){
		head = new Node1(itemName, head);
	}
	
	//returns size of list
	public int size(){
		int countSize = 0;
		Node1 position = head;
		while(position != null){
			countSize++;
			position = position.link;
		}
		return countSize;
	}
	//prints out the lists
	public void outputList(){
		Node1 position = head;
		while(position != null){
			System.out.print(position.item);
			position = position.link;
			if(position!=null)
				System.out.print(", ");
			else
				System.out.print(".\n");
		}
	}
}
