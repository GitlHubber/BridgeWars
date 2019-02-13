package com.ragalik.bridgewars.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.ragalik.bridgewars.BridgeWars;
import com.ragalik.bridgewars.control.MenuController;

public class MainMenu extends Game implements ApplicationListener {
    private double i = 0;
    private double i_ = 0;
    private Game game;
    private BridgeWars bridgeWars;
    private SpriteBatch batch;
    private Texture background_1;
    private Texture background_2;
    private Texture background_3;
    private Texture logo;
    private Texture exit;
    private Texture exitTap;
    private Texture play;
    private Texture playTap;
    private Texture settings;
    private Texture settingsTap;
    private OrthographicCamera camera;

    private boolean[] menu;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background_1 = new Texture("back1.png");
        background_2 = new Texture("back2.png");
        background_3 = new Texture("back3.png");
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
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background_1, 0, 0,1366,768);
        batch.draw(background_3, (int)(Math.sin(i += 0.004) * 100) - 50, (int)(Math.sin(i += 0.004) * 100) - 50,1366,768);
        batch.draw(background_2, (int)(Math.cos(i_ += 0.012) * 15) + 10, (int)(Math.cos(i_ += 0.012) * 15) + 10, 1366,768);


        batch.draw(logo,(int)(Math.tan(i_ -= 0.00001) * 70) + 20, 200,600,600);

        MenuController.handle(menu);
        if (menu[0]) {
            batch.draw(playTap, 880, 50,400,400);
        } else {
            batch.draw(play, 880, 40,400,400);
        }
        if (menu[1]) {
            batch.draw(settingsTap, 880, -30,400,400);
        } else {
            batch.draw(settings, 880, -40,400,400);
        }
        if (menu[2]) {
            batch.draw(exitTap, 885, -120,400,400);
        } else {
            batch.draw(exit, 885, -130,400,400);
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
        batch.dispose();
        background_2.dispose();
        background_3.dispose();
    }
}
