import java.util.List;

public class Messages {

    public static void callTextDelay (int delay){
        try{
            Thread.sleep(delay);
        }
    
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static final List<String> LIBRARY_GREETING =
        List.of(
        "Hello, welcome to your personal lib experience!",
        "Here you can manage, borrow and search for books you're intereested in.");
}