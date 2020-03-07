package com.news.mewsapi.service.servicies;

import com.news.mewsapi.service.models.NewsServiceModel;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface NewsService {
    List<NewsServiceModel> getAllNews();

    List<NewsServiceModel> getAllNews(Sort sort);

    NewsServiceModel saveNews(NewsServiceModel newsServiceModel);
}
