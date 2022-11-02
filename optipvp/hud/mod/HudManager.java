package optipvp.hud.mod;

import java.util.ArrayList;

import optipvp.hud.impl.ArmorStatus;
import optipvp.hud.impl.CPSMod;
import optipvp.hud.impl.FPSMod;
import optipvp.hud.impl.Keystrokes;
import optipvp.hud.impl.OPMinVB;
import optipvp.hud.impl.OneDotSevenAnimations;
import optipvp.hud.impl.StringWaterMark;
import optipvp.hud.impl.ToggleSprint;
import optipvp.hud.impl.ToggleSprintTracker;

public class HudManager {
  public ArrayList<HudMod> hudMods = new ArrayList<>();
  
  public StringWaterMark waterMark;
  
  public FPSMod fps;
  public Keystrokes keystrokes;
  
  public ToggleSprintTracker movementStatus;
  
  public CPSMod cps;
  
  public ArmorStatus armor;
  
  public OPMinVB opminvb;
  
  public ToggleSprint togglesprint;
  
  public OneDotSevenAnimations onesevenanimations;
  
  public HudManager() {
    this.hudMods.add(this.waterMark = new StringWaterMark());
    this.hudMods.add(this.fps = new FPSMod());
    this.hudMods.add(this.keystrokes = new Keystrokes());
    this.hudMods.add(this.movementStatus = new ToggleSprintTracker());
    this.hudMods.add(this.cps = new CPSMod());
    this.hudMods.add(this.armor = new ArmorStatus());
    this.hudMods.add(this.togglesprint = new ToggleSprint());
    this.hudMods.add(this.opminvb = new OPMinVB());
    this.hudMods.add(this.onesevenanimations = new OneDotSevenAnimations());
  }
  
  public void renderMods() {
    for (HudMod m : this.hudMods) {
      if (m.isEnabled())
        m.draw(); 
    } 
  }
}
