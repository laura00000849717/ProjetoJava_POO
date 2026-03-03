public class Book{
    String title;
    String author;
    int serialNumber;
    boolean isBorrowed;

    private Book(String title, String author, int serialNumber, boolean isBorrowed){
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.isBorrowed = isBorrowed;
    }

    public static Book CreateBookInstance(String bookTitle, String bookAuthor, int bookSerialNumber){        
        return new Book(bookTitle, bookAuthor, bookSerialNumber, false);
    }
}