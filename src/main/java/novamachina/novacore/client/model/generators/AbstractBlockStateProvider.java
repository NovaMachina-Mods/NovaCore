package novamachina.novacore.client.model.generators;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public abstract class AbstractBlockStateProvider extends BlockStateProvider {

  protected static final String PARTICLE_TAG = "particle";

  protected AbstractBlockStateProvider(
      PackOutput output, String modId, ExistingFileHelper exFileHelper) {
    super(output, modId, exFileHelper);
  }

  protected void basicBlock(Block block) {
    simpleItemBlock(block, cubeAll(block));
  }

  protected void registerFluid(Fluid fluid, ResourceLocation stillTexture) {
    ResourceLocation resourceLocation = BuiltInRegistries.FLUID.getKey(fluid);
    ModelFile model =
        models()
            .getBuilder("block/" + resourceLocation.getPath())
            .texture(PARTICLE_TAG, stillTexture);
    getVariantBuilder(fluid.defaultFluidState().createLegacyBlock().getBlock())
        .partialState()
        .setModels(new ConfiguredModel(model));
  }

  protected void simpleItemBlock(Block block, ModelFile modelFile) {
    simpleBlock(block, modelFile);
    simpleBlockItem(block, modelFile);
  }

  protected String getRegistryName(Block b) {
    return BuiltInRegistries.BLOCK.getKey(b).toString();
  }
}
