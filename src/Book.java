public class Book{
    private String title;
    private String author;
    private boolean isBorrowed;

    private Book(String title, String author, boolean isBorrowed){
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public static Book CreateBookInstance(String bookTitle, String bookAuthor, boolean isBorrowed){        
        return new Book(bookTitle, bookAuthor, isBorrowed);
    }

    public String getTitulo(){
        return title;
    }

    public String getAutor(){
        return author;
    }

    public boolean getBorrowedStatus(){
        return isBorrowed;
    }
}