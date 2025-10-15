package com.bepviet.repository;

import com.bepviet.entity.RecipeEntity;
import com.bepviet.enums.Difficulty;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends ListCrudRepository<RecipeEntity, Long>{
    List<RecipeEntity> findDistinctByNameOrDifficulty(String name, Difficulty difficulty);
}
