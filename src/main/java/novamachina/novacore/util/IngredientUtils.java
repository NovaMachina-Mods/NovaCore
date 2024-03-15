package novamachina.novacore.util;

import java.util.Arrays;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.slf4j.Logger;

public class IngredientUtils {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(IngredientUtils.class);

  private IngredientUtils() {}

  public static boolean areIngredientsEqual(Ingredient i1, Ingredient i2) {
    String item1;
    String item2;
    try {
      item1 = Arrays.toString(i1.getItems());
      item2 = Arrays.toString(i2.getItems());
    } catch (Exception e) {
      log.debug("Cannot compare ingredients");
      log.debug("Ingredient 1: {}", Arrays.toString(i1.getItems()));
      log.debug("Ingredient 2: {}", Arrays.toString(i2.getItems()));
      log.debug(e.getMessage());
      return false;
    }

    return item1.equals(item2);
  }

  /**
   * Check if Ingredient is a subset of another Ingredient
   *
   * @param test Ingredient that is in question
   * @param source Ingredient that contains all valid values
   * @return true if test is a subset of source, false otherwise
   */
  public static boolean isIngredientIn(Ingredient test, Ingredient source) {
    for (ItemStack stack : test.getItems()) {
      if (source.test(stack)) {
        return true;
      }
    }
    return false;
  }
}
