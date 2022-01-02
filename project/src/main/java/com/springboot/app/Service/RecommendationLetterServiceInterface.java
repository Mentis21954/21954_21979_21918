package com.springboot.app.Service;

import com.springboot.app.Entity.RecommendationLetter;

import java.util.List;

public interface RecommendationLetterServiceInterface {
    public List<RecommendationLetter> listAll() ;

    public void save(RecommendationLetter letter) throws Exception;

    public RecommendationLetter get(Long id) ;

    public void delete(Long id) ;
}
