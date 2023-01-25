package com.example.demo.domain.repository;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.register;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MembersRepositoryTest {
    MembersRepository membersRepository = new MembersRepository();

    @AfterEach
    void afterEach(){
        membersRepository.clearStore();
    }

    @Test
    void save(){
        //when
        Member member1=new Member("박용타", register.주_3회);
        Member member2 = new Member("가나박", register.주_7회);

        //then
        Member savedMember = membersRepository.save(member1);
        Member savedMember2 = membersRepository.save(member2);

        //given
        Member findMember = membersRepository.findById(member1.getId());
        Member findMember2 = membersRepository.findById(member2.getId());
        Assertions.assertThat(savedMember.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(savedMember2.getId()).isEqualTo(findMember2.getId());
        System.out.println("findMember.getMemberName() = " + findMember.getMemberName());
        System.out.println("findMember2 = " + findMember2.getMemberName());

    }
    @Test
    void findAll(){
        Member member1 = new Member("가나다",register.주_7회);
        Member member2 = new Member("가나박", register.주_3회);

        membersRepository.save(member1);
        membersRepository.save(member2);

        //when
        List<Member> result = membersRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result).contains(member1,member2);
    }

    @Test
    void updateItem(){
        Member member = new Member("박용타", register.주_7회);

        Member saveMember = membersRepository.save(member);
        Long memberId = saveMember.getId();

        //when
        Member updateMember = new Member("김재현", register.주_3회);
        membersRepository.update(memberId,updateMember);
        Member updatedMember = membersRepository.findById(memberId);
        //then
        Assertions.assertThat(member).isEqualTo(updatedMember);
        Assertions.assertThat(member.getMemberName()).isEqualTo(updatedMember.getMemberName());
        Assertions.assertThat(member.getMemberName()).isEqualTo("김재현");
        Assertions.assertThat(member.getDays()).isEqualTo(register.주_7회);




    }


    
   
    

}