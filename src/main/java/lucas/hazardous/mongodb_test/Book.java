package lucas.hazardous.mongodb_test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("book")
public class Book {
    @Id
    public String id;

    public String title;

    public int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("[Book] Id: %s | Title: %s | Price: %d", id, title, price);
    }
}