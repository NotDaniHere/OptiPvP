package optipvp.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import optipvp.OptiPvP;
import optipvp.hud.HudConfigScreen;
import optipvp.ui.clickgui.comp.ModButton;
import optipvp.util.ImageButton;

public class ClickGUI extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(0,0,0,190).getRGB());
		
		int wheel = Mouse.getDWheel();
        for (ModButton m : modButtons) {
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            this.glScissor(sr.getScaledWidth() / 2 - 205, sr.getScaledHeight() / 2 - 118, sr.getScaledWidth() / 2 + 205, 235);
            m.draw();
            if (wheel < 0) {
                m.y -= 16;
            } else if (wheel > 0) {
                m.y += 16;
            }
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
        } 
        }
        
        
		
		
	
	@Override
	public void initGui() {
		ScaledResolution sr = new ScaledResolution(mc);
		this.modButtons.add(new ModButton(600, 160, 65, 100, OptiPvP.is.hudManager.fps));
		this.modButtons.add(new ModButton(283, 160, 65, 100, OptiPvP.is.hudManager.waterMark));
		this.modButtons.add(new ModButton(390, 260, 65, 100, OptiPvP.is.hudManager.keystrokes));
		this.modButtons.add(new ModButton(490, 160, 65, 100, OptiPvP.is.hudManager.movementStatus));
		this.modButtons.add(new ModButton(283, 260, 65, 100, OptiPvP.is.hudManager.cps));
		this.modButtons.add(new ModButton(390, 160, 65, 100, OptiPvP.is.hudManager.armor));
		this.modButtons.add(new ModButton(490, 260, 65, 100, OptiPvP.is.hudManager.onesevenanimations));
		this.modButtons.add(new ModButton(600, 260, 65, 100, OptiPvP.is.hudManager.togglesprint));
		
		this.buttonList.add(new GuiButton(1, width / 2 - 60, height / 2 + 150, 120, 20, "Move Mods"));
		super.initGui();
		}
		
		
		
	
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for (ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}
	
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if (button.id == 1) {
			mc.displayGuiScreen(new HudConfigScreen());
		}
	}
	
	


private void glScissor(double x, double y, double width, double height) {

    y += height;

    ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());

    Minecraft mc = Minecraft.getMinecraft();

    GL11.glScissor((int) ((x * mc.displayWidth) / scaledResolution.getScaledWidth()),
            (int) (((scaledResolution.getScaledHeight() - y) * mc.displayHeight) / scaledResolution.getScaledHeight()),
            (int) (width * mc.displayWidth / scaledResolution.getScaledWidth()),
            (int) (height * mc.displayHeight / scaledResolution.getScaledHeight()));
}
}



