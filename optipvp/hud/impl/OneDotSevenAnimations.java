package optipvp.hud.impl;


import net.minecraft.client.Minecraft;
import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.util.font.FontUtil;
import optipvp.ui.OptiPvPColors;

public class OneDotSevenAnimations extends HudMod{

	


	public OneDotSevenAnimations() {
		super("LP Blocking", 50, 50);
	}

	
	
	 public void draw() {
		    FontUtil.normal.drawStringWithShadow("LP Blocking", getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
		    super.draw();
		  }
		  
	 public void renderDummy(int mouseX, int mouseY) {
		    FontUtil.normal.drawStringWithShadow("LP Blocking",getX(), getY(), OptiPvP.is.OPcolors.ColorInt());
		    super.renderDummy(mouseX, mouseY);
		  }
		  
}

