package com.example.demo.domain.service;

import com.example.demo.domain.member.Member;
import com.example.demo.domain.repository.MembersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MembersRepository membersRepository;



    public LocalDate registration_date(Long memberId) throws ParseException {
        Member savedMember = membersRepository.findById(memberId);
       String registerDate = savedMember.getPaymentDate();
        LocalDate parsedDate = LocalDate.parse(registerDate, DateTimeFormatter.ISO_DATE);

        return parsedDate;
    }




}
