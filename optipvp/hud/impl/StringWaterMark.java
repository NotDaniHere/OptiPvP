package optipvp.hud.impl;

import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.ui.OptiPvPColors;
import optipvp.util.font.FontUtil;

public class StringWaterMark extends HudMod {
  public StringWaterMark() {
    super("WaterMark", 5, 5);
  }
  
  public void draw() {
    FontUtil.normal.drawStringWithShadow("OptiPvP " + OptiPvP.is.Version, getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
    super.draw();
  }
  
  public void renderDummy(int mouseX, int mouseY) {
    FontUtil.normal.drawStringWithShadow("OptiPvP " + OptiPvP.is.Version, getX(), getY(), OptiPvPColors.ColorInt());
    super.renderDummy(mouseX, mouseY);
  }
  
}
