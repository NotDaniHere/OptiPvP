package optipvp.hud.impl;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import optipvp.hud.mod.HudMod;
import org.lwjgl.opengl.GL11;

public class Keystrokes extends HudMod {
  private KeystrokesMode mode;
  
  public Keystrokes() {
    super("KeyStrokes", 500, 100);
    this.mode = KeystrokesMode.WASD_JUMP_MOUSE;
  }
  
  public enum KeystrokesMode {
	  WASD(Key.W, Key.A, Key.S, Key.D),
	  WASD_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
	  WASD_JUMP(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
	  WASD_JUMP_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.JUMP1, Key.LMB, Key.RMB);
	  
    
    private Keystrokes.Key[] keys;
    
    private int w;
    
    private int h;
    
    private int width;
    
    private int height;
    
    KeystrokesMode(Keystrokes.Key... keysIn) {
      this.keys = keysIn;
      byte b;
      int i;
      Keystrokes.Key[] arrayOfKey;
      for (i = (arrayOfKey = this.keys).length, b = 0; b < i; ) {
        Keystrokes.Key key = arrayOfKey[b];
        this.width = Math.max(this.width, key.getX() + key.getWidth());
        this.height = Math.max(this.height, key.getY() + key.getHeight());
        b++;
      } 
    }
    
    public int getHeight() {
      return this.height;
    }
    
    public int getWidth() {
      return this.width;
    }
    
    public Keystrokes.Key[] getKeys() {
      return this.keys;
    }
  }
  
  public static class Key {
    public static Minecraft mc = Minecraft.getMinecraft();
    
    private static final Key W = new Key("W", mc.gameSettings.keyBindForward, 21, 1, 18, 18);
    
    private static final Key A = new Key("A", mc.gameSettings.keyBindLeft, 1, 21, 18, 18);
    
    private static final Key S = new Key("S", mc.gameSettings.keyBindBack, 21, 21, 18, 18);
    
    private static final Key D = new Key("D", mc.gameSettings.keyBindRight, 41, 21, 18, 18);
    
    private static final Key LMB = new Key("LMB", mc.gameSettings.keyBindAttack, 1, 41, 28, 18);
    
    private static final Key RMB = new Key("RMB", mc.gameSettings.keyBindUseItem, 31, 41, 28, 18);
    
    private static final Key JUMP = new Key("----", mc.gameSettings.keyBindJump, 1, 41, 58, 18);
    
    private static final Key JUMP1 = new Key("----", mc.gameSettings.keyBindJump, 1, 61, 58, 18);
    
    private final String name;
    
    private final KeyBinding keyBind;
    
    private final int x;
    
    private final int y;
    
    private final int w;
    
    private final int h;
    
    public Key(String name, KeyBinding keyBind, int x, int y, int w, int h) {
      this.y = y;
      this.name = name;
      this.keyBind = keyBind;
      this.x = x;
      this.w = w;
      this.h = h;
    }
    
    public boolean isDown() {
      return this.keyBind.isKeyDown();
    }
    
    public int getHeight() {
      return this.h;
    }
    
    public int getWidth() {
      return this.w;
    }
    
    public String getName() {
      return this.name;
    }
    
    public int getX() {
      return this.x;
    }
    
    public int getY() {
      return this.y;
    }
  }
  
  public int getWidth() {
    return 58;
  }
  
  public int getHeight() {
    return 18;
  }
  
  public void draw() {
    GL11.glPushMatrix();
    byte b;
    int i;
    Key[] arrayOfKey;
    for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) {
      Key key = arrayOfKey[b];
      int textWidth = this.fr.getStringWidth(key.getName());
      Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + getHeight(), key.isDown() ? (new Color(255, 255, 255, 90)).getRGB() : (new Color(0, 0, 0, 90)).getRGB());
      this.fr.drawStringWithShadow(key.getName(), (getX() + key.getX() + key.getWidth() / 2 - textWidth / 2), (getY() + key.getY() + key.getHeight() / 2 - 4), key.isDown() ? (new Color(0, 0, 0, 255)).getRGB() : -1);
      b++;
    } 
    GL11.glPopMatrix();
    super.draw();
  }
  
  public void renderDummy(int mouseX, int mouseY) {
    GL11.glPushMatrix();
    byte b;
    int i;
    Key[] arrayOfKey;
    for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) {
      Key key = arrayOfKey[b];
      int textWidth = this.fr.getStringWidth(key.getName());
      Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + getHeight(), key.isDown() ? (new Color(255, 255, 255, 90)).getRGB() : (new Color(0, 0, 0, 90)).getRGB());
      this.fr.drawStringWithShadow(key.getName(), (getX() + key.getX() + key.getWidth() / 2 - textWidth / 2), (getY() + key.getY() + key.getHeight() / 2 - 4), key.isDown() ? (new Color(0, 0, 0, 255)).getRGB() : -1);
      b++;
    } 
    GL11.glPopMatrix();
    super.renderDummy(mouseX, mouseY);
  }
}
