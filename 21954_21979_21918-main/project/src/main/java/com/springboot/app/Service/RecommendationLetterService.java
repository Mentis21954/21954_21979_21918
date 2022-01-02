package com.springboot.app.Service;

import com.springboot.app.Entity.RecommendationLetter;
import com.springboot.app.Repository.RecommendationLetterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationLetterService implements RecommendationLetterServiceInterface{

    RecommendationLetterRepository letterRepository;

    @Override
    public List<RecommendationLetter> listAll() {
        return letterRepository.findAll();
    }

    @Override
    public void save(RecommendationLetter letter) throws Exception {
        this.letterRepository.save(letter);
    }

    @Override
    public RecommendationLetter get(Long id) {
        return letterRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        this.letterRepository.deleteById(id);
    }
}
