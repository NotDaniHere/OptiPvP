package optipvp.mod.impl;

import optipvp.mod.Category;
import optipvp.mod.Mod;

public class TestMod extends Mod {

	public TestMod() {
		super("TestMod", "Used for testing", Category.MISC);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnable() {
		super.onEnable();
		System.out.println("HELLO DIRTY SHITTY WORLD");
	}
	
}
