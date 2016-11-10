import java.util.*;

public class ChineseRemainderTheorem {
	public static void main(String[] args) {
		int cnt = 0;
		long M = 1;
		long res = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of inputs:");
		cnt  = sc.nextInt();
		long n[] = new long[cnt];
		long a[] = new long[cnt];
		long m[] = new long[cnt];
		long y[] = new long[cnt];
		
		for(int i=0;i<cnt;i++){
			System.out.println("Enter values of a["+i+"] & n["+i+"] :");
			a[i] = sc.nextLong();
			n[i] = sc.nextLong();
			M *= n[i];
		}	
		
		for(int i=0;i<cnt;i++){
			m[i] = M / n[i];
			long tmp =   m[i]%n[i];
			long y1 = 1;
			if(tmp!=1){
				long fact =(long) Math.ceil( n[i]/tmp);
				tmp = tmp*fact;
				y1 = fact;
				
			}
			while(true){
				if((tmp%n[i])==1)
					break;
				y1++;
				tmp = m[i] * y1;
			}
			y[i] = y1;
			res += a[i]*m[i]*y[i]; 
		}
		
		System.out.println("Result :"+ res%M);
		sc.close();
		
	}
}
