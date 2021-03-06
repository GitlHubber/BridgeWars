package com.ragalik.bridgewars.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ragalik.bridgewars.view.MainMenu;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 768;
		config.width = 1366;
		config.title = "BridgeWars";
		config.addIcon("img/Icon.png", Files.FileType.Internal);
		config.fullscreen = true;
		new LwjglApplication(new MainMenu(), config);
	}
}
