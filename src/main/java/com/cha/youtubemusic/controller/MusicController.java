package com.cha.youtubemusic.controller;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService musicService;

    @PostMapping("/musicList")
    public MusicList postMusicList(@RequestBody MusicList musicList){
        return musicService.postMusicList(musicList);
    }
}
