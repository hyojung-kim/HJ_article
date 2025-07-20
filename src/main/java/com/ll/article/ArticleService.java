package com.ll.article;

import java.util.List;
import java.util.Map;

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

    public Map<String, Object> IsDuplicate(String userId) {
        return articleRepository.IsDuplicate(userId);
    }

    public Map<String,Object> IsDuplicate(String userId, String userPw) {
        Map<String,Object> rs = articleRepository.IsDuplicate(userId, userPw);
        return rs;
    }

    public void join(String rsId, String PW) {
        articleRepository.join(rsId, PW);
    }

    public void loginSet(String loginId) {
        if(loginId.equals("")){
            System.out.println("OFF");
        }
        System.out.println(loginId + "ON");

    }
}
