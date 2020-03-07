package com.news.mewsapi.service.servicies;

import com.news.mewsapi.data.entities.News;
import com.news.mewsapi.data.repository.NewsRepository;
import com.news.mewsapi.service.models.NewsServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }

    public List<NewsServiceModel> getAllNews() {
        return (List)this.newsRepository.findAll().stream().map((n) -> {
            return (NewsServiceModel)this.modelMapper.map(n, NewsServiceModel.class);
        }).collect(Collectors.toList());
    }

    public List<NewsServiceModel> getAllNews(Sort sort) {
        return (List)this.newsRepository.findAll(sort).stream().map((n) -> {
            return (NewsServiceModel)this.modelMapper.map(n, NewsServiceModel.class);
        }).collect(Collectors.toList());
    }

    public NewsServiceModel saveNews(NewsServiceModel newsServiceModel) {
        News news = (News)this.modelMapper.map(newsServiceModel, News.class);
        return (NewsServiceModel)this.modelMapper.map(this.newsRepository.save(news), NewsServiceModel.class);
    }
}
