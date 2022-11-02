package optipvp.hud;

import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import optipvp.OptiPvP;
import optipvp.cosmetics.CosmeticsConfigScreen;
import optipvp.hud.mod.HudMod;
import optipvp.ui.clickgui.ClickGUI;

public class HudConfigScreen extends GuiScreen {
  public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    this.drawDefaultBackground();
    
    
    for (HudMod m : OptiPvP.is.hudManager.hudMods) {
      if (m.isEnabled())
        m.renderDummy(mouseX, mouseY); 
    } 
    super.drawScreen(mouseX, mouseY, partialTicks);
  }
  
  public void initGui() {
    this.buttonList.add(new GuiButton(1, this.width - 130, this.height - 40, 120, 20, "Enable/Disable Mods"));
    this.buttonList.add(new GuiButton(2, this.width - 130, this.height - 70, 120, 20, "OptiPvP Settings"));
    this.buttonList.add(new GuiButton(3, this.width - 130, this.height - 100, 120, 20, "Change Client Theme"));
    
  }

  
  protected void actionPerformed(GuiButton button) throws IOException {
    if (button.id == 1)
      this.mc.displayGuiScreen((GuiScreen)new ClickGUI()); 
    if (button.id == 2)
      this.mc.displayGuiScreen((GuiScreen)new CosmeticsConfigScreen()); 
    if (button.id == 3)
    	OptiPvP.is.OPcolors.CS = OptiPvP.is.OPcolors.CS + 1;
}
}