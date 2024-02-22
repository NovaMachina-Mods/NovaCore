package novamachina.novacore.bootstrap;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import novamachina.novacore.core.IRegistry;
import novamachina.novacore.world.item.ItemDefinition;

public class NeoforgeItemRegistry implements IRegistry<ItemDefinition<?>> {
  public NeoforgeItemRegistry() {}

  public void register(ItemDefinition<?> entry) {
    Registry.register(BuiltInRegistries.ITEM, entry.getId(), entry.asItem());
  }
}
