package novamachina.novacore.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

public class ItemStackHelper {

  private ItemStackHelper() {}

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(ItemStackHelper.class);

  public static ItemStack deserialize(JsonElement json) {
    return ItemStack.CODEC
        .parse(JsonOps.INSTANCE, json)
        .resultOrPartial(error -> log.error("Unable to parse ItemStack: {}", error))
        .orElse(ItemStack.EMPTY);
  }

  public static JsonElement serialize(ItemStack itemStack) {
    return ItemStack.CODEC
        .encodeStart(JsonOps.INSTANCE, itemStack)
        .resultOrPartial(error -> log.error("Unable to encode ItemStack: {}", error))
        .orElse(new JsonObject());
  }
}
