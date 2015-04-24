import java.io.FileNotFoundException;
import java.io.PrintWriter;



public class Hashmap {
    private static final int SIZE = 243094217;
    private Entry table[] = new Entry[SIZE];
    //simple entry node for hash map with key and arraylist value
    class Entry {
        final int key;
        ArrayList<String> value;
        Entry(int k, ArrayList<String> v) {
            key = k;
            value = v;
        }
 
        public ArrayList<String> getValue() {
            return value;
        }
 
        public void setValue(ArrayList<String> value) {
            this.value = value;
        }
 
        public int getKey() {
            return key;
        }
    }
 
    /**
     * Returns entry associated with the specified key
     * Returns null if there is no mapping for key
     */
    public Entry get(int k) {
    	k = k % SIZE;
    	k = Math.abs(k);
        Entry e = table[k];
        if(e!=null)
        	return e;
        return null;
    }
    
 
    /**
     * Associates the specified value with the specified key in this map.
     * adds word to entry if has same associated key
     */
    public void put(int k, String word) {
    	k = k % SIZE;
    	k = Math.abs(k);
        Entry e = table[k];
        if(e != null) {
        	//adds word to entry list if same key
            if(e.key ==(k)) 
                e.value.add(word);
            else
            	System.out.println("Collision" +e.key);
        } else {
            // new entry if null
            Entry newEntry = new Entry(k, new ArrayList<String>());
            newEntry.value.add(word);
            table[k] = newEntry;
        }
    }
    
    //prints out anagram classes
    public void printHash(String a){
    	PrintWriter writer;
    	//Initialize anagram class counter
    	int numAna = 0;
		try {
			//saves to a file appended with -result.txt
			writer = new PrintWriter(a + "-result.txt");
			ArrayList<String> pList = new ArrayList<String>();
			//for all non empty buckets print out the anagrams
			for(int i = 0;i<SIZE;i++){
		        if(table[i]!=null){
		        	numAna++;
		        	pList = table[i].value;
		        	//print out anagrams in an anagram class
		        	for(int j = 0; j<pList.size();j++){
		        		if(pList.get(j)!=null){
		        			writer.print(pList.get(j) + " ");
		        		}
		        	}
			        writer.println();
		        }
		        
	    	}
	    	writer.close();
	    //prints out number of anagram classes
	    System.out.println(a +": "+numAna);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
    }
}
