import java.math.BigInteger;
import java.util.Scanner;

public class IP {
	
	/* Saad Anjum
	 * Network Security
	 * 9/27/16
	 * 
	 * 
	 * 1) 3e89e2ee10dd259d
	 * 2) 43f4e8ca10adce57
	 * 
	 */
	
	
	
	 // Initial Permutation table
	private static final byte[] IP = { 
		58, 50, 42, 34, 26, 18, 10, 2,
		60, 52, 44, 36, 28, 20, 12, 4,
		62, 54, 46, 38, 30, 22, 14, 6,
		64, 56, 48, 40, 32, 24, 16, 8,
		57, 49, 41, 33, 25, 17, 9,  1,
		59, 51, 43, 35, 27, 19, 11, 3,
		61, 53, 45, 37, 29, 21, 13, 5,
		63, 55, 47, 39, 31, 23, 15, 7
	};
	
	private static int[] permute(int[] inputBits){
		int newBits[] = new int[inputBits.length];
		for(int i=0 ; i < inputBits.length ; i++) {
			newBits[i] = inputBits[IP[i]-1];
		}
		return newBits; 
	}
	
	private static String newHex(int[] outputBits){
		String[] newHex = new String[64];
		String newHex1 = "";
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i <outputBits.length; i++){
			sb.append(outputBits[i]);
		}
		
		newHex1 = sb.toString();
		return newHex1;
		
	}
	
	public static void main(String[] args){
		
		System.out.println("Enter the input as a 16 character hexadecimal value:");
		String input = new Scanner(System.in).nextLine();
		int inputBits[] = new int[64];
		int num;
		
		for(int i=0 ; i < 16 ; i++) {
			
			String s = Integer.toBinaryString(Integer.parseInt(input.charAt(i) + "", 16));
			
			
			while(s.length() < 4) {
				s = "0" + s;
			}
			
			for(int j=0 ; j < 4 ; j++) {
				inputBits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
		
		int outputBits[] = permute(inputBits);
		
		for(int i = 0; i < outputBits.length; i++){
			//System.out.print(outputBits[i]);
		}
		
		String newBin = newHex(outputBits);
		System.out.println(newBin);
		
		BigInteger b = new BigInteger(newBin, 2);
		System.out.println(b.toString(16));
		
	}

}
