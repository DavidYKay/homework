package edu.mccc.cos210.hash;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import com.cbthinkx.util.Debug;
public class HashTest {
	//private static boolean VERBOSE = true;
	private static boolean VERBOSE = false;
	private static DecimalFormat df = new DecimalFormat("#,##0");
    private int hashCodeCollisions;
    private int compressedHashCodeCollisions ;
    private HashSet<Integer> hashCodes;
    private HashSet<Integer> indexes;

    private static int BIG_N;
    private static int BIG_P;
    private static int BIG_A;
    private static int BIG_B;
	public HashTest() {
		Debug.println("HashTest.HashTest");
        hashCodes = new HashSet<Integer>();
        indexes   = new HashSet<Integer>();
	}
	public static void main(String[] sa) throws Exception {
		long startTime = System.nanoTime();
		Debug.println("HashTest.main");
		if (sa.length > 0) {
			//VERBOSE = true;
            BIG_N = Integer.parseInt(sa[0]);
            BIG_P = Integer.parseInt(sa[1]);
            BIG_A = Integer.parseInt(sa[2]);
            BIG_B = Integer.parseInt(sa[3]);
		}
		//System.out.println(
        //    String.format(
        //        "Params: %d %d %d %d",
        //        BIG_N,
        //        BIG_P,
        //        BIG_A,
        //        BIG_B
        //    )
        //);
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
            
            boolean newCode = hashCodes.add(hashCode);
            if (!newCode) {
                hashCodeCollisions++;
            }

			int index = compressHashCode(hashCode);
            boolean newIndex = indexes.add(index);
            if (!newIndex) {
                compressedHashCodeCollisions++;
            }

			verbose(Integer.toHexString(index));
			verbose_nl();
		}
		displayHashCodeCollisionCount();
		displayCompressedHashCodeCollisionCount();
	}
	private static boolean ghcFirst = true;
	public int generateHashCode(String word) {

		// Create Polynomial HashCode

		int a = 37; // base

		if (ghcFirst) {
			System.out.println();
			System.out.println("<Generate HashCode>");
			System.out.println("         a:" + rightJustify(a, 17));
			ghcFirst = false;
		}
        int hashCode = 0; 

        //ik ==  (x0 * am) + (x1 * am-1) + (x2 * am-2) + ... + (xm-1) * a  +  xm
        int pow = a;
        char[] letters = word.toCharArray();
        for (int i = letters.length - 1; i >= 0; i--) {
            int num = letters[i] * pow;
            //System.out.println("HashNum: " + num);
            hashCode += num;
            pow *= a;
        }

        //hashCode = word.hashCode();

		return hashCode;
	}
	private static boolean chcFirst = true;
	public int compressHashCode(int hashCode) {

        //p and n are prime
        //p > N
        //a,b < p
        //a,b are between 0[..p-1]
        //a != 0

		//int N = array.length; // prime. capacity?
		//int N = 79;
		//int p = 83; // prime.
		//int a = 37; // multiplication constant, 'make room'. 
        //           // a < p, a != 0, [0..p-1] 
		//int b = 17; // shift
                   // b < p, [0..p-1] 

		int N = HashTest.BIG_N;
		int p = HashTest.BIG_P;
		int a = HashTest.BIG_A;
		int b = HashTest.BIG_B;

		//int N = 7907;
		//int p = 7919;
		//int a = 107;
		//int b = 149;

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

        //From book:
        //((hashcode * scale + shift) % prime) % capacity

        int index = Math.abs((((hashCode * a) + b) % p) % N);
		return index;
	}
	public void displayHashCodeCollisionCount() {
		Debug.println("HashTest.displayHashCodeCollisionCount");
		System.out.println("HashCode Collisions");

		// your code goes here
		System.out.println(hashCodeCollisions);
	}
	public void displayCompressedHashCodeCollisionCount() {
		Debug.println("HashTest.displayCompressedHashCodeCollisionCount");
		System.out.println("Compression Collisions");

		// your code goes here
		System.out.println(compressedHashCodeCollisions);
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
