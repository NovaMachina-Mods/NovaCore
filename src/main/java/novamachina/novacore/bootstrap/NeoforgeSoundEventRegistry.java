package novamachina.novacore.bootstrap;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import novamachina.novacore.core.IRegistry;

public class NeoforgeSoundEventRegistry implements IRegistry<SoundEvent> {
  public NeoforgeSoundEventRegistry() {}

  public void register(SoundEvent entry) {
    Registry.register(BuiltInRegistries.SOUND_EVENT, entry.getLocation(), entry);
  }
}
