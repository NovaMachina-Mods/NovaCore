package novamachina.novacore.world.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public abstract class AbstractRecipeSerializer<R extends Recipe<?>> implements RecipeSerializer<R> {

  public R fromJson(ResourceLocation recipeId, JsonObject json) throws NullPointerException {
    return readFromJson(recipeId, json);
  }

  protected abstract R readFromJson(ResourceLocation recipeId, JsonObject json);
}
