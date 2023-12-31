import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Your implementation of a ExternalChainingHashMap.
 *
 * @author RAUL AVILES RPDRIGUEZ
 * @version 49.3
 * @userid braviles
 * @GTID braviles
 *
 * Collaborators: LIST ALL COLLABORATORS YOU WORKED WITH HERE
 *
 * Resources: LIST ALL NON-COURSE RESOURCES YOU CONSULTED HERE
 */

 public class ExternalChainingHashMap<K, V> {

/*
* The initial capacity of the ExternalChainingHashMap when created with the
* default constructor.
*
* DO NOT MODIFY THIS VARIABLE! = 13
*/
public static final int INITIAL_CAPACITY = 7;

/*
* The max load factor of the ExternalChainingHashMap.
*
* DO NOT MODIFY THIS VARIABLE!
*/
public static final double MAX_LOAD_FACTOR = 0.67;

/*
* Do not add new instance variables or modify existing ones.
*/
private ExternalChainingMapEntry<K, V>[] table;
private int size;

/**
* Constructs a new ExternalChainingHashMap.
*
* The backing array should have an initial capacity of INITIAL_CAPACITY.
*
* Use constructor chaining.
*/
public ExternalChainingHashMap() {
    this(INITIAL_CAPACITY);
}

/**
* Constructs a new ExternalChainingHashMap.
*
* The backing array should have an initial capacity of initialCapacity.
*
* You may assume initialCapacity will always be positive.
*
* @param initialCapacity the initial capacity of the backing array
*/
@SuppressWarnings("unchecked")
public ExternalChainingHashMap(int initialCapacity) {
    table = (ExternalChainingMapEntry<K, V>[]) (new ExternalChainingMapEntry[initialCapacity]);
    size = 0;
}

/**
* Adds the given key-value pair to the map. If an entry in the map
* already has this key, replace the entry's value with the new one
* passed in.
*
* In the case of a collision, use external chaining as your resolution
* strategy. Add new entries to the front of an existing chain, but don't
* forget to check the entire chain for duplicate keys first.
*
* If you find a duplicate key, then replace the entry's value with the new
* one passed in. When replacing the old value, replace it at that position
* in the chain, not by creating a new entry and adding it to the front.
*
* Before actually adding any data to the HashMap, you should check to
* see if the array would violate the max load factor if the data was
* added. Resize if the load factor is greater than max LF (it is okay
* if the load factor is equal to max LF). For example, let's say the
* array is of length 5 and the current size is 3 (LF = 0.6). For this
* example, assume that no elements are removed in between steps. If
* another entry is attempted to be added, before doing anything else,
* you should check whether (3 + 1) / 5 = 0.8 is larger than the max LF.
* It is, so you would trigger a resize before you even attempt to add
* the data or figure out if it's a duplicate. Be careful to consider the
* differences between integer and double division when calculating load
* factor.
*
* When regrowing, resize the length of the backing table to
* 2 * old length + 1. You must use the resizeBackingTable method to do so.
*
* Return null if the key was not already in the map. If it was in the map,
* return the old value associated with it.
*
* @param key the key to add
* @param value the value to add
* @return null if the key was not already in the map. If it was in the
* map, return the old value associated with it
* @throws java.lang.IllegalArgumentException if key or value is null
*/
public V put(K key, V value) {
    double LF = (1.0 * size + 1) / table.length;
    if(LF > MAX_LOAD_FACTOR){
        int newSize = 2 * table.length + 1;
        int oldSize = size;
        resizeBackingTable(newSize);
        size = size - oldSize;
    }
    V result = putH(key, value, table);
    return result;    
}

private V putH(K key, V value, ExternalChainingMapEntry<K, V>[] table){
    int index = getIndex(key, table);
    V oldValue = null;
    ExternalChainingMapEntry<K, V> chain = table[index];
    if(chain == null){
        ExternalChainingMapEntry<K, V> newChain = new ExternalChainingMapEntry<>(key, value);
        table[index] = newChain;
        size++;
    }
    else {
        boolean flag = false;
        while(chain != null){
            if(chain.getKey() == key){
                oldValue = chain.getValue();
                chain.setValue(value);
                table[index] = chain;
                flag = true;
            } 
            chain = chain.getNext();
        }
        if (chain == null && !flag){
            ExternalChainingMapEntry<K, V> newChain = new ExternalChainingMapEntry<>(key, value, table[index]);
            table[index] = newChain;
            size++;
        }
    }    
    return oldValue;
}

private int getIndex(K key, ExternalChainingMapEntry<K, V>[] table){
    System.out.println("FOCA: " + Objects.hashCode(key));
    int index = Objects.hashCode(key) % table.length;
    return index < 0 ? (-1) * index : index;
}

/**
* Removes the entry with a matching key from the map.
*
* @param key the key to remove
* @return the value previously associated with the key
* @throws java.lang.IllegalArgumentException if key is null
* @throws java.util.NoSuchElementException if the key is not in the map
*/
public V remove(K key) {
    if(key == null){
        throw new IllegalArgumentException("Error: You cannot remove null data to the HashMap");
    }
    int index = getIndex(key, table);
    ExternalChainingMapEntry<K, V> chain = table[index];
    V removedData = null;
    if(chain == null){
        throw new NoSuchElementException("Key: " + key + "Key is not in table");
    }
    else {
        ExternalChainingMapEntry<K, V> prev = chain;
        boolean flag = false;
        while(chain != null){
            if(chain.getKey() == key){
                if(chain.getNext() == null){
                    removedData = chain.getValue();
                    if(prev == chain){
                        table[index] = null;
                    } else {
                        prev.setNext(chain.getNext());
                    }
                    flag = true;
                    size--; 
                    break;
                }
                else if(chain.getNext().getNext() != null){
                    ExternalChainingMapEntry<K, V> newChain = new ExternalChainingMapEntry<>
                    (chain.getNext().getNext().getKey(), 
                    chain.getNext().getNext().getValue(), 
                    chain.getNext().getNext().getNext());
                    
                    removedData = chain.getValue();
                    chain.setKey(chain.getNext().getKey());
                    chain.setValue(chain.getNext().getValue());
                    chain.setNext(newChain);
                    flag = true;
                    size--; 
                    break;
                }
                else {
                    removedData = chain.getValue();
                    chain.setKey(chain.getNext().getKey());
                    chain.setValue(chain.getNext().getValue());
                    chain.setNext(null);
                    flag = true;
                    size--; 
                    break;
                }  
            }
            prev = chain;
            chain = chain.getNext();
        }
        if(chain == null && !flag){
            throw new NoSuchElementException("Key: " + key + " Key is not in table PARCE");
        } 
    }
    return removedData; 
}

/**
* Gets the value associated with the given key.
*
* @param key the key to search for in the map
* @return the value associated with the given key
* @throws java.lang.IllegalArgumentException if key is null
* @throws java.util.NoSuchElementException if the key is not in the map
*/
public V get(K key) {
    if(key == null){
        throw new IllegalArgumentException("Error: You cannot SEARCHING null data to the HashMap");
    }
    int index = getIndex(key, table);
    ExternalChainingMapEntry<K, V> chain = table[index];
    V valueKey = null;
    if(chain == null){
        throw new NoSuchElementException("Key: " + key + " Key is not in the map MAN");
    }
    else {
        boolean flag = false;
        while(chain != null){
            if(chain.getKey() == key){
                valueKey = chain.getValue();
                flag = true;
            }
            chain = chain.getNext();
        }
        if(chain == null && !flag){
            throw new NoSuchElementException("Key: " + key + " Key is not in table BROO");
        } 
    }
    return valueKey;
}

/**
* Returns whether or not the key is in the map.
*
* @param key the key to search for in the map
* @return true if the key is contained within the map, false
* otherwise
* @throws java.lang.IllegalArgumentException if key is null
*/
public boolean containsKey(K key) {
    if(key == null){
        throw new IllegalArgumentException("Error: You cannot SEARCHING null data to the HashMap");
    }
    int index = getIndex(key, table);
    ExternalChainingMapEntry<K, V> chain = table[index];
    boolean flag = false;
    while(chain != null){
        if(chain.getKey().equals(key)){
            flag = true;
        }
        chain = chain.getNext();
    } 
    return flag;
}

/**
* Returns a Set view of the keys contained in this map.
*
* Use java.util.HashSet.
*
* @return the set of keys in this map
*/
public Set<K> keySet() {
    Set<K> keys = new HashSet<>();
    for (ExternalChainingMapEntry<K, V> entry : table) {
        while (entry != null) {
            //System.out.println("VEAA: " + entry);
            keys.add((K)entry.getKey());
            entry = entry.getNext();
        }
    }
    return keys;
}

/**
* Returns a List view of the values contained in this map.
*
* Use java.util.ArrayList or java.util.LinkedList.
*
* You should iterate over the table in order of increasing index and add
* entries to the List in the order in which they are traversed.
*
* @return list of values in this map
*/
public List<V> values() {
    ArrayList<V> values = new ArrayList<>();
    for (ExternalChainingMapEntry<K, V> entry : table) {
        while (entry != null) {
            values.add(entry.getValue());
            entry = entry.getNext();
        }
    }
    return values;
}

/**
* Resize the backing table to length.
*
* Disregard the load factor for this method. So, if the passed in length is
* smaller than the current capacity, and this new length causes the table's
* load factor to exceed MAX_LOAD_FACTOR, you should still resize the table
* to the specified length and leave it at that capacity.
*
* You should iterate over the old table in order of increasing index and
* add entries to the new table in the order in which they are traversed.
*
* Since resizing the backing table is working with the non-duplicate
* data already in the table, you shouldn't explicitly check for
* duplicates.
*
* Hint: You cannot just simply copy the entries over to the new array.
*
* @param length new length of the backing table
* @throws java.lang.IllegalArgumentException if length is less than the
* number of items in the hash
* map
*/
@SuppressWarnings("unchecked")
public void resizeBackingTable(int length) {
    ExternalChainingMapEntry<K, V>[] copy = (ExternalChainingMapEntry<K, V>[]) 
                                            (new ExternalChainingMapEntry[length]);
    for (ExternalChainingMapEntry<K, V> entry : table) {
        while (entry != null) {
            putH(entry.getKey(), entry.getValue(), copy);
            entry = entry.getNext();
        }
    }
    table = (ExternalChainingMapEntry<K, V>[]) (new ExternalChainingMapEntry[length]);
    table = copy;
}

/**
* Clears the map.
*
* Resets the table to a new array of the initial capacity and resets the
* size.
*/
@SuppressWarnings("unchecked")
public void clear() {
    table = (ExternalChainingMapEntry<K, V>[]) (new ExternalChainingMapEntry[INITIAL_CAPACITY]);
    size = 0;
}

/**
* Returns the table of the map.
*
* For grading purposes only. You shouldn't need to use this method since
* you have direct access to the variable.
*
* @return the table of the map
*/
public ExternalChainingMapEntry<K, V>[] getTable() {
// DO NOT MODIFY THIS METHOD!
return table;
}

/**
* Returns the size of the map.
*
* For grading purposes only. You shouldn't need to use this method since
* you have direct access to the variable.
*
* @return the size of the map
*/
public int size() {
// DO NOT MODIFY THIS METHOD!
return size;
}

public int lenght(){
    return table.length;
}


}