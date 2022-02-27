package lucas.hazardous.mongodb_test;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface BookRepository extends MongoRepository<Book, String> {}