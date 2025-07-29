package com.ll.member;

import java.util.Map;

public class MemberService {
    MemberRepository memberRepository;
    public MemberService(){
        memberRepository = new MemberRepository();
    }

    public Map<String, Object> IsDuplicate(String userId) {
        return memberRepository.IsDuplicate(userId);
    }

    public Map<String,Object> IsDuplicate(String userId, String userPw) {
        Map<String,Object> rs = memberRepository.IsDuplicate(userId, userPw);
        return rs;
    }

    public void join(String rsId, String PW) {
        memberRepository.join(rsId, PW);
    }

    public String loginSet(int memberId) {
        Map<String,Object> rs = memberRepository.getUserId(memberId);
        if(rs.isEmpty()){
            return "OFF";
        }
        return rs.get("userId") + " ON";
    }
}
