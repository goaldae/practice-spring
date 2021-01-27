package springTest.data;

import springTest.Ingredient;

import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository {
	Iterable<Ingredient> findAll();
	Ingredient findById(String id);
	Ingredient save(Ingredient ingredient);
}
