package novamachina.novacore.client.renderer.blockentity;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public abstract class BlockEntityRenderer<T extends BlockEntity>
    implements net.minecraft.client.renderer.blockentity.BlockEntityRenderer<T> {

  protected BlockEntityRenderer() {
    super();
  }

  // Added from ExCompressum, thanks to Blay09 for that piece of code :D
  public static BlockState getStateFromItemStack(ItemStack itemStack) {
    if (itemStack.getItem() instanceof BlockItem blockItem) {
      Block block = blockItem.getBlock();
      try {
        return block.defaultBlockState();
      } catch (Exception e) {
        // In case of weirdness, don't crash! Just fallback to default.
      }
      return block.defaultBlockState();
    }
    return Blocks.AIR.defaultBlockState();
  }
}
