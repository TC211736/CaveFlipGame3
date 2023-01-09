package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends Game {
	public static SpriteBatch batch;
	public Viewport viewport;
	public OrthographicCamera camera;

	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new LoginScreen(this));
	}
}