package com.ragalik.bridgewars.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MenuController {
    private static int mouseX = Gdx.input.getX();
    private static int mouseY = Gdx.input.getY();
    private static boolean tap = true;
    private static Music menuSwitcher = Gdx.audio.newMusic(Gdx.files.internal("sounds/menuSwitcher.mp3"));
    private static List<Boolean> sound = new LinkedList<>(Arrays.asList(true, true, true));

    private static void updateSoundArr1 () {
        sound.set(0, false);
        sound.set(1, true);
        sound.set(2, true);
    }
    private static void updateSoundArr2 () {
        sound.set(0, true);
        sound.set(1, false);
        sound.set(2, true);
    }
    private static void updateSoundArr3 () {
        sound.set(0, true);
        sound.set(1, true);
        sound.set(2, false);
    }

    public static void handle(boolean[] arr) {
        menuSwitcher.setLooping(false);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            boolean temp = arr[arr.length - 1];
            for (int i = 1; i >= 0; --i) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;
            tap = true;
            menuSwitcher.play();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            boolean temp = arr[0];
            int i;
            for (i = 0; i < arr.length - 1; ++i) {
                arr[i] = arr[i + 1];
            }
            arr[i] = temp;
            tap = true;
            menuSwitcher.play();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if(arr[0]) {
                //go to gamescreen
            }
            if (arr[1]) {

            }
            if (arr[2]) {
                System.exit(0);
            }
        }

        if (mouseX != Gdx.input.getX() || mouseY != Gdx.input.getY()) {
            tap = false;
        }
        System.out.println(tap);
        if (!tap) {

            if (Gdx.input.getX() >= Gdx.graphics.getWidth() * 0.71 && Gdx.input.getX() <= Gdx.graphics.getWidth() * 0.86 &&
                    Gdx.input.getY() <= Gdx.graphics.getHeight() * 0.7 && Gdx.input.getY() >= Gdx.graphics.getHeight() * 0.61) {
                arr[0] = true;
                arr[1] = false;
                arr[2] = false;
                if (sound.get(0)) {
                    menuSwitcher.play();
                    updateSoundArr1();
                }
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.out.println("Hello");
                }
            }
            if (Gdx.input.getX() >= Gdx.graphics.getWidth() * 0.6 && Gdx.input.getX() <= Gdx.graphics.getWidth() * 0.9 &&
                    Gdx.input.getY() <= Gdx.graphics.getHeight() * 0.82 && Gdx.input.getY() >= Gdx.graphics.getHeight() * 0.75) {
                arr[0] = false;
                arr[1] = true;
                arr[2] = false;
                if (sound.get(1)) {
                    menuSwitcher.play();
                    updateSoundArr2();
                }
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.out.println("Hello");
                }
            }
            if (Gdx.input.getX() >= Gdx.graphics.getWidth() * 0.71 && Gdx.input.getX() <= Gdx.graphics.getWidth() * 0.86 &&
                    Gdx.input.getY() <= Gdx.graphics.getHeight() * 0.92 && Gdx.input.getY() >= Gdx.graphics.getHeight() * 0.85) {
                arr[0] = false;
                arr[1] = false;
                arr[2] = true;
                if (sound.get(2)) {
                    menuSwitcher.play();
                    updateSoundArr3();
                }
                if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    System.exit(0);
                }
            }
        }
        mouseX = Gdx.input.getX();
        mouseY = Gdx.input.getY();
    }
}
