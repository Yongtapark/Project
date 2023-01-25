package com.example.demo.domain.repository;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.payment;
import com.example.demo.domain.member.register;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class MembersRepository {
    private static final Map<Long, Member> store= new HashMap<>();
    private static long sequence =0L;



    public Member save(Member member){
        member.setId(sequence++);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Member member){
        Member savedmember = store.get(id);
        savedmember.setMemberName(member.getMemberName());
        savedmember.setDays(member.getDays());
        savedmember.setRegisterDate(member.getRegisterDate());
        savedmember.setPaymentDate(member.getPaymentDate());
    }




    public void clearStore(){
        store.clear();
    }
}
