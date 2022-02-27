package lucas.hazardous.mongodb_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbTestApplication implements CommandLineRunner {
	@Autowired
    BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbTestApplication.class, args);
	}

	@Override
	public void run(String... args) {
		bookRepository.deleteAll();

		bookRepository.save(new Book("Strange case of Dr Jekyll and Mr Hyde"));
		bookRepository.save(new Book("The Art of War"));
		bookRepository.save(new Book("Permanent Record"));

		for(Book book: bookRepository.findAll()) {
			System.out.println(book);
		}
	}
}
