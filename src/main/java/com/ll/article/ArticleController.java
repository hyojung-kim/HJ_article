package com.ll.article;

import com.ll.Container;

import java.util.List;
import java.util.Map;


public class ArticleController {
    ArticleService articleService;
    String loginId;
    public ArticleController() {
        articleService = new ArticleService();
        loginId = "";
    }

    public void list() {
        List<Article> articleList = articleService.findAll();
        System.out.println("번호 / 제목 / 내용 / 작성자 / 날짜 / 시간");
        System.out.println("--------------------------------------------");
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s / %s / %s / %s\n",
                    article.getId(), article.getTitle(), article.getContent(), article.getMemberName(), article.getInsDate(), article.getInsTime());
        }
        System.out.println("--------------------------------------------");
    }

    public void write() {
        System.out.print("제목 : ");
        String title = Container.getSc().nextLine().trim();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine().trim();
        int memberId = 1; //임시 회원가입없음
        int id = articleService.create(title, content, memberId);
        System.out.printf("%d번 게시글이 등록되었습니다.\n", id);
    }

    public void join() {
        System.out.print("ID : ");
        String userId = Container.getSc().nextLine().trim();
        Map<String, Object> rs = articleService.IsDuplicate(userId);
        if (rs != null) {
            System.out.printf("%s는 중복된 ID 입니다.\n", rs.get("userId"));
            return;
        }
        System.out.print("PW : ");
        String PW = Container.getSc().nextLine().trim();
        articleService.join(userId, PW);
        System.out.printf("%s 가입완료.\n", userId);
    }

    public void login() {
        System.out.print("UserID : ");
        String userId = Container.getSc().nextLine().trim();
        System.out.print("UserPW : ");
        String userPw = Container.getSc().nextLine().trim();
        Map<String,Object> rs = articleService.IsDuplicate(userId, userPw);
        if(rs != null){
            loginId = (String)rs.get("UserId");
            System.out.println(rs.get("UserId") + "로그인");
            return;
        }
        System.out.println("로그인 실패");
    }

    public void loginSet() {
        articleService.loginSet(loginId);
    }
}
