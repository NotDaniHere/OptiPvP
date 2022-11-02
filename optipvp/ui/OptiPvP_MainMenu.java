package optipvp.ui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import optipvp.OptiPvP;
import optipvp.cosmetics.CosmeticsConfigScreen;
import optipvp.util.openauth.AltManagerGui;

public class OptiPvP_MainMenu extends GuiScreen {
	
	public static String ImageSelector = "optipvp/main_menu.png";
	public static int ImageFinder = 1;
	
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(new ResourceLocation(ImageSelector));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		Gui.drawModalRectWithCustomSizedTexture(-21 + (Mouse.getX() / 90), ((Mouse.getY() * -1 / 90)), 0, 0, width + 20, height + 20, width + 21, height + 20);
		Gui.drawRect(0,  0, 245, this.height, new Color(0,0,0, 170).getRGB());
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		mc.fontRendererObj.drawStringWithShadow("OptiPvP", width - 617, height - 270 - mc.fontRendererObj.FONT_HEIGHT/ 2f - 25, -1);
		GlStateManager.popMatrix();
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 20, height / 2 + 20, "Local Worlds"));
		this.buttonList.add(new GuiButton(2, 20, height / 2 + 42, "Multiplayer"));
		this.buttonList.add(new GuiButton(3, 20, height / 2 + 64, "Settings"));
		this.buttonList.add(new GuiButton(4, 20, height / 2 + 108, "Quit"));
		this.buttonList.add(new GuiButton(5, 20, height / 2 + 86, "Texture Packs"));
		this.buttonList.add(new GuiButton(6, width / 2  + 300, height / 2 + 240, 60, 20, "Cosmetics"));
		this.buttonList.add(new GuiButton(7, width / 2  + 400, height / 2 - 260, 60, 20, "Nightly"));
		this.buttonList.add(new GuiButton(8, width / 2  + 400, height / 2 - 239, 60, 20, "Balanced"));
		this.buttonList.add(new GuiButton(9, width / 2  + 400, height / 2 - 218, 60, 20, "Original"));
		this.buttonList.add(new GuiButton(10, width / 2  + 300, height / 2 + 210, 60, 20, "Color"));
		this.buttonList.add(new GuiButton(13, 30, 5, 180, 20, "Cracked Login"));
		super.initGui();
	}	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if (button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		
		if (button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		
		if(button.id == 4) {
			mc.shutdown();
		}
		if(button.id == 5) {
			mc.displayGuiScreen(new GuiScreenResourcePacks(this));
		}
		if(button.id == 6) {
			mc.displayGuiScreen(new CosmeticsConfigScreen());
		}
		if(button.id == 7) {
			ImageSelector = "optipvp/main_menu_nightly.png";
		}
		if(button.id == 8) {
			ImageSelector = "optipvp/main_menu_balanced.png";
		}
		if(button.id == 9) {
			ImageSelector = "optipvp/main_menu.png";
		}
		if(button.id == 10) {
			OptiPvP.is.OPcolors.CS = OptiPvP.is.OPcolors.CS + 1;
		}
		if(button.id == 13) {
			mc.displayGuiScreen(new AltManagerGui());
		}
		
				
		super.actionPerformed(button);
	}
	
	
	
	
} 
