package com.example.demo.domain.member;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter @Setter
public class Member {

    LocalDate date = LocalDate.now();

    private Long id;

    private String memberName;

    private register days;
    private String registerDate =date.toString();
    private String paymentDate =date.toString();

    private payment payStatement;

    private LocalDate leftDate = date.plusMonths(1);

   private long between = ChronoUnit.DAYS.between(date, leftDate);





    public Member() {
    }

    public Member(String memberName, register days) {
        this.memberName = memberName;
        this.days = days;
    }
}
