package top.frankyang.slk.mixin;

import net.minecraft.client.sound.Source;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Source.class)
public interface SourceInvoker {
    @Invoker("create")
    static Source create() {
        throw new AssertionError();
    }
}
