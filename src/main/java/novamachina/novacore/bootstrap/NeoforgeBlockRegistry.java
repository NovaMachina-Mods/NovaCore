package novamachina.novacore.bootstrap;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import novamachina.novacore.core.IRegistry;
import novamachina.novacore.world.level.block.BlockDefinition;

public class NeoforgeBlockRegistry implements IRegistry<BlockDefinition<?>> {
  public NeoforgeBlockRegistry() {}

  public void register(BlockDefinition<?> entry) {
    Registry.register(BuiltInRegistries.BLOCK, entry.getId(), entry.block());
  }
}
