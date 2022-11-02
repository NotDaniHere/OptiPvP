package optipvp.hud.mod;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import optipvp.OptiPvP;
import optipvp.hud.DraggableComponent;

public class HudMod {
  public Minecraft mc = Minecraft.getMinecraft();
  
  public FontRenderer fr = this.mc.fontRendererObj;
  
  public String name;
  
  public boolean enabled;
  
  public DraggableComponent drag;
  
  public int x;
  
  public int y;
  
  public HudMod(String name, int x, int y) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.drag = new DraggableComponent(x, y, getWidth(), getHeight(), (new Color(255, 255, 0, 0)).getRGB());
  }

  
  public int getWidth() {
    return 50;
  }
  
  public int getHeight() {
    return 50;
  }
  
  public void draw() {}
  
  public void renderDummy(int mouseX, int mouseY) {
    drag.draw(mouseX, mouseY);
  }
  
  public int getX() {
    return this.drag.getxPosition();
  }
  
  public int getY() {
    return this.drag.getyPosition();
  }
  
  public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled) {
			onEnable();
			
		}else{
			onDisable();
		}
	}
  
  public void toggle() {
    setEnabled(!this.enabled);
  }
  
  public boolean isEnabled() {
    return this.enabled;
  }
  public void onEnable() {
		OptiPvP.is.eventManager.register(this);

	}
	public void onDisable() {
		OptiPvP.is.eventManager.unregister(this);

	}
	
}
