//MusicController 에서 호출하는 비즈니스 로직을 담당하는 MusicService 클래스
package com.cha.youtubemusic.service;

import com.cha.youtubemusic.entity.MusicList;
import com.cha.youtubemusic.repository.MusicRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service -> 이 클래스가 서비스 컴포넌트 임을 지정하는 어노테이션
@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;
    //MusicRepository 인터페이스를 필드로 선언 JPA가 구현체를 제공 해 줌

    public MusicList postMusicList(MusicList musicList) {
        return musicRepository.save(musicList);
    }
    //postMusicList 뮤직리스트를 저장하는 기능

    public List<MusicList> getAllMusicLists(){
        return musicRepository.findAll();
    }
    //getAllMusicLists 모든 뮤직리스트를 조회 하는 기능
    public void deleteMusicList(Long id){
        if(!musicRepository.existsById(id)){
            throw new EntityNotFoundException("Music List number" + id + "not found");
        }

        musicRepository.deleteById(id);
    }
    //deleteMusicList 해당 id의 음악리스트 delete 처리 기능

    public MusicList getMusicListById(Long id){
        return musicRepository.findById(id).orElse(null);
    }
    //getMusicListById 해당 id의 해당 음악리스트 조회 할 때 처리 기능

    public MusicList updateMusicList(Long id, MusicList musicList){
        // nullpointexepction 방지를 위해 Optional 클래스 사용 선언된 변수가 null 인지 아닌지 판별 해 줌. 주로 null이 반환 될 수 있는 경우의 처리에 사용
        Optional<MusicList> optionalMusicList = musicRepository.findById(id);
        if(optionalMusicList.isPresent()){
            MusicList existingMusicList = optionalMusicList.get();
            existingMusicList.setSinger(musicList.getSinger());
            existingMusicList.setTitle(musicList.getTitle());

            return musicRepository.save(existingMusicList);
        }
        return null;
    }//updateMusicList 뮤직리스트에 음악을 업데이트 할 때 처리 기능
}
