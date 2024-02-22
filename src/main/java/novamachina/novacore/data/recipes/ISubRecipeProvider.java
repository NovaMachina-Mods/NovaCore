package novamachina.novacore.data.recipes;

import net.minecraft.data.recipes.RecipeOutput;

public interface ISubRecipeProvider {
  void addRecipes(RecipeOutput consumer);
}
