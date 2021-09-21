package com.news.mewsapi.service.servicies;

import com.news.mewsapi.data.entities.News;
import com.news.mewsapi.data.repository.NewsRepository;
import com.news.mewsapi.service.models.NewsServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;

    
    public NewsServiceImpl(NewsRepository newsRepository, ModelMapper modelMapper) {
        this.newsRepository = newsRepository;
        this.modelMapper = modelMapper;
    }

    public List<NewsServiceModel> getAllNews(Sort sort) {
        return newsRepository.findAll(sort).stream()
                .map(n -> modelMapper.map(n, NewsServiceModel.class))
                .collect(Collectors.toList());
    }

    public NewsServiceModel saveNews(NewsServiceModel newsServiceModel) {
        News news = modelMapper.map(newsServiceModel, News.class);
        return modelMapper.map(newsRepository.save(news), NewsServiceModel.class);
    }

    @Override
    public List<NewsServiceModel> getNewsByDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return newsRepository.findAllByDate(localDate).stream()
                .map(n -> modelMapper.map(n, NewsServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsServiceModel> getNewsByTitle(String title) {
        return newsRepository.findByTitleContaining(title).stream()
                .map(n -> modelMapper.map(n, NewsServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsServiceModel> getAllNewsByDateAndTitle(String date, String title) {
        LocalDate localDate = LocalDate.parse(date);
        return newsRepository.findByDateAndTitleContaining(localDate, title).stream()
                .map(n -> modelMapper.map(n, NewsServiceModel.class))
                .collect(Collectors.toList());
    }
}
