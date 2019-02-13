package com.ragalik.bridgewars.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MenuController {
    public static void handle(boolean arr[]) {
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            boolean temp = arr[arr.length - 1];
            for (int i = 1; i >= 0; --i) {
                arr[i + 1] = arr[i];
            }
            arr[0] = temp;

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            boolean temp = arr[0];
            int i;
            for (i = 0; i < arr.length - 1; ++i) {
                arr[i] = arr[i + 1];
            }
            arr[i] = temp;

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
    }
}
