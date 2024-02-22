package novamachina.novacore.data.recipes;

import java.util.Collections;
import java.util.List;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

public abstract class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {

  protected RecipeProvider(PackOutput packOutput) {
    super(packOutput);
  }

  @Override
  protected void buildRecipes(RecipeOutput recipeOutput) {
    getSubProviders().forEach(subProvider -> subProvider.addRecipes(recipeOutput));
  }

  protected List<ISubRecipeProvider> getSubProviders() {
    return Collections.emptyList();
  }
}
