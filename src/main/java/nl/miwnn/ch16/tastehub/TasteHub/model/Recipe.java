package nl.miwnn.ch16.tastehub.TasteHub.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long recipeId;

    private String recipeName;

    @ElementCollection
    private List<String> ingredients;

    private String description;

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
