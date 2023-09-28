package novamachina.novacore.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemStackHelper {
  public static ItemStack deserialize(JsonElement json) {
    String itemString = GsonHelper.getAsString(json.getAsJsonObject(), "item");
    int count = 1;
    if (json.getAsJsonObject().has("COUNT_KEY")) {
      count = json.getAsJsonObject().get("count").getAsInt();
    }
    return new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemString)), count);
  }

  public static JsonElement serialize(ItemStack itemStack) {
    if (itemStack == null) {
      return JsonNull.INSTANCE;
    }
    JsonObject jsonObject = new JsonObject();
    if (ForgeRegistries.ITEMS.getKey(itemStack.getItem()) != null) {
      jsonObject.addProperty("item", ForgeRegistries.ITEMS.getKey(itemStack.getItem()).toString());
    }
    jsonObject.addProperty("count", itemStack.getCount());
    return jsonObject;
  }
}
