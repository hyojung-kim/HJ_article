package com.ll.member;

import com.ll.Container;

import java.util.Map;

public class MemberRepository {
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

    public Map<String, Object> getUserId(int memberId) {
        String sql = String.format("SELECT id, userId FROM `member` WHERE id = %d;", memberId);
        Map<String, Object> row = Container.getDBConnection().selectRow(sql);
        return row;
    }

}
