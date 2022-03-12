/**
 * ArrayDictionary.java
 * Kevin Lou
 * 2022/03/07
 * A HashTable implementation with String keys and String values
 */

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    /**
     * Utility class that stores key, value pair
     */
    public class Entry{
        private String key, value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    List<Entry>[] table;
    int capacity;

    /**
     * constructor
     */
    public HashTable(int capacity){
        this.capacity = capacity;
        table = new ArrayList[capacity];
        for(int i = 0; i < capacity; i++){
            table[i] = new ArrayList<>();
        }
    }

    /**
     * Puts pair into hash table. Returns false if key already exists.
     */
    public boolean put(String key, String value){
        for(Entry e : table[hashCode(key)]){
            if(e.getKey().equals(key)) return false;
        }
        table[hashCode(key)].add(new Entry(key, value));
        return true;
    }

    /**
     * Gets the value associated with the key. Returns null if key is not added
     */
    public String get(String key){
        for(Entry e : table[hashCode(key)]){
            if(e.getKey().equals(key)) return e.getValue();
        }
        return null;
    }

    /**
     * Hash function. Uses polynomial rolling hash with mod.
     */
    private int hashCode(String key){
        int mult = 1;
        int val = 0;
        for(int i = key.length()-1; i>=0; i--){
            mult*=31;
            mult%=capacity;
            val += mult*(int)key.charAt(i);
            val%=capacity;
        }
        return val;
    }

}
