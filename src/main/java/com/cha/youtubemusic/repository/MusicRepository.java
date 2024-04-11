package com.cha.youtubemusic.repository;

import com.cha.youtubemusic.entity.MusicList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository -> 데이터베이스 엑세스를 하기 위한 어노테이션
@Repository
public interface MusicRepository extends JpaRepository<MusicList, Long> {

}
