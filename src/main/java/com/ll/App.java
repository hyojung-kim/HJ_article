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

        String command = Container.getSc().nextLine().trim();
        while(true) {
            System.out.println("====CLI BOARD START====");
        }


        //작업1 !!!!!!!!!!!!!
        //작업2 !!!!!!!!!!!!!
        //작업3 !!!!!!!!!!!!!


    }
}
