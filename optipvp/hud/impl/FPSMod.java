package optipvp.hud.impl;

import net.minecraft.client.Minecraft;
import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.util.font.FontUtil;

public class FPSMod extends HudMod {
  public Minecraft mc = Minecraft.getMinecraft();
  
  public FPSMod() {
    super("Show FPS", 100, 100);
  }
  
  public void draw() {
    FontUtil.normal.drawStringWithShadow("[FPS:" + Minecraft.getDebugFPS() + "]", getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
    super.draw();
  }
  
  public void renderDummy(int mouseX, int mouseY) {
    FontUtil.normal.drawStringWithShadow("[FPS:" + Minecraft.getDebugFPS() + "]", getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
    super.renderDummy(mouseX, mouseY);
  }
  
  public int getWidth() {
    return this.fr.getStringWidth("[ FPS:" + Minecraft.getDebugFPS() + "]");
  }
  
  public int getHeight() {
    return this.fr.FONT_HEIGHT;
  }
}
