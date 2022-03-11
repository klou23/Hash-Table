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

}
