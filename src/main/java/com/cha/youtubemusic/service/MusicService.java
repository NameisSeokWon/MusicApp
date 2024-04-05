package com.cha.youtubemusic.service;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicList postMusicList(MusicList musicList){
        return musicRepository.save(musicList);
    }
}
