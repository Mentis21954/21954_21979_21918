package com.springboot.app.Repository;


import com.springboot.app.Entity.RecommendationLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationLetterRepository extends JpaRepository <RecommendationLetter, Long> {

    @Query("SELECT u FROM RecommendationLetter u WHERE u.id = :id")
    public RecommendationLetter getRecommendationLetterById(@Param("id") String id);
}
