package novamachina.novacore.core.registries;

import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import novamachina.novacore.world.item.ItemDefinition;
import novamachina.novacore.world.level.block.BlockDefinition;

public class BlockRegistry extends AbstractRegistry<BlockDefinition<? extends Block>> {

  public BlockRegistry(String modId) {
    super(modId);
  }

  public <T extends Block> BlockDefinition<T> block(
      String englishName, String shortId, Supplier<T> blockSupplier) {
    T block = blockSupplier.get();
    BlockItem item = new BlockItem(block, new Item.Properties());
    return blockDefinition(englishName, id(shortId), block, item);
  }

  public <T extends Block> BlockDefinition<T> block(
      String englishName, String shortId, Supplier<T> blockSupplier, ItemDefinition.ItemType type) {
    T block = blockSupplier.get();
    BlockItem item = new BlockItem(block, new Item.Properties());
    return blockDefinition(englishName, id(shortId), block, item, type);
  }

  public <T extends Block> BlockDefinition<T> burnableBlock(
      String englishName, String shortId, Supplier<T> blockSupplier) {
    T block = blockSupplier.get();
    BlockItem item =
        new BlockItem(block, new Item.Properties()) {
          @Override
          public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
            return 400;
          }
        };
    return blockDefinition(englishName, id(shortId), block, item);
  }

  private <T extends Block> BlockDefinition<T> blockDefinition(
      String englishName, ResourceLocation id, T block, BlockItem item) {
    BlockDefinition<T> definition = new BlockDefinition<>(englishName, id, block, item);
    this.register(definition);
    return definition;
  }

  private <T extends Block> BlockDefinition<T> blockDefinition(
      String englishName,
      ResourceLocation id,
      T block,
      BlockItem item,
      ItemDefinition.ItemType type) {
    BlockDefinition<T> definition = new BlockDefinition<>(englishName, id, block, item, type);
    this.register(definition);
    return definition;
  }
}