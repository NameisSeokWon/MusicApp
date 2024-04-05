package com.cha.youtubemusic.repository;

import com.cha.youtubemusic.entity.MusicList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<MusicList, Long> {
}
