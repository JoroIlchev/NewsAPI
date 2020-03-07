package com.news.mewsapi.web;

import com.news.mewsapi.service.models.NewsServiceModel;
import com.news.mewsapi.service.servicies.NewsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    /*
    Return all news from DB, main page
     */
//    @GetMapping
//    public List<NewsServiceModel> getAllNews() {
//        return this.newsService.getAllNews();
//    }

    /**
     * Return all news from db if no sorts present
     * @param sort news?sort=date,desc&description,asc
     * @return
     */
    @GetMapping("/news")
    public List<NewsServiceModel> getNewsById(Sort sort) {
        return this.newsService.getAllNews(sort);
    }

    /**
     * Save new news to DB
     * @param newsServiceModel
     * @return
     */
    @PostMapping("/news/add")
    public NewsServiceModel saveNews(@RequestBody NewsServiceModel newsServiceModel) {
        LocalDate date = LocalDate.now();
        newsServiceModel.setDate(date);
        return this.newsService.saveNews(newsServiceModel);
    }

    /**
     * Should check what kind filters need
     * @param date
     * @param title
     * @return
     */

    @GetMapping("/news/filter")
    public List<NewsServiceModel> getNewsById(@RequestParam(required = false) String date, String title) {
        return this.newsService.getAllNews();
    }
}