package nl.miwnn.ch16.tastehub.TasteHub.controller;


import nl.miwnn.ch16.tastehub.TasteHub.repositories.RecipeRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

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

    }

}
