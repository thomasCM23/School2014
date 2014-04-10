/*Justin Yip #7032870
 *Thomas Chapados Muermans #6775179
 *Assignment 4, Winter 2014
 *Graphical User Interface, encrypt/decrypt text
 */
public class Decrypt {
	private String encrypted;
	private char[] ascii;
	private int size;
	
	//Decrypt input text depending on rotNum
	public String rot(int rotNum, String read){
		read.toLowerCase();
		ascii = read.toCharArray();
		System.out.println(ascii.length);
		for(int i=0; i< ascii.length; i++){
			int dAscii = ascii[i];
			if(dAscii>= 32 && dAscii <= 64 || dAscii >= 91 && dAscii <= 96 || dAscii >= 123 && dAscii <= 127 ){
				ascii[i]= ascii[i];
			}
			else if(dAscii-rotNum < 97){
				dAscii = dAscii-rotNum + 122 -96;
				ascii[i] =(char)(dAscii);
			}
			else{
				ascii[i] = (char)(ascii[i]-rotNum);
			}
		}
		encrypted = new String(ascii);
		return encrypted;
		
	}
	

}
