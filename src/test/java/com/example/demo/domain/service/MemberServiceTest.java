package com.example.demo.domain.service;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.member.register;
import com.example.demo.domain.repository.MembersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;


class MemberServiceTest {
    MembersRepository membersRepository = new MembersRepository();
    MemberService memberService =new MemberService(membersRepository);

    @Test
    void 날짜계산() throws ParseException {

        //given
        MemberService memberService = new MemberService(membersRepository);
        Member member = new Member("aaa", register.주_3회);
        Member save = membersRepository.save(member);
        Long id = membersRepository.findById(member.getId()).getId();
        String registerDate = member.getRegisterDate();
        System.out.println("registerDate = " + registerDate);

        //when

        LocalDate parse = LocalDate.parse(registerDate, DateTimeFormatter.ISO_DATE);
        System.out.println("parse = " + parse);
        //then

        LocalDate localDate = memberService.registration_date(id);
        System.out.println("localDate = " + localDate);

        LocalDate date = member.getDate().plusMonths(1);
        System.out.println("date = " + date);

        long between = ChronoUnit.DAYS.between(localDate, date);
        System.out.println("between = " + between);

    }
}