package novamachina.novacore.core.registries;

import java.util.function.Supplier;
import net.minecraft.world.item.crafting.RecipeSerializer;
import novamachina.novacore.world.item.crafting.AbstractRecipe;
import novamachina.novacore.world.item.crafting.RecipeSerializerDefinition;

public class RecipeSerializerRegistry
    extends AbstractRegistry<RecipeSerializerDefinition<? extends AbstractRecipe>> {

  public RecipeSerializerRegistry(String modId) {
    super(modId);
  }

  public RecipeSerializerDefinition<? extends AbstractRecipe> register(
      String shortId, Supplier<? extends RecipeSerializer<? extends AbstractRecipe>> supplier) {
    RecipeSerializer<? extends AbstractRecipe> instance = supplier.get();
    RecipeSerializerDefinition<? extends AbstractRecipe> definition =
        new RecipeSerializerDefinition<>(id(shortId), instance);
    this.register(definition);
    return definition;
  }
}
