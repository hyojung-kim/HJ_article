package com.ll.member;

import com.ll.Container;

import java.util.Map;

public class MemberController {
    MemberService memberService;
    public MemberController(){
        memberService = new MemberService();
    }

    //회원가입
    public void join() {
        if(Container.getMemberId() != -1){
            System.out.println("회원 가입 시 로그아웃 할 것!");
            return;
        }
        System.out.print("ID : ");
        String userId = Container.getSc().nextLine().trim();
        Map<String, Object> rs = memberService.IsDuplicate(userId);
        if (!rs.isEmpty()) {
            System.out.printf("%s는 중복된 ID 입니다.\n", rs.get("userId"));
            return;
        }
        System.out.print("PW : ");
        String PW = Container.getSc().nextLine().trim();

        Member member = new Member(userId, PW);
        memberService.join(member);
        System.out.printf("%s 가입완료.\n", userId);
    }

    //로그인
    public void login() {
        if(Container.getMemberId() != -1){
            System.out.println("로그아웃 해주세요!!!!!!!!!!!");
            return;
        }

        System.out.print("UserID : ");
        String userId = Container.getSc().nextLine().trim();
        System.out.print("UserPW : ");
        String userPw = Container.getSc().nextLine().trim();
        Map<String,Object> rs = memberService.IsDuplicate(userId, userPw);
        if(!rs.isEmpty()){
            Container.setMemberId((int)rs.get("id"));
            System.out.println(rs.get("userId") + "로그인");
            return;
        }
        System.out.println("로그인 실패");
    }

    //memberId를 가져가서 유저이름 표시 + 로그인 상태 on/off 표시
    public void loginSet() {
        String rs = memberService.loginSet(Container.getMemberId());
        System.out.println(rs); // "OFF"; or ("UserId") + " ON";
    }

    public void logout() {
        if(Container.getMemberId() == -1){
            System.out.println("로그인 해주세요!!!!!!!!!!!");
            return;
        }
        Container.setMemberId(-1);
    }


}
