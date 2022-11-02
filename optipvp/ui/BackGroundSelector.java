package optipvp.ui;

public class BackGroundSelector extends OptiPvP_MainMenu { {
	
	if(OptiPvP_MainMenu.ImageFinder == 0) {
		OptiPvP_MainMenu.ImageSelector = "optipvp/main_menu.png";
	}
	
	if(OptiPvP_MainMenu.ImageFinder == 1) {
		OptiPvP_MainMenu.ImageSelector = "optipvp/main_menu_nightly.png";
	}

	if(OptiPvP_MainMenu.ImageFinder == 2) {
		OptiPvP_MainMenu.ImageSelector = "optipvp/main_menu_balanced.png";
	}


} }
