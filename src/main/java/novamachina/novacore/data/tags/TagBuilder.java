package novamachina.novacore.data.tags;

import java.util.function.Consumer;
import java.util.function.Function;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagKey;

public class TagBuilder<Y, B extends TagBuilder<Y, B>> {

  protected final net.minecraft.tags.TagBuilder builder;
  protected final String modID;

  public TagBuilder(net.minecraft.tags.TagBuilder builder, String modID) {
    this.builder = builder;
    this.modID = modID;
  }

  @SuppressWarnings("unchecked")
  private B self() {
    return (B) this;
  }

  @SafeVarargs
  public final B add(TagKey<Y>... tags) {
    return apply(builder::addTag, TagKey::location, tags);
  }

  public B add(TagEntry tag) {
    builder.add(tag);
    return self();
  }

  @SafeVarargs
  public final B add(ResourceKey<Y>... keys) {
    return add(ResourceKey::location, keys);
  }

  @SafeVarargs
  public final <T> B add(Function<T, ResourceLocation> locationGetter, T... elements) {
    return apply(builder::addElement, locationGetter, elements);
  }

  @SafeVarargs
  protected final <T> B apply(
      Consumer<ResourceLocation> consumer,
      Function<T, ResourceLocation> locationGetter,
      T... elements) {
    for (T element : elements) {
      consumer.accept(locationGetter.apply(element));
    }
    return self();
  }
}
