package novamachina.novacore.world.item.crafting;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;

public abstract class RecipeSerializer<R extends Recipe<?>>
    implements net.minecraft.world.item.crafting.RecipeSerializer<R> {

  public R fromJson(ResourceLocation recipeId, JsonObject json) throws NullPointerException {
    return readFromJson(recipeId, json);
  }

  protected abstract R readFromJson(ResourceLocation recipeId, JsonObject json);
}
