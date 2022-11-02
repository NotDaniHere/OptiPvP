package optipvp;

import org.lwjgl.opengl.Display;

import net.minecraft.client.Minecraft;
import optipvp.discord.DiscordRP;
import optipvp.event.EventManager;
import optipvp.event.EventTarget;
import optipvp.event.impl.ClientTick;
import optipvp.hud.HudConfigScreen;
import optipvp.hud.impl.OPMinVB;
import optipvp.hud.impl.ToggleSprint;
import optipvp.hud.mod.HudManager;
import optipvp.ui.OptiPvPColors;
import optipvp.util.SessionChanger;
import optipvp.util.font.FontUtil;

public class OptiPvP {

	public String cName = "OptiPvP";
	public String Version = "DEV Pre-Release v0.1";
	public String Author = "DaniHere";
	public String testers = "some very cool people";
	
	public static OptiPvP is = new OptiPvP();
	public Minecraft mc = Minecraft.getMinecraft();
	public EventManager eventManager;
	public DiscordRP discordRP = new DiscordRP();
	public HudManager hudManager;
	public OptiPvPColors OPcolors;
	public OPMinVB opminvb;
	public ToggleSprint togglesprint;
	public void startup() {
		System.out.println("Starting OptiPvP");
		System.out.println("Client: " + cName + " " + Version + " made by " + Author + " with the help of: " + testers );
		
		
		FontUtil.bootstrap();
		eventManager = new EventManager();
		hudManager = new HudManager();
		OPcolors = new OptiPvPColors();
		Display.setTitle(cName + " " + Version);
		discordRP.start();
		SessionChanger.getInstance().setUserOffline("DaniHere");
		
		eventManager.register(this);


		
		
		

	}
	
	
	
	public void shutdown() {
		System.out.println("Closing " + cName);
		discordRP.shutdown();
		eventManager.unregister(this);

	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	
	@EventTarget
	public void onTick(ClientTick event) { 
		if (mc.gameSettings.OPTIPVP_TOGGLESPRINT.isPressed()) {
			hudManager.togglesprint.toggle();
			
		}
		if (mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HudConfigScreen());
		}

	}
	

}
