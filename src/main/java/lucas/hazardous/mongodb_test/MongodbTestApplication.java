package lucas.hazardous.mongodb_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbTestApplication extends JFrame implements CommandLineRunner {
	@Autowired
    BookRepository bookRepository;

	private BookViewerPanel bookViewerPanel;

	public MongodbTestApplication() {
		initFrameUI();
	}

	public static void main(String[] args) {
		var ctx = new SpringApplicationBuilder(MongodbTestApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			var app = ctx.getBean(MongodbTestApplication.class);
			app.setVisible(true);
		});
	}

	@Override
	public void run(String... args) {
		bookRepository.deleteAll();
		bookRepository.save(new Book("Strange case of Dr Jekyll and Mr Hyde", 20));
		bookRepository.save(new Book("The Art of War", 999));
		bookRepository.save(new Book("Permanent Record", 30));

		String result = "";

		for(Book book: bookRepository.findAll()) {
			result += book + "\n";
		}

		bookViewerPanel.getTextArea().setText(result);

		System.out.println(bookRepository.findBookByPriceBetween(25, 1000));
	}

	private void initFrameUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Book Viewer");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);

		bookViewerPanel = new BookViewerPanel();
		add(bookViewerPanel);
	}
}
