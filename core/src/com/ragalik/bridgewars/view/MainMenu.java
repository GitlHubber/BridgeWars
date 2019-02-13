package com.ragalik.bridgewars.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ragalik.bridgewars.BridgeWars;
import com.ragalik.bridgewars.control.MenuController;

public class MainMenu extends Game implements ApplicationListener {
    private Game game;
    private BridgeWars bridgeWars;
    private SpriteBatch batch;
    private Texture background;
    private Texture logo;
    private Texture exit;
    private Texture exitTap;
    private Texture play;
    private Texture playTap;
    private Texture settings;
    private Texture settingsTap;

    private boolean[] menu;
    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("startBackground.jpg");
        logo = new Texture("BW(start).png");
        menu = new boolean[]{true, false, false};
        exit = new Texture("exit.png");
        exitTap = new Texture("exitTarget.png");
        play = new Texture("play.png");
        playTap = new Texture("playTarget.png");
        settings = new Texture("settings.png");
        settingsTap = new Texture("settingsTarget.png");
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

   //     if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
   //         game.setScreen((Screen) this);
   //     }
        batch.draw(background, 0, 0,1366,768);
        batch.draw(logo,0,180);
        MenuController.handle(menu);
        if (menu[0]) {
            batch.draw(playTap, 800, 50);
        } else {
            batch.draw(play, 800, 40);
        }
        if (menu[1]) {
            batch.draw(settingsTap, 800, -30);
        } else {
            batch.draw(settings, 800, -40);
        }
        if (menu[2]) {
            batch.draw(exitTap, 805, -120);
        } else {
            batch.draw(exit, 805, -130);
        }
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }
}
