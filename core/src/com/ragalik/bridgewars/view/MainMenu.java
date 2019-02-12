package com.ragalik.bridgewars.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ragalik.bridgewars.BridgeWars;

public class MainMenu extends Game implements ApplicationListener {
    private Game game;
    private BridgeWars bridgeWars;
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("Start.jpg");
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

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            game.setScreen((Screen) this);
        }
        batch.draw(img, 0, 0);
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
