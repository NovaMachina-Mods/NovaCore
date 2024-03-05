package novamachina.novacore.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import novamachina.novacore.util.StringUtils;
import novamachina.novacore.world.item.ItemDefinition;
import novamachina.novacore.world.level.block.BlockDefinition;

public abstract class AbstractLangGenerator extends LanguageProvider {

  private final String itemLang;
  private final String blockLang;
  private final String fluidLang;

  protected AbstractLangGenerator(PackOutput output, String modId, String locale) {
    super(output, modId, locale);
    this.itemLang = String.format("item.%s.", modId);
    this.blockLang = String.format("block.%s.", modId);
    this.fluidLang = String.format("fluid_type.%s.", modId);
  }

  protected String properNaming(String item) {
    return StringUtils.capitalize(item.replace("_", " "));
  }

  /**
   * @param item need item to be used in lang file, auto names it + capitalize it fully
   */
  protected void addItemAutoName(String item) {
    add(itemLang + item, properNaming(item));
  }

  protected void addItemName(ItemDefinition<? extends Item> definition) {
    add(itemLang + definition.getId().getPath(), definition.getEnglishName());
  }

  /**
   * @param item need item to be used in lang file, auto names it + capitalize it fully
   */
  protected void addPieceAutoName(String item) {
    add(itemLang + item + "_pieces", properNaming(item + "_pieces"));
  }

  /**
   * @param fluid need fluid to be used in lang file
   * @param name set name of fluid that is shown ingame
   */
  protected void addFluidName(String fluid, String name) {
    add(fluidLang + fluid, name);
  }

  protected void addBlockName(BlockDefinition<? extends Block> definition) {
    add(blockLang + definition.getId().getPath(), definition.getEnglishName());
  }
}
