package com.ll.member;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Member {
    private int id;
    private int memberId;
    private String memberName;
    private String pw;
    private LocalDateTime InsDate;

    public Member(String userId, String pw) {
        this.memberName = userId;
        this.pw = pw;
    }


    int getId() {
        return this.id;
    }
    public int getMemberId() {
        return this.memberId;
    }
    public String getMemberName() {
        return this.memberName;
    }
    public String getPw() {
        return this.pw;
    }
    public String getInsDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
        return InsDate.format(formatter);
    }
    public String getInsTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H시 m분");
        return InsDate.format(formatter);
    }

}