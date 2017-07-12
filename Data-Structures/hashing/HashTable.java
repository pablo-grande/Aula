package hashing;


/**
 *
 * @author pablo
 */
public class HashTable {
    
    private final int length;
    private int count;
    private final HashObject hashTable[];
    
    public HashTable(int length){
        this.length = length;
        this.count = 0;
        this.hashTable = new HashObject[length];
    }
    
    
    /**
     * Inserts a hash object into hash table.
     * 
     * Gets the hash position of the phone field of the object and tries to insert
     * it.
     * If there is a collision follows the links until the last element and
     * rehash with the last element's phone. After that, if there is another
     * collision, simply try to find the next available position and link new
     * introduced element as new last.
     * @param obj
     * @throws Exception 
     */
    public void insert(HashObject obj) throws Exception{
        
        if (count == length)
            throw new UnsupportedOperationException("ERROR: Table is full");
        
        int probe = hash(obj.phone);
        HashObject aux = hashTable[probe];
        
        if (hashTable[probe] != null){
            /*
            We have a collision.
            Move to the next available element
            */
            while (hashTable[probe].next != -1)
                probe = hashTable[probe].next;
            
            //rehash position of the last element
            int last = probe;
            probe = reHash(hashTable[last].phone);
            
            /*
            in case we have another collision move to the next available
            position and link the element with last
            */
            while (hashTable[probe] != null && hashTable[probe] != aux)
                probe++;
            
            hashTable[last].next = probe;
        }
        
        hashTable[probe] = obj;
        count++;
    }
    
    
    /**
     * Gets hash object from hash table from phone field.
     * 
     * Calculates the hash from a given phone and returns the object from
     * that index at the hash table.
     * If the phone is not the same, then move through links from hash objects
     * until we find the element with same hash and phone
     * @param phone
     * @return
     * @throws IndexOutOfBoundsException 
     */
    public HashObject get(int phone) throws IndexOutOfBoundsException{
        HashObject obj = hashTable[hash(phone)];
        
        while (obj != null){
            if (obj.phone == phone)
                return obj;
            //check linked elements until we find something
            obj = hashTable[obj.next];
        }
        //or until we fail
        throw new IndexOutOfBoundsException("Element with phone "+phone+" was not found");
    }
    
    
    /**
     * Simple hash function.
     * 
     * Calculates a position in hashTable with the phone number
     * of a hashObject. The position is at the first half of table
     * @param phone
     * @return 
     */
    private int hash(int phone){
        return phone % (length/2);
    }
    
    
    /**
     * Auxiliary hash function.
     * 
     * Gives an index on the bottom half of the hash table.
     * At those positions will be stored the synonyms of hash collisions.
     * @param phone
     * @return 
     */
    private int reHash(int phone){
        return hash(phone) + (length/2);
    }
    
    
    public void print(){
        System.out.println("----\nCount: " + count+"\n----");
        for (int i = 0; i < length; i++) 
            System.out.println(hashTable[i]);
        System.out.println("----\n\n");
    }
    
}
