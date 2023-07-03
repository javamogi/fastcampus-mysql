package com.example.fastcampusmysql.domain.member.entity;

import com.example.fastcampusmysql.util.MemberFixFactory;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    @DisplayName("회원은 닉네임을 변경할 수 있다.")
    public void testChangeName(){
//        LongStream.range(0, 10)
//                .mapToObj(i -> MemberFixFactory.create(i))
//                .forEach(member -> {
//                    System.out.println(member.getNickname());
//                });

        var member = MemberFixFactory.create();
        var expected = "pnu";
        member.changeNickname(expected);

        Assertions.assertEquals(expected, member.getNickname());
    }

    @Test
    @DisplayName("회원의 닉네임은 10자를 초과할 수 없다.")
    public void testNicknameMaxLength(){
        var member = MemberFixFactory.create();
        var maxLengthName = "pnupnupnupnu";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            member.changeNickname(maxLengthName);
        });
    }

}