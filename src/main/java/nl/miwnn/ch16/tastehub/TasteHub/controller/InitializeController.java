package nl.miwnn.ch16.tastehub.TasteHub.controller;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import nl.miwnn.ch16.tastehub.TasteHub.model.Recipe;
import nl.miwnn.ch16.tastehub.TasteHub.repositories.RecipeRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class InitializeController {

    private final RecipeRepository recipeRepository;

    public InitializeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @EventListener
    private void seed(ContextRefreshedEvent ignoredEvent) {
        if (recipeRepository.count() == 0) {
            initializeDB();
        }
    }

    private void initializeDB() {
        try {
            loadRecipes();
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    private void loadRecipes() throws IOException, CsvValidationException {

        try (CSVReader reader = new CSVReader(new InputStreamReader(
                new ClassPathResource("/example_data/recipes.csv").getInputStream()))) {

            reader.skip(1);

            for (String[] recipeLine : reader) {
                Recipe recipe = new Recipe();
                recipe.setRecipeName(recipeLine[0]);
                recipe.setDescription(recipeLine[1]);
                recipe.setIngredients(recipeLine[2]);
                recipe.setInstructions(recipeLine[3]);

                recipeRepository.save(recipe);
            }
        }
    }

}
