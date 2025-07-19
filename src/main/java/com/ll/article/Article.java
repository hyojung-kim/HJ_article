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

    public Article() {

    }

    public Article(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.title = (String)row.get("title");
        this.content = (String)row.get("content");
        this.MemberName = (String)row.get("MemberName");
        this.InsDate = (LocalDateTime)row.get("InsDate");

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
        return this.MemberName = MemberName;
    }

    public String getInsDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
        String ymdDate = InsDate.format(formatter);

        return ymdDate;
    }
}
