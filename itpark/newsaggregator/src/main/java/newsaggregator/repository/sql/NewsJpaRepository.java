package newsaggregator.repository.sql;

import newsaggregator.model.sql.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsJpaRepository extends JpaRepository<News, Long> {
}
