import java.util.List;
import java.util.Scanner;

public class Library {
    private static final Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado;
    private static List<Book> availableBooks = LibraryDatabase.initializeDatabase();

    public static void accessLibraryInfo() {
        boolean keepRunning = true;

        usuarioLogado = Usuario.iniciarSessao();
        if (usuarioLogado != null){
            while (keepRunning) {
                keepRunning = libraryStartOptions();
            }
        }
    }

    private static boolean libraryStartOptions() {
        System.out.println("\n--- MENU ---");
   
        System.out.println("Usuario: " + usuarioLogado.getNome() + " | RA: " + usuarioLogado.getMatricula());
        System.out.println("(1) Acessar Biblioteca  (2) Meus Livros  (3) Meus prazos  (0) Logout");

        if (!scanner.hasNextInt()) {
            System.out.println("Seleção inválida. Tente novamente.");
            scanner.next();
            return true;
        }

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1 -> libraryMainPage();
            case 2 -> displayUserBooks();
            case 3 -> System.out.println("A opção de prazos está sendo implementada...");
            case 0 -> { return false; } 
            default -> System.out.println("Seleção inválida. Tente novamente.");
        }
        return true;
    }

    private static void displayUserBooks() {
        System.out.println("\n==== SEUS LIVROS EMPRESTADOS ====");
        List<Book> userBooks = usuarioLogado.getMeusLivros();

        if (userBooks.isEmpty()) {
            System.out.println("Você ainda não tem nenhum livro.");
            return;
        }

        for (int i = 0; i < userBooks.size(); i++) {
            System.out.println("(" + i + ") " + userBooks.get(i).getTitulo());
        }
        System.out.println("(" + userBooks.size() + ") Voltar ao menu");

        System.out.print("\n Selecione o número do livro que deseja RETORNAR: ");
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            if (choice >= 0 && choice < userBooks.size()) {
                Book returnedBook = userBooks.remove(choice);
                availableBooks.add(returnedBook);
                System.out.println("\nSucesso. Você retornou: '" + returnedBook.getTitulo() + "'");
            }
        } else {
            scanner.next();
        }
    }

    private static void libraryMainPage() {
        System.out.println("\n-- Livros disponíveis --");
        for (int i = 0; i < availableBooks.size(); i++) {
            Book b = availableBooks.get(i);
            System.out.println("(" + i + ") " + b.getTitulo() + " - " + b.getAutor());
        }
        System.out.println("(" + availableBooks.size() + ") Voltar ao menu");

        System.out.print("\n Selecione um livro para emprestar: ");
        
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            if (choice >= 0 && choice < availableBooks.size()) {
                Book chosenBook = availableBooks.remove(choice);
                usuarioLogado.getMeusLivros().add(chosenBook);
                System.out.println("\nSucesso. '" + chosenBook.getTitulo() + "' foi adicionado aos seus livros.");
            }
        } else {
            scanner.next();
        }
    }
}