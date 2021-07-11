package top.frankyang.slk.mixin;

import net.minecraft.client.sound.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SoundEngine.class)
public class SoundEngineMixin {
    @Shadow
    private SoundEngine.SourceSet streamingSources;
    @Shadow
    private SoundEngine.SourceSet staticSources;

    /**
     * @reason ...
     * @author kworker
     */
    @Overwrite
    public String getDebugString() {
        return String.format("Sounds§e with Sound Limit Killer§r: %d/∞ + %d/∞",
                this.streamingSources.getSourceCount(),
                this.staticSources.getSourceCount());
    }
}
