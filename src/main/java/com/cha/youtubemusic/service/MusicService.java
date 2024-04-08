package com.cha.youtubemusic.service;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.repository.MusicRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicList postMusicList(MusicList musicList){
        return musicRepository.save(musicList);
    }

    public List<MusicList> getAllMusicLists(){
        return musicRepository.findAll();
    }

    public void deleteMusicList(Long id){
        if(!musicRepository.existsById(id)){
            throw new EntityNotFoundException("Music List number" + id + "not found");
        }

        musicRepository.deleteById(id);
    }
}
