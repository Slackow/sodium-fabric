package me.jellysquid.mods.sodium.mixin.options;

import me.jellysquid.mods.sodium.client.gui.SodiumOptionsGUI;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SettingsScreen.class)
public class MixinSettingsScreen extends Screen {
    protected MixinSettingsScreen(Text title) {
        super(title);
    }

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "method_19828(Lnet/minecraft/client/gui/widget/ButtonWidget;)V", at = @At("HEAD"), cancellable = true)
    private void open(ButtonWidget widget, CallbackInfo ci) {
        this.minecraft.openScreen(new SodiumOptionsGUI(this));

        ci.cancel();
    }
}