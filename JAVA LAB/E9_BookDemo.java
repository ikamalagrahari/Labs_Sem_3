import java.lang.*;

class Book {
  String name, author, publisher;
  String publishDate;
  double price;

  Book(String name, String author, String publisher, String publishDate, double price) {
    this.name = name;
    this.author = author;
    this.publisher = publisher;
    this.publishDate = publishDate;
    this.price = price;
  }

  void display() {
    System.out.println("Book details");
    System.out.println("Name: " + name);
    System.out.println("Author: " + author);
    System.out.println("Publisher: " + publisher);
    System.out.println("Published Date: " + publishDate);
    System.out.println("Selling price: " + price);

  }
}

class ReferenceBook extends Book {
  String subject;

  ReferenceBook(String name, String author, String publisher, String publishDate, double price, String subject) {
    super(name, author, publisher, publishDate, price);
    this.subject = subject;
  }

  @Override
  void display() {
    System.out.println("Reference Book");
    super.display();
    System.out.println("Reference book of subject - " + subject);
    System.out.println();
  }

}

class Magazine extends Book {
  String demographic;

  Magazine(String name, String author, String publisher, String publishDate, double price, String demographic) {
    super(name, author, publisher, publishDate, price);
    this.demographic = demographic;
  }

  @Override
  void display() {
    System.out.println("Magazine");
    super.display();
    System.out.println("It is catered to " + demographic);
    System.out.println();
  }
}

public class E9_BookDemo {
  public static void main(String[] args) {
    ReferenceBook rfb = new ReferenceBook("Enginnering Graphics Basics", "Ashwin Kamble", "VPPCOE publishing house",
        "31/02/2022", 420.69, "Graphics");
    Magazine m = new Magazine("Discovery of India", "Jawaharlal Nehru", "All India Publishcation", "14/03/1989",
        275.33, "Indian Youth");

    rfb.display();
    m.display();
  }
}
