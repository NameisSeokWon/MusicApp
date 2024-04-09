package com.cha.youtubemusic.service;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.repository.MusicRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public MusicList getMusicListById(Long id){
        return musicRepository.findById(id).orElse(null);
    }

    public MusicList updateMusicList(Long id, MusicList musicList){
        Optional<MusicList> optionalMusicList = musicRepository.findById(id);
        if(optionalMusicList.isPresent()){
            MusicList existingMusicList = optionalMusicList.get();
            existingMusicList.setSinger(musicList.getSinger());
            existingMusicList.setTitle(musicList.getTitle());

            return musicRepository.save(existingMusicList);
        }
        return null;
    }
}
