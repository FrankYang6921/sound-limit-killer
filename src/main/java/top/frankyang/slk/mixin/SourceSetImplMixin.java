package top.frankyang.slk.mixin;

import net.minecraft.client.sound.SoundEngine;
import net.minecraft.client.sound.Source;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;


@SuppressWarnings("OverwriteModifiers")
@Mixin(SoundEngine.SourceSetImpl.class)
public abstract class SourceSetImplMixin {
    @Shadow
    @Final
    private Set<Source> sources;

    /**
     * @reason ...
     * @author kworker
     */
    @Overwrite
    public Source createSource() {
        Source source = SourceInvoker.create();
        if (source != null) {
            this.sources.add(source);
        }
        return source;
    }

    /**
     * @reason ...
     * @author kworker
     */
    @Overwrite
    public int getMaxSourceCount() {
        return Integer.MAX_VALUE;
    }
}
