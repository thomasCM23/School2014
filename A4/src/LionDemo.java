/*Justin Yip #7032870
 *Thomas Chapados Muermans #6775179
 *Assignment 4
 *Roman Lion Feeding
 */
import java.util.InputMismatchException;
import java.util.Scanner;


public class LionDemo {
	//Main start 
	public static void main(String[] args){
		LionList feed = new LionList();
		LionList.LionIterator lI = feed.iterator();
		
		Scanner keyB = new Scanner(System.in);
		System.out.println("Enter the number of gladiators: ");
		try{
			int numGlad = keyB.nextInt();  
			while(numGlad<1){		//checks if value of numGlad is greater than 1
				System.out.println("You must enter an integer larger than 0.");
				numGlad = keyB.nextInt();
			}
			//Add elements to list
			for(int i=0;i<numGlad; i++){
				System.out.println("Enter the name of gladiator "+(i+1)+" :");
				String gladName = keyB.next();
				feed.addToStart(gladName); 
			}
		}catch(InputMismatchException e){
			System.err.println("You must enter an integer.");
			System.exit(0);
		}
	
		System.out.println("Size of list:"+ feed.size());
		System.out.println("Element of list are");
		feed.outputList();
		System.out.println("End of list\n");
		
		lI.restart(); 	//start list at beginning of list
		lI.next();
		while(feed.size()>1){
		lI.deleteThird(); //will do deleteThird method
		}
		lI.deleteThird();
	}
}
