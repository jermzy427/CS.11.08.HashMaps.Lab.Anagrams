import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AnagramSolver {

    private AnagramSolver() {};

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */
    public static HashMap<String, ArrayList<String>> anagrams(String filename) throws FileNotFoundException {
        HashMap<String, ArrayList<String>> anagrams =new HashMap<>();
        Scanner filescan = new Scanner(new File(filename));

        try(filescan){
            while(filescan.hasNext()){
                String word = filescan.next().trim();
                String sortedWord = sortWord(word);
                if(!anagrams.containsKey(sortedWord)){
                    anagrams.put(sortedWord, new ArrayList<>());
                }
                anagrams.get(sortedWord).add(word);
            }
        }

        return anagrams;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        ArrayList<String> key =  new ArrayList<>();

        for(ArrayList<String> grams : anagrams.values()){
            if(grams.size()>key.size()) {
                key = grams;
            }

        }
        return key;
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
         System.out.println(anagrams);
    }

    public static String sortWord(String word){
        char[] chars = word.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

}
