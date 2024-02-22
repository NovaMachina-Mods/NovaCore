package novamachina.novacore.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import java.util.Optional;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.util.JsonUtils;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import org.slf4j.Logger;

public class FluidStackUtils {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(FluidStackUtils.class);

  private FluidStackUtils() {}

  public static FluidStack deserialize(JsonObject jsonObject) {
    Fluid fluid =
        BuiltInRegistries.FLUID.get(
            new ResourceLocation(GsonHelper.getAsString(jsonObject, "fluid")));
    FluidStack fluidStack = new FluidStack(fluid, FluidType.BUCKET_VOLUME);
    if (GsonHelper.isValidNode(jsonObject, "tag")) {
      fluidStack.setTag(JsonUtils.readNBT(jsonObject, "tag"));
    }
    fluidStack.setAmount(jsonObject.get("amount").getAsInt());
    return fluidStack;
  }

  public static Optional<JsonElement> serialize(FluidStack fluidStack) {
    return FluidStack.CODEC
        .encodeStart(JsonOps.INSTANCE, fluidStack)
        .resultOrPartial(error -> log.error("Unable to encode FluidStack"));
  }
}
