import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private Aluno usuarioLogado;

    public Library() {
        this.availableBooks = LibraryDatabase.initializeDatabase();
    }

    public void setUsuarioLogado(Aluno aluno) {
        this.usuarioLogado = aluno;
    }

    public Aluno getUsuarioLogado() {
        return usuarioLogado;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public Book borrowBook(int index) {
        if (index < 0 || index >= availableBooks.size()) {
            return null;
        }
        Book book = availableBooks.remove(index);
        usuarioLogado.getMeusLivros().add(book);
        return book;
    }

    public Book returnBook(int index) {
        List<Book> userBooks = usuarioLogado.getMeusLivros();

        if (index < 0 || index >= userBooks.size()) {
            return null;
        }
        Book book = userBooks.remove(index);
        availableBooks.add(book);
        return book;
    }
}