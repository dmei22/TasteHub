package nl.miwnn.ch16.tastehub.TasteHub.controller;

import nl.miwnn.ch16.tastehub.TasteHub.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    private String showAllRecipes(Model dataModel) {
        dataModel.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
    }

}
