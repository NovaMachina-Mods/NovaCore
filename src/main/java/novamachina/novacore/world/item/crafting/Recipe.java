package novamachina.novacore.world.item.crafting;

import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class Recipe implements net.minecraft.world.item.crafting.Recipe<Container> {

  public abstract void write(FriendlyByteBuf buffer);

  @Override
  public boolean matches(Container pContainer, Level pLevel) {
    return false;
  }

  @Override
  public ItemStack assemble(Container pContainer, RegistryAccess pRegistryAccess) {
    return ItemStack.EMPTY;
  }

  @Override
  public boolean canCraftInDimensions(int pWidth, int pHeight) {
    return true;
  }

  @Override
  public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
    return ItemStack.EMPTY;
  }
}
