import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado;

    public static void accessLibraryInfo(){
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
                libraryMainPage();
                break;
            case 2:
                exibirMeusLivros();
                break;
            case 3:
                System.out.println("Deadlines feature coming soon...");
                break;
        }
    }

    private static void exibirMeusLivros() {
        System.out.println("\n==== YOUR BORROWED BOOKS ====");
        List<Book> livros = usuarioLogado.getMeusLivros();

        if (livros.isEmpty()) {
            System.out.println("You don't have any books yet.");
        } else {
            for (int i = 0; i < livros.size(); i++) {
                // Supondo que Book tenha um método toString ou campos acessíveis
                System.out.println((i + 1) + ". " + livros.get(i).toString());
            }
        }
        
        System.out.println("=============================");
        // Retorna ao menu após visualizar
        libraryStartOptions();
    }

private static void libraryMainPage() {
    System.out.println("\n-- Home Page (Available Books) --");
    List<Book> availableBooks = fetchBookDatabase();

    // Listando com números para o usuário escolher
    for (int i = 0; i < availableBooks.size(); i++) {
        // Usando getNome() e getAutor() para uma exibição mais bonita
        Book b = availableBooks.get(i);
        System.out.println("(" + i + ") " + b.getNome() + " - " + b.getAutor());
    }
    System.out.println("(" + availableBooks.size() + ") Back to menu");

    System.out.print("\nSelect a book number to borrow: ");
    
    if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine(); // IMPORTANTE: Limpa o buffer do teclado (o "Enter")

        if (choice >= 0 && choice < availableBooks.size()) {
            Book livroEscolhido = availableBooks.get(choice);
            
            // Adicionando à lista do usuário logado
            usuarioLogado.getMeusLivros().add(livroEscolhido);
            
            System.out.println("\nSuccess! '" + livroEscolhido.getNome() + "' added to your books.");
        } else if (choice == availableBooks.size()) {
            System.out.println("Returning...");
        } else {
            System.out.println("Invalid selection.");
        }
    } else {
        System.out.println("Please enter a valid number.");
        scanner.next(); 
    }
    
   
    libraryStartOptions();
}

private static List<Book> fetchBookDatabase() {
    List<Book> availableBooks = new ArrayList<>();
    availableBooks.add(Book.CreateBookInstance("The Odyssey", "Homer", 101));
    return availableBooks;
}

}