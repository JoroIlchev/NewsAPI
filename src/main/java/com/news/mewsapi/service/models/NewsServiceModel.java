package com.news.mewsapi.service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsServiceModel {
    private int id;
    private LocalDate date;
    private String title;
    private String description;
    private String text;


}