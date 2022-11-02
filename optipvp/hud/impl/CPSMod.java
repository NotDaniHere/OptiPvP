package optipvp.hud.impl;

import java.util.ArrayList;
import java.util.List;

import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.util.font.FontUtil;
import org.lwjgl.input.Mouse;

public class CPSMod extends HudMod {
  List<Long> clicks;
  
  private boolean wasPressed;
  
  private long lastPressed;
  
  public CPSMod() {
    super("Show CPS", 5, 5);
    this.clicks = new ArrayList<>();
  }
  
  public int getWidth() {
    return this.fr.getStringWidth("00");
  }
  
  public int getHeight() {
    return this.fr.FONT_HEIGHT;
  }
  
  public void renderDummy(int mouseX, int mouseY) {
    FontUtil.normal.drawStringWithShadow("CPS:" + getCPS(), getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
    super.renderDummy(mouseX, mouseY);
  }
  
  public void draw() {
    boolean pressed = Mouse.isButtonDown(0);
    if (pressed != this.wasPressed) {
      this.lastPressed = System.currentTimeMillis();
      this.wasPressed = pressed;
      if (pressed)
        this.clicks.add(Long.valueOf(this.lastPressed)); 
    } 
    FontUtil.normal.drawStringWithShadow("LMB CPS:" + getCPS(), getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
    super.draw();
  }
  
  private int getCPS() {
    long time = System.currentTimeMillis();
    this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < time));
    return this.clicks.size();
  }
}
