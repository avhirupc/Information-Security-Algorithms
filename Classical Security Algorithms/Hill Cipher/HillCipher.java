import java.util.*;
public class HillCipher {
	static String input;
	static long [][]matrix;
	static int block = 0;
	static Scanner sc = new Scanner(System.in);
	static String output = "";
	public static void main(String[] args) {
		getInput();
	}
	
	public static void getInput(){
		try {
			System.out.println("Input :");
			input = sc.nextLine();
			input = input.toUpperCase();
			System.out.println("Block Size :");
			block = sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
		}
		trimInput();
		inputMatrix();
	}
	
	public static void trimInput(){
		input = input.replaceAll(" ", "");
		
		int i = 0;
		StringBuffer sb = new StringBuffer(input);
		while(true){
			if(i>=sb.length())
				break;
			char x = sb.charAt(i);
			if(x>='A' && x<='Z'){
				i++;
				continue;
			}else{
				sb.replace(i, i+1, "");
			}
				
		}
		input = sb.toString();
		
	}
	
	public static void inputMatrix(){
		matrix = new long[block][block];
		System.out.println("Enter matrix:");
		for(int i=0;i<block;i++){
			for(int j=0;j<block;j++){
				try {
					matrix[i][j] = sc.nextLong();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		hillCipher();
	}
	
	public static void hillCipher(){
		int len = input.length();
		if(len%block!=0){
			for(int i=1;i<block;i++)
				input = input+"X";
		}
		int i=0;
		long ip[] = new long[block];
		int k=0;
		while(i<input.length()){
			
			ip[k++%block] = (int)((input.charAt(i++))-65);
			if(k%block==0)
				matrixMultiplication(ip);
		}
		System.out.println(output);
	}
	
	public static void matrixMultiplication(long[] ip){
		long sum = 0;
		for(int i=0;i<block;i++){
			sum=0;
			for(int j=0;j<block;j++){
				sum += ip[j]*matrix[j][i];
			}
			output += (char)((sum%26)+65);
		}
	}
}
