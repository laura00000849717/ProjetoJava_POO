import java.util.List;
import java.util.Scanner;

public class LibraryUI {
    private final Scanner scanner = new Scanner(System.in);
    private final Library library;

    public LibraryUI(Library library) {
        this.library = library;
    }

    public void start() {
        Aluno usuario = Aluno.iniciarSessao();
        if (usuario == null) return;
        library.setUsuarioLogado(usuario);

        boolean running = true;
        while (running) {
            running = showMainMenu();
        }
    }

    private boolean showMainMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("Usuario: " + library.getUsuarioLogado().getNome());
        System.out.println("(1) Biblioteca (2) Meus Livros (0) Logout");

        if (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida.");
            scanner.next();
            return true;
        }

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> showBooks();
            case 2 -> showUserBooks();
            case 0 -> { return false; }
            default -> System.out.println("Opção inválida.");
        }

        return true;
    }

    private void showBooks() {
        List<Book> books = library.getAvailableBooks();
        System.out.println("\n-- Livros disponíveis --");

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println("(" + i + ") " + b.getTitulo() + " - " + b.getAutor());
        }

        System.out.println("(" + books.size() + ") Voltar");
        System.out.print("Escolha um livro: ");

        if (!scanner.hasNextInt()) {
            scanner.next();
            return;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice >= 0 && choice < books.size()) {
            Book book = library.borrowBook(choice);
            System.out.println("Você pegou: " + book.getTitulo());
        }
    }

    private void showUserBooks() {
        List<Book> userBooks = library.getUsuarioLogado().getMeusLivros();
        System.out.println("\n-- Seus livros --");

        if (userBooks.isEmpty()) {
            System.out.println("Nenhum livro emprestado.");
            return;
        }

        for (int i = 0; i < userBooks.size(); i++) {
            System.out.println("(" + i + ") " + userBooks.get(i).getTitulo());
        }

        System.out.print("Escolha livro para devolver: ");

        if (!scanner.hasNextInt()) {
            scanner.next();
            return;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice >= 0 && choice < userBooks.size()) {
            Book book = library.returnBook(choice);
            System.out.println("Você devolveu: " + book.getTitulo());
        }
    }
}