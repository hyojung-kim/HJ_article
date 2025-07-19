package com.ll.article;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;
    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public  List<Article> findAll() {
        return articleRepository.findAll();
    }

    public int create(String title, String content, int memberId) {
        return articleRepository.create(title, content, memberId);
    }
}
