package com.cha.youtubemusic.controller;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.service.MusicService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MusicController {

    private final MusicService musicService;

    @PostMapping("/musicList")
    public MusicList postMusicList(@RequestBody MusicList musicList){
        return musicService.postMusicList(musicList);
    }

    @GetMapping("/musicLists")
    public List<MusicList> getAllMusicLists(){
        return musicService.getAllMusicLists();
    }

    @DeleteMapping("/musicList/{id}")
    public ResponseEntity<?> deleteMusicList(@PathVariable Long id){
        try {
            musicService.deleteMusicList(id);
            return new ResponseEntity<>("Music List number" + id + "deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
