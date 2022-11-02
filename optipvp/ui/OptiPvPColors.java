package optipvp.ui;
import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import optipvp.util.openauth.GuiLogin;
import optipvp.util.openauth.SessionChanger;

public class OptiPvPColors extends GuiScreen{
	
	public static int CS = 0;
	public static int OPRED = 0;
	public static int OPGREEN = 0;
	public static int OPBLUE = 0;
	public static int OPCTHROUGH = 59;
	
	public static int ColorBlackRect = new Color(0,0,0,90).getRGB();
	
	public static int ColorInt() {
		
/*			  if(CS == 1) {
			return new Color(90, 90, 0, 90).getRGB();
		}else if(CS == 2) {
			return new Color(100, 50, 0, 90).getRGB();
		}else if(CS == 3) {
			return new Color (100, 0, 100, 90).getRGB();
		}else if(CS == 4) {
			return new Color(102, 0, 0, 90).getRGB();
		}else if(CS == 5) {
			return new Color(255, 204, 204, 90).getRGB();
		}else if(CS == 6) {
			return new Color(255, 255, 51, 90).getRGB();
		}else if(CS == 7) {
			return new Color(76, 153, 0, 90).getRGB();
		}else if(CS == 8) {
			return new Color(0, 204, 204, 90).getRGB();
		}else if (CS == 9) {
			return new Color(0, 255, 255, 90).getRGB();
		}else if(CS == 10) {
			return new Color(0, 102, 204, 90).getRGB();
		}else if (CS == 11) {
			return new Color(178, 102, 255, 90).getRGB();
		}else if (CS == 12) {
			return new Color(153, 51, 255, 90).getRGB();
		}else if(CS == 13) {
			return new Color(153, 0, 153, 90).getRGB();
		}else if(CS == 14) {
			return new Color(153, 0 , 76, 90).getRGB();
		}else if(CS == 15) {
			return new Color(255, 102, 178).getRGB();
		}else if(CS == 16) {
			return new Color(160, 160, 160, 90).getRGB();
		}else if(CS == 17) {
			return new Color(255, 255, 255, 155).getRGB();
		}else if(CS == 18) {
			CS = 0;
		}
			return new Color(100, 100, 100, 90).getRGB();
			
		
	*/	
		
		
		
		
	return new Color(OPRED, OPGREEN, OPBLUE, OPCTHROUGH).getRGB();
		
	}
	

   

	public static Object ColorSelector() {
		return CS;
	}
	
}
