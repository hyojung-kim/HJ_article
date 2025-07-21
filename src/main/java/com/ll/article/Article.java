package com.ll.article;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Article {
    private int id;
    private String title;
    private String content;
    private String MemberName;
    private LocalDateTime InsDate;
    private int articleCode;
    private int memberId;

    public Article(String title, String content, int memberId, int articleCode) {
        this.title = title;
        this.memberId = memberId;
        this.content = content;
        this.articleCode = articleCode;


    public Article(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
        this.MemberName = (String)row.get("MemberName");
        this.InsDate = (LocalDateTime)row.get("InsDate");
        this.articleCode = (int)row.get("articleCode");
    }

    int getId() {
        return this.id;
    }

    String getTitle() {
        return this.title;
    }

    String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMemberName() {
        return this.MemberName;
    }
    public int getMemberId() {
        return this.memberId;
    }

    public String getInsDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
        return InsDate.format(formatter);
    }
    public String getInsTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H시 m분");
        return InsDate.format(formatter);
    }

    public int getArticleCode() {
        return this.articleCode;
    }

}
