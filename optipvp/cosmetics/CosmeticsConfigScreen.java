package optipvp.cosmetics;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import optipvp.hud.HudConfigScreen;
import optipvp.ui.OptiPvP_MainMenu;

public class CosmeticsConfigScreen extends GuiScreen {

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		GL11.glColor4f(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(new ResourceLocation("optipvp/main_menu_nightly.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		Gui.drawRect(0,  0, 1920, this.height, new Color(0,0,0, 170).getRGB());
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		mc.fontRendererObj.drawStringWithShadow("Settings", width / 2 - 16, height - 280 - mc.fontRendererObj.FONT_HEIGHT/ 2f - 25, -1);
		GlStateManager.popMatrix();
		

		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if (button.id == 1) {
			CapeChecker.bDefaultCape();
		}
		if (button.id == 2) {
			CapeChecker.wDefaultCape();
			
		}
		if (button.id == 99) {
			mc.displayGuiScreen(new OptiPvP_MainMenu());
		}
		if (button.id == 100) {
			mc.displayGuiScreen(new HudConfigScreen());
		}
		if(button.id == 101) {
			CapeChecker.clearCape();
		}
		if(button.id == 102) {
			mc.displayGuiScreen(new CapeCodeScreen());

		}
		
		

		
		
		super.actionPerformed(button);
	}
	
	
	
	
	@Override
	public void initGui() {
	
		//this.buttonList.add(new GuiButton(1, 20, height / 2, "Black Default Cape"));
		this.buttonList.add(new GuiButton(90, width / 2 - 100, height / 2, 100, 20, "Cosmetics"));
		this.buttonList.add(new GuiButton(90, width / 2 - 100, height / 2 - 25, 100, 20, "Move Mods"));
		this.buttonList.add(new GuiButton(90, width / 2 - 100, height / 2 - 50, 100, 20, "Main Screen"));
		this.buttonList.add(new GuiButton(90, width / 2 + 10, height / 2 , 100, 20, "Configure Mods"));
		this.buttonList.add(new GuiButton(90, width / 2 + 10, height / 2 - 25, 100, 20, "Back"));
		//this.buttonList.add(new GuiButton(90, width / 2 - 90, height / 2, 100, 20, "Cosmetics"));
		//this.buttonList.add(new GuiButton(90, width / 2 - 90, height / 2, 100, 20, "Cosmetics"));
		//this.buttonList.add(new GuiButton(2, 20, height / 2 - 23, "White Default Cape"));
		//this.buttonList.add(new GuiButton(99, width / 2  + 300, height / 2 + 240, 60, 20, "Main Menu"));
		//this.buttonList.add(new GuiButton(100, width / 2  - 450, height / 2 + 240, 90, 20, "Move Mods"));
		//this.buttonList.add(new GuiButton(101, 20, height / 2 + 23, "Remove Cape"));
		//this.buttonList.add(new GuiButton(102, 20, height / 2 + 46, "Cape Code"));
        Keyboard.enableRepeatEvents(true);
	}
	
		
		
	
	
	

}
