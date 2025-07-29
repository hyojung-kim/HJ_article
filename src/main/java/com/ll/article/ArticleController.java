package com.ll.article;

import com.ll.Container;

import java.util.List;


public class ArticleController {
    ArticleService articleService;
    //컨트롤러 생성
    public ArticleController() {
        articleService = new ArticleService();
    }
  
    //게시글 작성하기
    public void write() {

        if(Container.getMemberId() == -1){
            System.out.println("로그인 해주세요.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            return;
        }
        System.out.print("1. 자유게시판 2. 공지게시판 // 1 or 2: ");
        String Code = Container.getSc().nextLine().trim();
        int articleCode = _getIntParam(Code);
        if(articleCode == -1){
            System.out.println("잘못된 입력입니다.");
            return;
        }
        System.out.print("제목 : ");
        String title = Container.getSc().nextLine().trim();
        System.out.print("내용 : ");
        String content = Container.getSc().nextLine().trim();

        Article article = new Article(title, content, Container.getMemberId(), articleCode);
        int id = articleService.create(article);
        System.out.printf("%d번 게시글이 등록되었습니다.\n", id);
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
