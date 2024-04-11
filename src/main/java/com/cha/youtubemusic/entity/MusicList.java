// Youtube API 연동 전 데이터 베이스로 화면에서 받아오는 값을 확인하기 위한 엔티티
package com.cha.youtubemusic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//Entity -> JPA에서 사용하는 어노테이션으로 데이터베이스 테이블과 매핑되는 자바객체
@Entity
//Data -> LomBook에서 제공하는 어노테이션 getter,setter,equals 등의 메서드를 생성해주는 기능 제공
@Data
public class MusicList {
    //ID -> JPA에서 제공하는 어노테이션으로 primary key 지정에 사용된다. @ID 바로 밑에 선언된 변수가 primary key 가 된다 여기서 는 id가 primary key 이다
    @Id
    //GeneratedValue -> JPA 어노테이션으로 엔티티의 특정 필드가 자동으로 생성되는 값을 가질 때 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String singer;

    private String title;

    private String request_time;

}
