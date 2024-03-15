package novamachina.novacore.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import java.util.Optional;
import net.neoforged.neoforge.fluids.FluidStack;
import org.slf4j.Logger;

public class FluidStackUtils {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(FluidStackUtils.class);

  private FluidStackUtils() {}

  public static FluidStack deserialize(JsonObject jsonObject) {
    return FluidStack.CODEC
        .parse(JsonOps.INSTANCE, jsonObject)
        .resultOrPartial(error -> log.error("Unable to parse FluidStack: {}", error))
        .orElse(FluidStack.EMPTY);
  }

  public static Optional<JsonElement> serialize(FluidStack fluidStack) {
    return FluidStack.CODEC
        .encodeStart(JsonOps.INSTANCE, fluidStack)
        .resultOrPartial(error -> log.error("Unable to encode FluidStack: {}", error));
  }
}
