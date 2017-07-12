package hashing;


/**
 *
 * @author pablo
 */
public class HashObject {
    
    private final String name;
    private final String surname;
    protected int phone;
    protected int next;
    
    public HashObject(String name, String surname, int phone){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.next = -1;
    }
    
    @Override
    public String toString(){
        return ""+this.name+" "+this.surname+" ("+this.phone+")";
    }
    
}
