package optipvp.hud.impl;

import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.util.font.FontUtil;

public class ToggleSprintTracker extends HudMod {
  public ToggleSprintTracker() {
    super("MoveTracker", 99, 10);
  }
  
  public void draw() {
    if (this.mc.thePlayer.isSprinting())
      FontUtil.normal.drawStringWithShadow("Sprinting", getX(), getY(), OptiPvP.is.OPcolors.ColorInt()); 
    if (!this.mc.thePlayer.isSprinting() && this.mc.thePlayer.motionX != 0.0D && this.mc.thePlayer.motionZ != 0.0D)
      FontUtil.normal.drawStringWithShadow("Walking", getX(), getY(),  OptiPvP.is.OPcolors.ColorInt()); 
    if (this.mc.thePlayer.motionZ <= 0.0D && 
      this.mc.thePlayer.motionX <= 0.0D && 
      this.mc.thePlayer.motionX > -1.0E-23D && 
      this.mc.thePlayer.motionZ > -1.0E-23D)
      FontUtil.normal.drawStringWithShadow("Standing", getX(), getY(),  OptiPvP.is.OPcolors.ColorInt()); 
    super.draw();
  }
  
  public void renderDummy(int mouseX, int mouseY) {
    FontUtil.normal.drawStringWithShadow("Standing", getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
    super.renderDummy(mouseX, mouseY);
  }
}
