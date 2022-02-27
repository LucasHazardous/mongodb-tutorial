package lucas.hazardous.mongodb_test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document("book")
public class Book {
    @Id
    public String id;

    public String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("[Book] Id: %s Title: %s", id, title);
    }
}