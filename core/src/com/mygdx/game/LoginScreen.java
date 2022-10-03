package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class LoginScreen extends ScreenAdapter {
    MyGdxGame game;
    protected Stage stage;
    SpriteBatch batch;
    Skin skin;

    public LoginScreen(MyGdxGame game) {
        this.game = game;

        batch = new SpriteBatch();
        //atlas = new TextureAtlas("uiskin.atlas");
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        //skin.addRegions(atlas);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        TextButton playButton = new TextButton("Play", skin);
        playButton.setPosition(300, 300);
        playButton.setSize(300, 60);

        stage.addActor(playButton);

        /*
        camera = new OrthographicCamera();


        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        */

    }


    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new TitleScreen(game));
                }
                return true;
            }
        });

        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        /*mainframe = new Table();
        mainframe.setFillParent(true);

        mainframe.top();


        TextButton optionsButton = new TextButton("Options", skin);
        TextButton exitButton = new TextButton("Exit", skin); */
    }
}