package com.ragalik.bridgewars.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class MenuController {
    public static void handle(boolean arr[]) {
        boolean temp;
        if(Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.DOWN) ) {


            temp=arr[0];
            arr[0]=arr[1];
            arr[1]=temp;
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
            if(true == arr[0]) {
                //go to gamescreen
            }
            if (true == arr[1]) {
                //exit
            }
        }
    }
}
