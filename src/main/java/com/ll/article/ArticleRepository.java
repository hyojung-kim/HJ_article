package com.ll.article;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {

    public List<Article> findAll() {
        List<Article> articleList = new ArrayList<>();
        String sql = String.format("SELECT A.id AS id,\n" +
                "A.title AS title,\n" +
                "A.content AS content,\n" +
                "M.UserId AS MemberName,\n" +
                "A.regDate AS InsDate\n" +
                "FROM article AS A\n" +
                "INNER JOIN `MEMBER` AS M\n" +
                "ON A.memberId = M.id;");
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows(sql);
        for(Map<String,Object> row : rows){
            Article article = new Article(row);
            articleList.add(article);
        }
        return articleList;
    }

    public int create(String title, String content, int memberId) {
        String sql = String.format("INSERT INTO article (title, content, memberId) \n" +
                "VALUES('%s', '%s', %d);", title, content, memberId);
        return Container.getDBConnection().insert(sql);
    }

    public Map<String, Object> IsDuplicate(String userId) {
        String sql = String.format("SELECT * FROM `MEMBER` WHERE userId = '%s';",userId);
        Map<String, Object> row = Container.getDBConnection().selectRow(sql);
        return row;
    }
    public Map<String, Object> IsDuplicate(String userId, String userPw) {
        String sql = String.format("SELECT * FROM `MEMBER` WHERE userId = '%s' AND password = '%s';",userId, userPw);
        Map<String, Object> row = Container.getDBConnection().selectRow(sql);
        return row;
    }


    public void join(String rsId, String pw) {
        String sql = String.format("INSERT INTO MEMBER (userId, password) \n" +
                "VALUES('%s', '%s');", rsId, pw);
        Container.getDBConnection().insert(sql);
    }
}
