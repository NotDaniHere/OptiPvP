package optipvp.cosmetics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.Session;
import optipvp.OptiPvP;

public class CapeChecker {
	
	public static String capelocation;
	public static int partnercounter;
	public static String DaniCape = "optipvp/dani_partner_cape.png";
	public static String SofiCape = "optipvp/sofia_partner_cape.png";
	public static String BiaCape = "optipvp/bia_partner_capev1.png";
	public static String DenisCape = "optipvp/denis_partner_cape.png";
	public static String TimurCape = "optipvp/timur_cape.png";
	public static String MarcCape = "optipvp/bia_partner_capev1.png";
	public static String DefaultWhite = "optipvp/white_cape.png";
	public static String DefaultBlack = "optipvp/midnight_cape.png";
	
	
	public static boolean capeSelector(AbstractClientPlayer entitylivingbaseIn) {
		
		 if(entitylivingbaseIn.getName().equals(Session.username)) {
			 return true;
		 }else if (entitylivingbaseIn.getName().equals("DaniHere")){
				 capelocation = DaniCape;
				 return true;
		 }
			 return false;
		 
		 	
}
	
	public static void wDefaultCape() {
		capelocation = DefaultWhite;
	}
	
	public static void bDefaultCape() {
		capelocation = DefaultBlack;
	}
	
	public static void clearCape() {
		capelocation = "";
	}
}