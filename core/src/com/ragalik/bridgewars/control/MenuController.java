package com.ragalik.bridgewars.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;

public class MenuController {
    public static void handle(boolean[] arr) {
//         if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//             boolean temp = arr[arr.length - 1];
//             for (int i = 1; i >= 0; --i) {
//                 arr[i + 1] = arr[i];
//             }
//             arr[0] = temp;
//             new DelayAction(1);
//         } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//             boolean temp = arr[0];
//             int i;
//             for (i = 0; i < arr.length - 1; ++i) {
//                 arr[i] = arr[i + 1];
//             }
//             arr[i] = temp;
//             DelayAction delayAction = new DelayAction();
//             delayAction.setTime(10);
//             delayAction.finish();
//         }


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

        //System.out.println(Gdx.graphics.getWidth() * 0.3 + " " + Gdx.graphics.getHeight() * 0.7);
        if (Gdx.input.getX() >= Gdx.graphics.getWidth() * 0.71 && Gdx.input.getX() <= Gdx.graphics.getWidth() * 0.86 &&
        Gdx.input.getY() <= Gdx.graphics.getHeight() * 0.7 && Gdx.input.getY() >= Gdx.graphics.getHeight() * 0.61)   {
            arr[0] = true;
            arr[1] = false;
            arr[2] = false;
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                System.out.println("Hello");
            }
        }
        if (Gdx.input.getX() >= Gdx.graphics.getWidth() * 0.6 && Gdx.input.getX() <= Gdx.graphics.getWidth() * 0.9 &&
                Gdx.input.getY() <= Gdx.graphics.getHeight() * 0.82 && Gdx.input.getY() >= Gdx.graphics.getHeight() * 0.75) {
            arr[0] = false;
            arr[1] = true;
            arr[2] = false;
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                System.out.println("Hello");
            }
        }
        if (Gdx.input.getX() >= Gdx.graphics.getWidth() * 0.71 && Gdx.input.getX() <= Gdx.graphics.getWidth() * 0.86 &&
                Gdx.input.getY() <= Gdx.graphics.getHeight() * 0.92 && Gdx.input.getY() >= Gdx.graphics.getHeight() * 0.85) {
            arr[0] = false;
            arr[1] = false;
            arr[2] = true;
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                System.exit(0);
            }
        }

    }
}
