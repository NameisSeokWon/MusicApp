package com.cha.youtubemusic.controller;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.service.MusicService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @GetMapping("/musicList/{id}")
    public ResponseEntity<?> getMusicListById(@PathVariable Long id){
        MusicList musicList = musicService.getMusicListById(id);
        if(musicList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(musicList);
    }

    @PatchMapping("/musicList/{id}")
    public ResponseEntity<?> updateMusicList(@PathVariable Long id, @RequestBody MusicList musicList){
        MusicList updateMusicList = musicService.updateMusicList(id, musicList);

        if(updateMusicList == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateMusicList);
    }
}
