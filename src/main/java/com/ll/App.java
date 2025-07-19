package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.system.SystemController;


public class App {
    ArticleController articleController;
    SystemController systemController;


    App(){
        DBConnection.DB_NAME = "hjDB";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";


        Container.getDBConnection().connect();

        articleController = new ArticleController();
        systemController = new SystemController();

    }
    public void run(){
        System.out.println("메인");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 로그아웃");
        System.out.println("상태");
        articleController.list();
        System.out.println("게시글 등록");



        while (true){
            System.out.print("명령) ");
            String command = Container.getSc().nextLine();
            Request request = new Request(Container.getSc().nextLine().trim());
            if(request.getActionCode().equals("등록")){
                articleController.write();
            }
        }


    }
}
