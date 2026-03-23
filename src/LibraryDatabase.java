import java.util.List;
import java.util.ArrayList;

public class LibraryDatabase {
    public static List<Book> initializeDatabase(){
        List<Book> bookDatabase = new ArrayList<>();

        bookDatabase.add(Book.CreateBookInstance("The Odyssey", "Homer", 00000));
        bookDatabase.add(Book.CreateBookInstance("The Great Gatsby", "F. Scott Fitzgerald", 00001));
        bookDatabase.add(Book.CreateBookInstance("To Kill a Mockingbird", "Harper Lee", 00010));
        bookDatabase.add(Book.CreateBookInstance("1984", "George Orwell", 00011));
        bookDatabase.add(Book.CreateBookInstance("Pride and Prejudice", "Jane Austen", 00100));
        bookDatabase.add(Book.CreateBookInstance("The Catcher in the Rye", "J.D. Salinger", 00101));
        bookDatabase.add(Book.CreateBookInstance("The Hunger Games", "Suzanne Collins", 00110));
        bookDatabase.add(Book.CreateBookInstance("The Little Prince", "Antoine de Saint-Exupéry", 00111));
        bookDatabase.add(Book.CreateBookInstance("The Hitchhiker’s Guide to the Galaxy ", "Douglas Adams", 01000));
        bookDatabase.add(Book.CreateBookInstance("The Lord of the Rings", "J.R.R. Tolkien", 01001));
        
        return bookDatabase;
    }
}
