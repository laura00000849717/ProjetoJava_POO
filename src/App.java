public class App {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryUI libraryUI = new LibraryUI(library);

        libraryUI.start();
    }
}