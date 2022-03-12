/**
 * Test.java
 * Kevin Lou
 * 2022/03/07
 * Methods for testing HashTable and hash function
 */

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        testHashTable();
        System.out.println("---------------");
        testHash();
    }

    /**
     * Tests the HashTable data structure. Should print:
     *
     * put ["key1", "value1"]: true
     * put ["key2", "value2"]: true
     * put ["key1", "value1"]: false
     * get "key2": value2
     * get "key3": null
     */
    public static void testHashTable(){
        HashTable h = new HashTable(10);
        System.out.printf("put [\"key1\", \"value1\"]: %b\n", h.put("key1", "value1"));
        System.out.printf("put [\"key2\", \"value2\"]: %b\n", h.put("key2", "value2"));
        System.out.printf("put [\"key1\", \"value1\"]: %b\n", h.put("key1", "value1"));
        System.out.printf("get \"key2\": %s\n", h.get("key2"));
        System.out.printf("get \"key3\": %s\n", h.get("key3"));
    }

    /**
     * Tests my hash function using 100 buckets and 200 keys.
     * All keys are randomly generated strings of length [1,20] containing characters [a,z]
     * Results will change with everytime the function is run as keys are randomly generated
     */
    public static void testHash(){
        System.out.println("Test Hash Function (100 buckets, 200 keys)");
        int[] cnts = new int[100];
        for(int i = 0; i < 200; i++){
            int len = 1 + (int)(Math.random()*20);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++){
                char c = (char) ('a' + (int)(Math.random()*26));
                sb.append(c);
            }
            cnts[hashCode(sb.toString(), 100)]++;
        }

        int min = 1<<30;
        int max = -1;
        for(int cnt : cnts){
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }
        System.out.printf("Max keys in bucket: %d\n", max);
        System.out.printf("Min keys in bucket: %d\n", min);
    }

    /**
     * String hashing function. Same as the one used in HashTable class.
     */
    public static int hashCode(String key, int max){
        int mult = 1;
        int val = 0;
        for(int i = key.length()-1; i>=0; i--){
            mult*=31;
            mult%=max;
            val += mult*(int)key.charAt(i);
            val%=max;
        }
        return val;
    }

}
