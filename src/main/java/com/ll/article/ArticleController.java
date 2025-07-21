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

        System.out.print("1. 자유게시판 2. 공지게시판 // 1 or 2: ");
        String Code = Container.getSc().nextLine().trim();
        int articleCode = _getIntParam(Code);
        if(articleCode == -1){
            System.out.println("잘못된 입력입니다.");
            return;
        }

        Article article = new Article(title, content, memberId, articleCode);
        int id = articleService.create(article);
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
        if(memberId != -1){
            System.out.println("로그아웃 해주세요!!!!!!!!!!!");
            return;
        }

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

    //memberId를 가져가서 유저이름 표시 + 로그인 상태 on/off 표시
    public void loginSet() {
        String rs = articleService.loginSet(memberId);
        System.out.println(rs); // "OFF"; or ("UserId") + " ON";
    }

    public void logout() {
        if(memberId == -1){
            System.out.println("로그인 해주세요!!!!!!!!!!!");
            return;
        }
        memberId = -1;
    }

    //게시글 데이터 가져오기
    public void FreeBoard() {
        int articleCode = 1;
        System.out.println("자유게시판");
        printBoard(articleCode);
    }

    public void Notice() {
        int articleCode = 2;
        System.out.println("공지게시판");
        printBoard(articleCode);
    }

    void printBoard(int articleCode) {
        List<Article> articleList = articleService.findAll(articleCode);
        System.out.println("번호 / 제목 / 내용 / 작성자 / 날짜 / 시간");
        System.out.println("--------------------------------------------");
        for (int i = articleList.size() - 1; i >= 0; i--) {
            Article article = articleList.get(i);
            System.out.printf("%d / %s / %s / %s / %s / %s\n",
                    article.getId(), article.getTitle(), article.getContent(), article.getMemberName(), article.getInsDate(), article.getInsTime());
        }
        System.out.println("--------------------------------------------");
    }

    private int _getIntParam(String id) {
        int defaultValue = -1;

        try {
            return Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

}
