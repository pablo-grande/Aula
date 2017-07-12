package hashing;


/**
 *
 * @author pablo
 */
public class Hashing {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //trying insert
        HashTest.insert("Alice","Test",9);
        //trying colision
        HashTest.insert("Collision", "Test", 19);
        System.out.println("Testing get...");
        HashTest.get(19);
        //trying get non-existing phone
        HashTest.get(0);
        
    }
    
}
