package com.study.sns.repository;

import com.study.sns.model.entity.LikeEntity;
import com.study.sns.model.entity.PostEntity;
import com.study.sns.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LikeEntityRepository extends JpaRepository<LikeEntity, Integer> {
    Optional<LikeEntity> findByUserAndPost(UserEntity user, PostEntity postEntity);

    @Query(value = "SELECT COUNT(entity) FROM LikeEntity entity WHERE entity.post=:post")
    Integer countByPost(PostEntity post);
    List<LikeEntity> findAllByPost(PostEntity postEntity);
}
