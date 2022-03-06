package lucas.hazardous.mongodb_test;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findBookByPriceBetween(int price1, int price2);
}