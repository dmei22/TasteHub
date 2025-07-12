package nl.miwnn.ch16.tastehub.TasteHub.repositories;

import nl.miwnn.ch16.tastehub.TasteHub.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
