package newsaggregator.service.impl;

import newsaggregator.model.nosql.News;
import newsaggregator.repository.sql.NewsJpaRepository;
import newsaggregator.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    NewsJpaRepository  newsJpaRepository;

    @Override
    public void save(News news) {
        newsJpaRepository.save(new newsaggregator.model.sql.News());
    }

    @Override
    public boolean isExists(String title) {
        List<newsaggregator.model.sql.News> allNews = newsJpaRepository.findAll();
        for (newsaggregator.model.sql.News news: allNews) {
            if (news.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<newsaggregator.model.sql.News> getAllNews(String title) {
        return newsJpaRepository.findAll();
    }
}
