package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class GameScreen2 extends ScreenAdapter {
    MyGdxGame game;
    private OrthographicCamera camera;
    private Rectangle character;
    private Texture texture;

    public GameScreen2(MyGdxGame game) {
        this.game = game;
    }

    public void show() {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1920, 1080);
        texture = new Texture(Gdx.files.internal("minerArt.png"));
        character = new Rectangle();
        character.x = (1920 / 2) - (64 / 2); //set character's position on screen
        character.y = 20;

        character.height = 60; //set character's dimensions
        character.width = 20;


    }

    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1); //clear the screen

        camera.update(); //update camera

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(texture, character.x, character.y);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            character.x = (int) (touchPos.x - 64 / 2);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) character.y -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) character.x += 200 * Gdx.graphics.getDeltaTime();


        if (character.x < 0) character.x = 0;
        if (character.x > 800 - 64) character.x = 800 - 64;
    }


    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
