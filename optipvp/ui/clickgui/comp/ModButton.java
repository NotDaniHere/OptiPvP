package optipvp.ui.clickgui.comp;
import java.awt.Color;

import net.minecraft.client.gui.Gui;
import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.mod.Mod;
import optipvp.util.RoundedUtils;
import optipvp.util.font.FontUtil;

public class ModButton {
	
	public int x, y, w, h;
	public float a, b,c, d;
	public HudMod m;
	
	public ModButton(int x, int y, int w, int h, HudMod m) {
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
		
		
		
	}
	
	public ModButton(float a, float b, float c, float d, HudMod m) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	
	}
	
	
	public void draw() {
		Gui.drawRect(x - 9, y + 90, x + w + 9, y + h - 90, OptiPvP.is.OPcolors.ColorInt());
		Gui.drawRect(x, y + 70, x + w, y + 85, getColor());
		FontUtil.normal.drawString(m.name, x + 5, y + h - 70, -1);
		FontUtil.normal.drawString(Enabled(), x + 10, y + h - 25, new Color(0,0,0,255).getRGB());

	}
	private int getColor() {
		if (m.isEnabled()) {
			return new Color(0,255,0,150).getRGB();
			
		}else {
			return new Color(255,0,0,150).getRGB();
		}

	}
	
	
	
	public void onClick(int mouseX, int mouseY, int button) {
		
		 if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h) {
			 if (m.isEnabled()) {
				 m.setEnabled(false);
			 }else {
				 m.setEnabled(true);
				}
			 }
		 }
	public String Enabled() {
		
		if(m.isEnabled()) {
			return "Enabled";
		} else {
			return "Disabled";
		}
		
		
	}
		
	}


