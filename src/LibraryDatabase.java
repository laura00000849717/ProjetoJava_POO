import java.util.List;
import java.util.ArrayList;

public class LibraryDatabase {
    public static List<Book> initializeDatabase(){
        List<Book> bookDatabase = new ArrayList<>();

        bookDatabase.add(Book.CreateBookInstance("The Odyssey", "Homer", false));
        bookDatabase.add(Book.CreateBookInstance("The Great Gatsby", "F. Scott Fitzgerald", false));
        bookDatabase.add(Book.CreateBookInstance("To Kill a Mockingbird", "Harper Lee", false));
        bookDatabase.add(Book.CreateBookInstance("1984", "George Orwell", false));
        bookDatabase.add(Book.CreateBookInstance("Pride and Prejudice", "Jane Austen", false));
        bookDatabase.add(Book.CreateBookInstance("The Catcher in the Rye", "J.D. Salinger", false));
        bookDatabase.add(Book.CreateBookInstance("The Hunger Games", "Suzanne Collins", false));
        bookDatabase.add(Book.CreateBookInstance("The Little Prince", "Antoine de Saint-Exupéry", false));
        bookDatabase.add(Book.CreateBookInstance("The Hitchhiker’s Guide to the Galaxy ", "Douglas Adams", false));
        bookDatabase.add(Book.CreateBookInstance("The Lord of the Rings", "J.R.R. Tolkien", false));
        
        return bookDatabase;
    }
}