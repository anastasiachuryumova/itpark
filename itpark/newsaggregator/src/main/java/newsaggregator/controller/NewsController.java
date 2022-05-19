package newsaggregator.controller;

import lombok.RequiredArgsConstructor;
import newsaggregator.dto.NewsDto;
import newsaggregator.mapper.NewsMapper;
import newsaggregator.model.nosql.News;
import newsaggregator.repository.sql.NewsJpaRepository;
import newsaggregator.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@Controller
@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsJpaRepository newsJpaRepository;
    private final NewsMapper newsMapper;
    private final NewsService newsService;

    @GetMapping(value = "/news")
    public List<newsaggregator.model.sql.News> getNews(String title) {
        return newsService.getAllNews(title);
    }

    @PostMapping ("/news/save")
    public void save (@Valid News news) {
        newsJpaRepository.save(newsMapper.toEntity(news));

    }

    @GetMapping("/news/check")
    public boolean isExists(@RequestParam("title") long id, Model model) {
        model.addAttribute("title", newsJpaRepository.existsById(id));
    return true;
    }

    @GetMapping("/news/get")
    public List<newsaggregator.model.sql.News> getAllNews (@RequestParam("title") String title, Model model) {
        NewsDto currentNews = (NewsDto) newsService.getAllNews(title).stream().collect(Collectors.toList());
        model.addAttribute("title", currentNews);
        return newsService.getAllNews(title);
    }
}
