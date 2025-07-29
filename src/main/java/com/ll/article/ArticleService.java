package com.ll.article;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository;
    public ArticleService() {
        articleRepository = new ArticleRepository();
    }
  
    public  List<Article> findAll(int articleCode) {
        return articleRepository.findAll(articleCode);
    }

    public int create(Article article) {
        return articleRepository.create(article);
    }

}
