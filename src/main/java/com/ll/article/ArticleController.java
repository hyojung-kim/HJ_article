package com.ll.article;

import com.ll.Container;

import java.util.List;
import java.util.Map;


public class ArticleController {
    ArticleService articleService;
    int memberId;
    //컨트롤러 생성
    public ArticleController() {
        articleService = new ArticleService();
        memberId = -1; // 초기화용
    }
    //게시글 데이터 가져오기
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
    //게시글 작성하기
    public void write() {
        if(memberId == -1){
            System.out.println("로그인 해주세요.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return;
        }
        System.out.print("제목 : ");
        String title = Container.getSc().nextLine().trim();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine().trim();
        int id = articleService.create(title, content, memberId);
        System.out.printf("%d번 게시글이 등록되었습니다.\n", id);
    }
    //회원가입
    public void join() {
        System.out.print("ID : ");
        String userId = Container.getSc().nextLine().trim();
        Map<String, Object> rs = articleService.IsDuplicate(userId);
        if (!rs.isEmpty()) {
            System.out.printf("%s는 중복된 ID 입니다.\n", rs.get("userId"));
            return;
        }
        System.out.print("PW : ");
        String PW = Container.getSc().nextLine().trim();
        articleService.join(userId, PW);
        System.out.printf("%s 가입완료.\n", userId);
    }
    //로그인
    public void login() {
        System.out.print("UserID : ");
        String userId = Container.getSc().nextLine().trim();
        System.out.print("UserPW : ");
        String userPw = Container.getSc().nextLine().trim();
        Map<String,Object> rs = articleService.IsDuplicate(userId, userPw);
        if(!rs.isEmpty()){
            memberId = (int)rs.get("id");
            System.out.println(rs.get("userId") + "로그인");
            return;
        }
        System.out.println("로그인 실패");
    }
    //로그인 상태 on/off 표시
    public void loginSet() {
        String rs = articleService.loginSet(memberId);
        System.out.println(rs); // "OFF"; or ("UserId") + " ON";
    }
}
