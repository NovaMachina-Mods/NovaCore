package novamachina.novacore.util;

import net.minecraft.world.item.crafting.Ingredient;
import org.slf4j.Logger;

public class IngredientUtils {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(IngredientUtils.class);

  private IngredientUtils() {}

  /**
   * Check if Ingredient is a subset of another Ingredient
   *
   * @param test Ingredient that is in question
   * @param source Ingredient that contains all valid values
   * @return true if test is a subset of source, false otherwise
   */
  public static boolean isIngredientIn(Ingredient test, Ingredient source) {
    return test.items().anyMatch(stack -> source.acceptsItem(stack));
  }
}
