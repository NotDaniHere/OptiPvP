package optipvp.hud.impl;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import optipvp.OptiPvP;
import optipvp.hud.mod.HudMod;
import optipvp.util.font.FontUtil;
import org.lwjgl.opengl.GL11;

public class ArmorStatus extends HudMod {
  public Minecraft mc = Minecraft.getMinecraft();
  
  public ArmorStatus() {
    super("ArmorStatus", 90, 90);
  }
  
  public int getWidth() {
    return this.fr.getStringWidth("World 2");
  }
  
  public int getHeight() {
    return this.fr.FONT_HEIGHT;
  }
  
  public void draw() {
    for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; i++) {
      ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
      renderItemStack(i, itemStack);
    } 
    super.draw();
  }
  
  public void renderDummy(int mouseX, int mouseY) {
    renderItemStack(3, new ItemStack((Item)Items.diamond_helmet));
    renderItemStack(2, new ItemStack((Item)Items.diamond_chestplate));
    renderItemStack(1, new ItemStack((Item)Items.diamond_leggings));
    renderItemStack(0, new ItemStack((Item)Items.diamond_boots));
    super.renderDummy(mouseX, mouseY);
  }
  
  private void renderItemStack(int i, ItemStack is) {
    if (is == null)
      return; 
    GL11.glPushMatrix();
    int yAdd = -16 * i + 48;
    if (is.getItem().isDamageable()) {
      int damage = is.getMaxDamage() - is.getItemDamage();
      String s = Integer.toString(damage);
      FontUtil.normal.drawStringWithShadow(s, (getX() + 20), (getY() + yAdd + 5), OptiPvP.is.OPcolors.ColorInt());
    } 
    RenderHelper.enableGUIStandardItemLighting();
    this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, getX(), getY() + yAdd);
    GL11.glPopMatrix();
  }
}
