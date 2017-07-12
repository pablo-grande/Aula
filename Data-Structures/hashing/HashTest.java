package hashing;


/**
 *
 * @author pablo
 */
public class HashTest {
    
    private static final int TABLE_LENGTH = 50;
    private static final HashTable HT = new HashTable(TABLE_LENGTH);
    
    
    public static void insert(String name, String surname, int phone){
        HashObject obj = new HashObject(name, surname, phone);
        try{
            HT.insert(obj);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ERROR: Bottom half of hash table is full");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            HT.print();
        }
        
    }
    
    
    public static void get(int phone){
        try{
            System.out.println("Element with phone "+phone +": "+HT.get(phone));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }finally{
            HT.print();
        }
        
    }
    
}
