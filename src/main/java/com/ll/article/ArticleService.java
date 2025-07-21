package com.ll.article;

import java.util.List;
import java.util.Map;

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

    public String loginSet(int memberId) {
        Map<String,Object> rs = articleRepository.getUserId(memberId);
        if(rs.isEmpty()){
            return "OFF";
        }
        return rs.get("userId") + " ON";
    }
}
