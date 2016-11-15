import java.io.*;

public class PlayfairCipher {
	static StringBuffer input = null;
	static String key = null;
	static char [][]matrix = null;
	
	public static void main(String[] args) {
		getInput();
	}
	
	public static void getInput(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("Enter input message:");
			input = new StringBuffer(br.readLine());
			System.out.println("Enter key: ");
			key = br.readLine();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cleansing();
		trimKey();
		
	}
	
	public static void cleansing(){
		String tmp = input.toString();
		tmp = tmp.replaceAll(" ", "");
		tmp = tmp.toUpperCase();
		input = new StringBuffer(tmp);
		int i=0;
		while(i<input.length()-1){
			char a = input.charAt(i);
			char b = input.charAt(i+1);
			if(a==b)
				input.insert(i+1, 'X');
			i+=2;
		}
		if(input.length()%2!=0)
			input.append('X');
		System.out.println("\nPlain input: "+input);
	}
	
	public static void trimKey(){
		key = key.toUpperCase();
		String key1 = key.replace('J', 'I');
		String finalKey = "";
		for(int j=0;j<key1.length();j++)
			if(!finalKey.contains(key1.charAt(j)+""))
				finalKey += key1.charAt(j);
		key1 = finalKey;
		System.out.println("Key: "+key);
		createMatrix(key1);
	}
	
	public static void createMatrix(String key){
		String ALPHA = "ABCDEFGHIKLMNOPQRSTUVWXYZ"; 
		matrix = new char[5][];
		for(int j=0;j<5;j++)
			matrix[j] = new char[5];
		int i=0;
		int k=0;
		for(int j=0;j<key.length();j++){
			ALPHA = ALPHA.replace(key.charAt(j)+"", "");
			matrix[i][k++] = key.charAt(j);
			if(k%5==0){
				i++;
				k = k%5;
			}	
		}	
	//	System.out.println(ALPHA);
		for(int j=0;j<ALPHA.length();j++){
			matrix[i][k++] = ALPHA.charAt(j);
			if(k%5==0){
				i++;
				k = k%5;
			}	
		}			
		displayMatrix();
		playfairCipher();
	}
	
	public static void displayMatrix(){
		System.out.println();
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void playfairCipher(){
		int i=0;
		String output = "";
		while(i<input.length()-1){
			char a = input.charAt(i);
			char b = input.charAt(i+1);
			char[] res = find(a, b);
			char r1 = res[0];
			char r2 = res[1];
			//System.out.println(a+" "+b+"  "+r1+" "+r2);
			
			output += r1+""+r2+""; 
			i+=2;
		}
		System.out.println("\nEncrypted Output : "+output);
	}
	
	public static char[] find(char a, char b){
		char[] res = new char[2];
		int x3 = -1,y3 = -1, x4 = -1, y4 = -1;
		int x1 = -1,x2 = -1,y1 = -1,y2 = -1;
		int cnt=0;
		for(int i=0;i<5;i++){
			if(cnt==2)
				break;
			for(int j=0;j<5;j++){
				if(cnt==2)
					break;
				if(matrix[i][j]==a){
					x1 = i; 
					y1 = j;
					cnt++;
				}	
				else if(matrix[i][j]==b){
					x2 = i;
					y2 = j;
					cnt++;
				}  	
			}
		}	
		//System.out.println("ip: "+x1+" "+y1+"  "+x2+" "+y2);
		if(x1==x2){
			x3 = x4 = x1;
			y3 = (y1+1)%5;
			y4 = (y2+1)%5;
		}
		else if(y1==y2){
			y3 = y4 = y1;
			x3 = (x1+1)%5;
			x4 = (x2+1)%5;
		}else{
			x3 = x1;
			y3 = y2;
			x4 = x2;
			y4 = y1;
		}
		//System.out.println("res: "+x3+" "+y3+"  "+x4+" "+y4);
		
		res[0] = matrix[x3][y3];
		res[1] = matrix[x4][y4];
		return res;
	}
}
