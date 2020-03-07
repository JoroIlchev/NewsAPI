package com.news.mewsapi.service.servicies;

import com.news.mewsapi.service.models.NewsServiceModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface NewsService {


    List<NewsServiceModel> getAllNews(Sort sort);

    NewsServiceModel saveNews(NewsServiceModel newsServiceModel);

    List<NewsServiceModel> getNewsByDate(String date);

    List<NewsServiceModel> getNewsByTitle(String title);

    List<NewsServiceModel> getAllNewsByDateAndTitle(String date, String title);
}
