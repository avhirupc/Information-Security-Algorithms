import java.io.*;
import java.math.BigInteger;
import java.util.*;
class RSAnew
{
	public static void main(String args[]) throws IOException
	{
		Random rng=new Random();
		BigInteger p;
		p=BigInteger.probablePrime(32,rng);
		BigInteger q;
		q=BigInteger.probablePrime(32,rng);
		System.out.println("First prime number ::"+p);
		System.out.println("Second prime number::"+q);
		BigInteger z=new BigInteger("1");
		BigInteger n=p.multiply(q);
		BigInteger v=(p.subtract(z)).multiply(q.subtract(z));//p-1 q-1
		BigInteger k=BigInteger.probablePrime(32,rng);//e
		BigInteger d=k.modInverse(v);//v=Q(n) 
		System.out.println("\nEncryption KEY : " + k);
		System.out.println("\nDecryption Key : " + d);
		System.out.print("\nEnter Plain Text:: ");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Long nu=new Long(Long.parseLong(br.readLine()));
		String num=nu.toString();
		BigInteger m = new BigInteger(num);
		System.out.println("\nEncrypted : "+m.modPow(k, n));
		BigInteger l=m.modPow(k, n);
		System.out.println("\nDecrypted : "+l.modPow(d, n));
	}
}