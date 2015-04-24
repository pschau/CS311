import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Anagram {
	//array of 26 prime numbers for a-z
	private static int[] PRIMES = new int[] {
	    5, 71, 41, 29, 2, 47, 61, 23, 11, 97, 79, 31, 43, 13, 7, 67, 89, 19, 17, 3, 37, 73, 59, 83, 53,
	    101};
	
	//returns unique prime key number
	public static int getKey(String s) {
        int p = 1;
        for(char c : s.toCharArray()) {
        	//uses ASCII value to compute what prime number a letter is 
          p *= PRIMES[c - 'a'];
        }
        return p;
      }

	public static void main(String[] args) {
		//timer for program duration
		long startTime = System.currentTimeMillis();
		Hashmap map = new Hashmap();
		String file = "dict2.txt";
		try {
			//passes file in to be read
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String str;
	        while((str = in.readLine()) != null)
	        {
	        	//creates key for given word and places into hashmap
	        	int key = getKey(str);
	            map.put(key, str);
	        }
	        in.close();
	        
	        map.printHash(file);
		}
		catch(IOException e)
		{
			System.out.println("IO Error!");
			return;
		}
		long endTime   = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
	}

}
