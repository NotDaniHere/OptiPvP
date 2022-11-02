package optipvp.hud.impl;

import net.minecraft.client.Minecraft;
import optipvp.OptiPvP;
import optipvp.event.EventTarget;
import optipvp.event.impl.EventUpdate;
import optipvp.hud.mod.HudMod;
import optipvp.mod.Category;
import optipvp.mod.Mod;
import optipvp.util.font.FontUtil;

public class ToggleSprint extends HudMod {
	
	Minecraft mc = Minecraft.getMinecraft();

	public ToggleSprint() {
		super("ToggleSprint", 9000, 9000);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
	
		if(this.isEnabled() && !mc.thePlayer.isBlocking() && !mc.thePlayer.isSneaking() && (mc.thePlayer.motionX != 0) && (mc.thePlayer.motionZ != 0)) {
			mc.thePlayer.setSprinting(true);
		} }
	
	@Override
		public void onDisable() {
			super.onDisable();
			
			mc.thePlayer.setSprinting(false);
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

		




