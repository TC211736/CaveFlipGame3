package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.touchUp;


public class LoginScreen extends ScreenAdapter {
    MyGdxGame game;
    Stage stage;
    SpriteBatch batch;
    Skin skin;

    public LoginScreen(MyGdxGame game) {
        this.game = game;

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


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("data/flatEarthFiles/flat-earth-ui.json"));

        //flatEarthFiles/flat-earth-ui.json
        TextButton playButton = new TextButton("Play", skin);
        playButton.setPosition(300, 300);
        playButton.setSize(300, 60);

        public void touchUp (InputEvent event, float x, float y, int pointer,int button)


        stage.addActor(playButton);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
    }
}