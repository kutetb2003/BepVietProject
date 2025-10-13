package com.bepviet.repository;

import com.bepviet.entity.RecipeEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface RecipeRepository extends ListCrudRepository<RecipeEntity, Long> {
}
