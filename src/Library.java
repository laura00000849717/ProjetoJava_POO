import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library{
    private static final Scanner scanner = new Scanner(System.in);

    public static void accessLibraryInfo(){
        //libraryDefaultGreeting();
        libraryStartOptions();
    }

    private static void libraryDefaultGreeting() {

        for (int i = 0; i < Messages.LIBRARY_GREETING.size(); i++) {
            String greeting_text = Messages.LIBRARY_GREETING.get(i);

            for (int j = 0; j < greeting_text.length(); j++) {
                System.out.print(greeting_text.charAt(j));
                Messages.callTextDelay(40);
            }

            System.out.println();
            Messages.callTextDelay(800);
        }
    }
    
    private static void libraryStartOptions(){
        int option = 0;

        while (true) {
            System.out.print("\nWhat would you like to do today?");
            System.out.print("\n(1) Access Library     (2) My books     (3) My deadlines\n");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                if (option >= 1 && option <= 3) {
                    break;

                }
                
                else {
                    System.out.println("Please enter a number between 1 and 3.");
                }
            }
            
            else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        switch (option) {
            case 1:
                LibraryMainPage();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private static void LibraryMainPage(){
        System.out.println("--Home page--");
        List<Book> availableBoks = FetchBookDatabase();
        System.out.println(availableBoks);
    }


    private static List<Book> FetchBookDatabase(){
        List<Book> availableBoks = new ArrayList<>();
        Book bookInstance = Book.CreateBookInstance("The Odyssey", "Homer", 00000);
        availableBoks.add(bookInstance);
        return availableBoks;
    }
}