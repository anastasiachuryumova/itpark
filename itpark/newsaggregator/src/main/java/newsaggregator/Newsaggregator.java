package newsaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("newsaggregator.model.sql")
@EnableMongoRepositories
public class Newsaggregator {

    public static void main(String[] args) {
        SpringApplication.run(Newsaggregator.class, args);
    }
}
