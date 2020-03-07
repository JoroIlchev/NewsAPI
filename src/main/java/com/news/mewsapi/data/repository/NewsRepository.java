package com.news.mewsapi.data.repository;

import com.news.mewsapi.data.entities.News;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    List<News> findAll(Sort sort);
    List<News> findAllByDate(LocalDate date);
    List<News> findByTitleContaining(String title);
    List<News> findByDateAndTitleContaining(LocalDate date, String title);
}
