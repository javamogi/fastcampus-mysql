package com.example.fastcampusmysql.application.controller;

import com.example.fastcampusmysql.application.usacase.CreateFollowMemberUsacase;
import com.example.fastcampusmysql.application.usacase.GetFollowingMemberUsacase;
import com.example.fastcampusmysql.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/follow")
public class FollowController {
    private final CreateFollowMemberUsacase createFollowMemberUsacase;

    private final GetFollowingMemberUsacase getFollowingMemberUsacase;

    @PostMapping("/{fromId}/{toId}")
    public void create(@PathVariable Long fromId, @PathVariable Long toId){
        createFollowMemberUsacase.execute(fromId, toId);
    }

    @GetMapping("/members/{fromId}/")
    public List<MemberDto> getFollowings(@PathVariable Long fromId){
        return getFollowingMemberUsacase.execute(fromId);
    }
}
