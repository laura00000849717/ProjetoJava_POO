import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado;

   
    private static List<Book> availableBooks = LibraryDatabase.initializeDatabase();

    public static void accessLibraryInfo(Usuario usuario) {
        usuarioLogado = usuario; 
        libraryStartOptions();
    }

    private static void libraryStartOptions() {
        int option = 0;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("User: " + usuarioLogado.nome + " | ID: " + usuarioLogado.matricula);
            System.out.println("(1) Access Library  (2) My books  (3) My deadlines");
            
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                if (option >= 1 && option <= 3) break;
                else System.out.println("Please enter a number between 1 and 3.");
            } else {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }

        switch (option) {

            case 1:
                 libraryMainPage(); break;
            case 2: 
                 exibirMeusLivros(); break;
            case 3:
                 System.out.println("Deadlines feature coming soon..."); break;
        }
    }

    private static void exibirMeusLivros() {
        System.out.println("\n==== YOUR BORROWED BOOKS ====");
        List<Book> livrosDoUsuario = usuarioLogado.getMeusLivros();

        if (livrosDoUsuario.isEmpty()) {
            System.out.println("You don't have any books yet.");
            System.out.println("=============================");
        } else {
            for (int i = 0; i < livrosDoUsuario.size(); i++) {
                System.out.println("(" + i + ") " + livrosDoUsuario.get(i).getNome());
            }
            System.out.println("(" + livrosDoUsuario.size() + ") Back to menu");

            System.out.print("\nSelect a book number to RETURN: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                if (choice >= 0 && choice < livrosDoUsuario.size()) {
                    Book livroDevolvido = livrosDoUsuario.remove(choice);
                    availableBooks.add(livroDevolvido);
                    System.out.println("\nSuccess! You returned: '" + livroDevolvido.getNome() + "'");
                }
            } else {
                scanner.next();
            }
        }
        libraryStartOptions();
    }

    private static void libraryMainPage() {
        System.out.println("\n-- Home Page (Available Books) --");
        for (int i = 0; i < availableBooks.size(); i++) {
            Book b = availableBooks.get(i);
            System.out.println("(" + i + ") " + b.getNome() + " - " + b.getAutor());
        }
        System.out.println("(" + availableBooks.size() + ") Back to menu");

        System.out.print("\nSelect a book number to borrow: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice >= 0 && choice < availableBooks.size()) {
                Book livroEscolhido = availableBooks.remove(choice); 
                usuarioLogado.getMeusLivros().add(livroEscolhido);
                System.out.println("\nSuccess! '" + livroEscolhido.getNome() + "' added to your books.");
            }
        } else {
            scanner.next();
        }
        libraryStartOptions();
    }
}