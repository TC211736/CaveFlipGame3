package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class ShopScreen extends ScreenAdapter {
    MyGdxGame game;

    public ShopScreen(MyGdxGame game) {
        this.game = game;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.7f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
