package com.news.mewsapi.web;

import com.news.mewsapi.service.models.NewsServiceModel;
import com.news.mewsapi.service.servicies.NewsService;
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

    /**
     * Return all news from db if no sorts present
     *
     * @param sort  return news from news?sort=date,desc&description,asc and all variations of sorts
     * @param date  return news by given date if present in format "yyyy-mm-dd"
     * @param title return news by title/or part of it, case sensitive
     * @return news from db
     */
    @GetMapping("/news")
    public List<NewsServiceModel> getNewsById(Sort sort, @RequestParam(required = false) String date, String title) {

        if (date != null && title == null) {
            return newsService.getNewsByDate(date);
        } else if (title != null && date == null) {
            return newsService.getNewsByTitle(title);
        } else if (date != null) {
            return newsService.getAllNewsByDateAndTitle(date, title);
        }
        return newsService.getAllNews(sort);
    }


    /**
     * Save new news to DB
     *
     * @param newsServiceModel mapping input to NewsServiceModel
     * @return saved news
     */
    @PostMapping("/news/add")
    public NewsServiceModel saveNews(@RequestBody NewsServiceModel newsServiceModel) {
        LocalDate date = LocalDate.now();
        newsServiceModel.setDate(date);
        return this.newsService.saveNews(newsServiceModel);
    }

}