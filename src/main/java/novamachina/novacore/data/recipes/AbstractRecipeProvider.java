package novamachina.novacore.data.recipes;

import java.util.Collections;
import java.util.List;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

public abstract class AbstractRecipeProvider extends RecipeProvider {

  protected AbstractRecipeProvider(PackOutput packOutput) {
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
