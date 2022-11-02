package optipvp.ui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import optipvp.cosmetics.CosmeticsConfigScreen;
import optipvp.hud.HudConfigScreen;

public class OptiPvPSettings extends GuiScreen {

	
	
	
	
	
	public void drawScreen() {
		
	}
	
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 20, height / 2 + 20, "Main Menu"));
		this.buttonList.add(new GuiButton(2, 20, height / 2 + 20, "Change Color"));
		this.buttonList.add(new GuiButton(1, 20, height / 2 + 20, "Mods"));
		this.buttonList.add(new GuiButton(1, 20, height / 2 + 20, "Cosmetics"));
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new OptiPvP_MainMenu());
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new OptiPvPColors());
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new HudConfigScreen());
		}
		if(button.id == 4) {
			mc.displayGuiScreen(new CosmeticsConfigScreen());
		}
		super.actionPerformed(button);
	}
	
}
