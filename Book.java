import java.util.Scanner;

public class Book {
  String title;
  String author;
  int pages;

  public Book() {}

  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  public String getTitle() { return title; }

  public void setTitle(String title) { this.title = title; }

  public String getAuthor() { return author; }

  public void setAuthor(String author) { this.author = author; }

  public int getPages() { return pages; }

  public void setPages(int pages) { this.pages = pages; }

  public void updateTitle(String title) { this.title = title; }

  public boolean compare(int pages) { return this.pages > pages; }

  public boolean isThick() {
    if (!title.equals("Java Programming") && pages > 500) {
      return true;
    }

    if (title.equals("Java Programming") && pages > 350) {
      return true;
    }

    return false;
  }

  public void display() {
    System.out.println("Title = " + title);
    System.out.println("Author = " + author);
    System.out.println("Pages = " + pages);
  }

  public static void main(String[] args) {
    final Book bk = new Book();
    final Scanner scanner = new Scanner(System.in);

    final int maxPages = 5000;
    final int maxBooks = 12;
    final int maxThickBooks = 6;

    int nbPages = 0;
    int nbBooks = 0;
    int nbThickBooks = 0;
    int maxNbPages = 0;
    String maxNbPagesAuthor = "";

    String[] authors = new String[12];

    do {
      // Read book input from keyboard
      System.out.print("Enter book title: ");
      final String title = scanner.next();
      bk.setTitle(title);

      System.out.print("Enter book author: ");
      final String author = scanner.next();
      bk.setAuthor(author);

      System.out.print("Enter book pages: ");
      final int pages = scanner.nextInt();
      bk.setPages(pages);

      if (bk.isThick()) {
        nbThickBooks += 1;
        bk.display();
      }

      if (pages > maxNbPages) {
        maxNbPagesAuthor = author;
        maxNbPages = pages;
      }

      authors[nbBooks] = author;

      nbPages += pages;
      nbBooks += 1;

      System.out.println();
      System.out.println("Number of books = " + nbBooks);
      System.out.println("Total number of pages = " + nbPages);
      System.out.println("Number of thick books = " + nbThickBooks);
      System.out.println();

    } while (nbBooks < maxBooks && nbPages < maxPages && nbThickBooks < maxThickBooks);

    scanner.close();

    for (int i = 0; i < nbBooks; i++) {
      System.out.println((i + 1) + ". " + authors[i]);
    }

    System.out.println("Author with max number of pages : " + maxNbPagesAuthor);
  }
}
