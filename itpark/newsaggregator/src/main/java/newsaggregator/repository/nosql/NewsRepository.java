package newsaggregator.repository.nosql;

import newsaggregator.model.nosql.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String> {

}
