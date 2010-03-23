package edu.mccc.cos210.hash;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import com.cbthinkx.util.Debug;
public class HashTest {
	//private static boolean VERBOSE = true;
	private static boolean VERBOSE = false;
	private static DecimalFormat df = new DecimalFormat("#,##0");
	public HashTest() {
		Debug.println("HashTest.HashTest");
	}
	public static void main(String[] sa) throws Exception {
		long startTime = System.nanoTime();
		Debug.println("HashTest.main");
		if (sa.length > 0) {
			VERBOSE = true;
		}
		HashTest ht = new HashTest();
		ht.hashIt();
		System.out.println("Elapsed Time: " + ht.rightJustify(System.nanoTime() - startTime, 14) + " nS");
	}
	private void hashIt() throws Exception {
		Debug.println("HashTest.hashIt");
		Iterable<String> is = loadWords();
		for (String s : is) {
			verbose(s);
			int hashCode = generateHashCode(s);
			verbose(Integer.toHexString(hashCode));
			int index = compressHashCode(hashCode);
			verbose(Integer.toHexString(index));
			verbose_nl();
		}
		displayHashCodeCollisionCount();
		displayCompressedHashCodeCollisionCount();
	}
	private static boolean ghcFirst = true;
	public int generateHashCode(String word) {

		// Create Polynomial HashCode

		int a = 0; // you pick

		if (ghcFirst) {
			System.out.println();
			System.out.println("<Generate HashCode>");
			System.out.println("         a:" + rightJustify(a, 17));
			ghcFirst = false;
		}

		// your code goes here
        int hashCode = word.hashCode();

		return hashCode;
	}
	private static boolean chcFirst = true;
	public int compressHashCode(int hashCode) {

		// MAD Method

		//int N = array.length; // prime. capacity?
		int N = 79;
		int p = 83; // prime.
		int a = 2; // multiplication constant, 'make room'. 
                   // a < p, a != 0, [0..p-1] 
		int b = 0; // shift
                   // b < p, [0..p-1] 

		if (chcFirst) {
			System.out.println();
			System.out.println("<Compress HashCode>");
			System.out.println("         N:" + rightJustify(N, 17));
			System.out.println("         p:" + rightJustify(p, 17));
			System.out.println("         a:" + rightJustify(a, 17));
			System.out.println("         b:" + rightJustify(b, 17));
			System.out.println();
			chcFirst = false;
		}

        //from forum:
        //(a*hashcode + b) mod p mod N
        //p and n are prime
        //p > N
        //a,b < p
        //a,b are between 0[..p-1]
        //a != 0

        //hash(key) = ( a * key + b ) % tableSize

        //From book:
        //((hashcode * scale + shift) % prime) % capacity

        //Multiply-Add-Divide
        //h(k) = |ak + b| mod N

        int index = ((a * hashCode) % p) % N;
		return index;
	}
	public void displayHashCodeCollisionCount() {
		Debug.println("HashTest.displayHashCodeCollisionCount");
		System.out.println("HashCode Collisions");

		// your code goes here

	}
	public void displayCompressedHashCodeCollisionCount() {
		Debug.println("HashTest.displayCompressedHashCodeCollisionCount");
		System.out.println("Compression Collisions");

		// your code goes here

	}
	private Iterable<String> loadWords() throws Exception {
		Debug.println("HashTest.loadWords");
		ArrayList<String> als = new ArrayList<String>();
		BufferedReader br = new BufferedReader(
			new FileReader("pocket.dic")
		);
		int count = 0;
		int minLength = Integer.MAX_VALUE;
		int maxLength = 0;
		String s;
		while ((s = br.readLine()) != null) {
			als.add(s);
			int length = s.length();
			minLength = length < minLength ? length : minLength;
			maxLength = length > maxLength ? length : maxLength;
			count++;
		}
		System.out.println("Word Count: " + rightJustify(count, 16));
		System.out.println("Min Length: " + rightJustify(minLength, 16));
		System.out.println("Max Length: " + rightJustify(maxLength, 16));
		return als;
	}
	private String rightJustify(long n, int w) {
		String dfs = df.format(n);
		int len = dfs.length();
		StringBuilder sb = new StringBuilder();
		if (len <= w) {
			for (int i = len; i < w; i++) {
				sb.append(" ");
			}
		}
		sb.append(dfs);
		return sb.toString();
	}
	private void verbose(String s) {
		if (VERBOSE) {
			System.out.print(s + " ");
		}
	}
	private void verbose_nl() {
		if (VERBOSE) {
			System.out.println();
		}
	}
}
