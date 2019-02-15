package com.ragalik.bridgewars.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ragalik.bridgewars.BridgeWars;
import com.ragalik.bridgewars.control.MenuController;

public class MainMenu extends Game implements ApplicationListener {
    private double i = 0;
    private double i_ = 0;

    private Music menuSong;
    private SpriteBatch batch;
    private Texture background_1;
    private Texture background_2;
    private Texture background_3;
    private Texture logoBridge;
    private Texture logoWars;
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
        menuSong = Gdx.audio.newMusic(Gdx.files.internal("music/menu.mp3"));
        background_1 = new Texture("img/back1.png");
        background_2 = new Texture("img/back2.png");
        background_3 = new Texture("img/back3.png");
        logoBridge = new Texture("img/BW1(start).png");
        logoWars = new Texture("img/BW2(start).png");
        exit = new Texture("img/exit.png");
        exitTap = new Texture("img/exitTarget.png");
        play = new Texture("img/play.png");
        playTap = new Texture("img/playTarget.png");
        settings = new Texture("img/settings.png");
        settingsTap = new Texture("img/settingsTarget.png");
        menu = new boolean[]{true, false, false};
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
        batch.draw(background_2, (int)(Math.cos(i_ += 0.006) * 15) + 10,  10, 1366,768);

        batch.draw(logoBridge,(int)(Math.tan(i_ -= 0.00001) * 70) + 20, (int)(Math.cos(i_ += 0.01) * 50) + 200,600,600);
        batch.draw(logoWars,(int)(Math.tan(i_ -= 0.00001) * 50) + 40, (int)(Math.cos(i_ += 0.01) * 50) + 195,600,600);

        Thread thread = new HandleThread();
        thread.start();
        menuSong.play();

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

    class HandleThread extends Thread {
        @Override
        public void run() {
            MenuController.handle(menu);
        }
    }
}
