package novamachina.novacore.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

public class ItemStackHelper {

  private ItemStackHelper() {}

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(ItemStackHelper.class);

  public static ItemStack deserialize(JsonElement json) {
    String itemString = GsonHelper.getAsString(json.getAsJsonObject(), "item");
    int count = 1;
    if (json.getAsJsonObject().has("COUNT_KEY")) {
      count = json.getAsJsonObject().get("count").getAsInt();
    }
    return new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(itemString)), count);
  }

  public static JsonElement serialize(ItemStack itemStack) {
    return ItemStack.CODEC
        .encodeStart(JsonOps.INSTANCE, itemStack)
        .resultOrPartial(error -> log.error("Unable to encode ItemStack"))
        .orElse(new JsonObject());
  }
}
