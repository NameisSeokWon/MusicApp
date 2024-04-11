//HTTP 요청을 받아들여 MusicService 클래스의 비즈니스 로직을 호출, 처리하여 수행 결과를 알려주는 MusicController 클래스
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

// RestController -> RESTful 웹 서비스의 엔드포인트를 처리(XML 형식으로 반환할지, JSON으로 반환할지 등)
@RestController
// RequestMapping -> 특정 컨트롤러 메서드에 매핑. 여기서는 /api 경로 아래에 매핑됨
@RequestMapping("/api")
// RequiredArgsConstructor -> LomBook라이브러리 제공 어노테이션. 클래스에 선언된 final 필드를 기반으로 생성자를 자동으로 생성한다
// 필수적으로 주입되어야 하는 의존성을 자동으로 처리하는 어노테이션이다
@RequiredArgsConstructor
// CrossOrign -> 다른 Origin(클라이언트)에서의 요청을 허용하는 어노테이션으로 여기서 *(와일드카드)은 모든 클라이언트의 요청을 허락한다
@CrossOrigin("*")
public class MusicController {

    private final MusicService musicService;

    // PostMapping -> /musicList 경로에 대한 요청을 처리
    @PostMapping("/musicList")
    // MusicList 타입의 객체를 매개변수로 받아 들임
    // RequestBody HTTP에서 받아온 값을 MusicList의 musicList로 변환하여 전달
    // musicService 호출하여 musicList 객체를 처리
    public MusicList postMusicList(@RequestBody MusicList musicList){
        return musicService.postMusicList(musicList);
    }

    // GetMappin -> /musicLists 경로에 대한 요청을 Get 해옴
    @GetMapping("/musicLists")
    // List<MusicList> getAllMusicLists 타입으로 객체를 반환
    public List<MusicList> getAllMusicLists(){
        return musicService.getAllMusicLists();
    }

    // DeleteMappin -> /musicList/{id} 경로에서 HTTP DELETE 요청을 처리. id를 경로매개변수로 받아옴
    @DeleteMapping("/musicList/{id}")
    // 해당 id에 해당하는 음악 리스트를 삭제하는 로직
    public ResponseEntity<?> deleteMusicList(@PathVariable Long id){
        try {
            musicService.deleteMusicList(id);
            return new ResponseEntity<>("Music List number" + id + "deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/musicList/{id}")
    // 해당 id에 해당하는 음악 리스트를 조회하는 로직
    public ResponseEntity<?> getMusicListById(@PathVariable Long id){
        MusicList musicList = musicService.getMusicListById(id);
        if(musicList == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(musicList);
    }

    @PatchMapping("/musicList/{id}")
    // 해당 id에 해당하는 음악 리스트를 업데이트 하는 로직
    public ResponseEntity<?> updateMusicList(@PathVariable Long id, @RequestBody MusicList musicList){
        MusicList updateMusicList = musicService.updateMusicList(id, musicList);

        if(updateMusicList == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateMusicList);
    }
}
