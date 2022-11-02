package optipvp.hud.impl;

import net.minecraft.client.Minecraft;
import optipvp.OptiPvP;
import optipvp.event.EventTarget;
import optipvp.event.impl.EventUpdate;
import optipvp.hud.mod.HudMod;
import optipvp.mod.Category;
import optipvp.mod.Mod;
import optipvp.util.font.FontUtil;

public class OPMinVB extends HudMod{
	public static boolean viewBobbing;

	public OPMinVB() {
		super("Minimal View"
				+ " Bobbing", 9000, 9000);
		
	}
	
	
	

	@Override
		public void onDisable(){
			super.onDisable();
			viewBobbing = true;
		}
	
	@Override
	public void onEnable() {
		super.onEnable();
		viewBobbing = false;
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
	
	

