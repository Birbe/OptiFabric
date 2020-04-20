package me.modmuss50.optifabric.mixin;

import me.modmuss50.optifabric.mod.Optifabric;
import me.modmuss50.optifabric.mod.OptifabricError;
import me.modmuss50.optifabric.mod.OptifineVersion;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.Font;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen { //extends Screen
//
//	protected MixinTitleScreen(Text component_1) {
//		super(component_1);
//	}
//
//	@Inject(method = "init", at = @At("RETURN"))
//	private void init(CallbackInfo info) {
//		Optifabric.checkForErrors();
//	}
//
	@Inject(method = "render", at = @At("RETURN"))
	private void render(int int_1, int int_2, float float_1, CallbackInfo info) {
		if (!OptifabricError.hasError()) {
			this.drawString(MinecraftClient.getInstance().textRenderer, OptifineVersion.optifineVersion, 2, this.height - 20, 0xffffffff);
		}
	}

}
