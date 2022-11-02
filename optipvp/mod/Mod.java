package optipvp.mod;

import net.minecraft.client.Minecraft;
import optipvp.OptiPvP;

public class Mod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public String description;
	public String name;
	public boolean enabled;
	public Category category;
	
	

	
	public Mod(String name, String description, Category category) {
		
		this.name = name;
		this.description = description;
		this.category = category;
		this.enabled = true;
	}	
		
	public void onEnable() {
		OptiPvP.is.eventManager.register(this);

	}
	public void onDisable() {
		OptiPvP.is.eventManager.unregister(this);

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
	
	public String getName() {
		return name;
	}


	public boolean isEnabled() {
		return enabled;
	}




	public Category getCategory() {
		return category;
	}




	public String getDescription() {
		return description;
	}


}

