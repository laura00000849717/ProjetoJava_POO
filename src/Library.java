import java.util.List;
import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado;
    private static List<Book> availableBooks = LibraryDatabase.initializeDatabase();

    public static void accessLibraryInfo() {
        boolean keepRunning = true;

        usuarioLogado = Usuario.createUsuarioInstance();

        while (keepRunning) {
            keepRunning = libraryStartOptions();
        }
    }

    private static boolean libraryStartOptions() {
        System.out.println("\n--- MENU ---");
   
        System.out.println("User: " + usuarioLogado.getNome() + " | ID: " + usuarioLogado.getMatricula());
        System.out.println("(1) Access Library  (2) My Books  (3) My Deadlines  (0) Logout");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.next();
            return true;
        }

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1 -> libraryMainPage();
            case 2 -> displayUserBooks();
            case 3 -> System.out.println("Deadlines feature coming soon...");
            case 0 -> { return false; } 
            default -> System.out.println("Please enter a valid option.");
        }
        return true;
    }

    private static void displayUserBooks() {
        System.out.println("\n==== YOUR BORROWED BOOKS ====");
        List<Book> userBooks = usuarioLogado.getMeusLivros();

        if (userBooks.isEmpty()) {
            System.out.println("You don't have any books yet.");
            return;
        }

        for (int i = 0; i < userBooks.size(); i++) {
            System.out.println("(" + i + ") " + userBooks.get(i).getNome());
        }
        System.out.println("(" + userBooks.size() + ") Back to menu");

        System.out.print("\nSelect a book number to RETURN: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            if (choice >= 0 && choice < userBooks.size()) {
                Book returnedBook = userBooks.remove(choice);
                availableBooks.add(returnedBook);
                System.out.println("\nSuccess! You returned: '" + returnedBook.getNome() + "'");
            }
        } else {
            scanner.next();
        }
    }

    private static void libraryMainPage() {
        System.out.println("\n-- Available Books --");
        for (int i = 0; i < availableBooks.size(); i++) {
            Book b = availableBooks.get(i);
            System.out.println("(" + i + ") " + b.getNome() + " - " + b.getAutor());
        }
        System.out.println("(" + availableBooks.size() + ") Back to menu");

        System.out.print("\nSelect a book number to borrow: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            if (choice >= 0 && choice < availableBooks.size()) {
                Book chosenBook = availableBooks.remove(choice);
                usuarioLogado.getMeusLivros().add(chosenBook);
                System.out.println("\nSuccess! '" + chosenBook.getNome() + "' added to your books.");
            }
        } else {
            scanner.next();
        }
    }
}