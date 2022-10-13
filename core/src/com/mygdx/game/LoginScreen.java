package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.xml.soap.Text;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.touchUp;


public class LoginScreen extends ScreenAdapter {
    MyGdxGame game;
    Stage stage;
    SpriteBatch batch;
    TextField txtF;
    private Camera camera;
    private Viewport viewport;
    Label label;
    Skin skin = new Skin(Gdx.files.internal("data/neutralizerSkins/neutralizer-ui.json"));

    public LoginScreen(MyGdxGame game) {
        this.game = game;

    }
    private TextButton login() {
        TextButton login = new TextButton("Login", skin);
        login.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                game.setScreen(new TitleScreen(game));
            }
        });
        return login;
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


        label = new Label("", skin);
        Table root = new Table(skin);
        root.setBounds(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        root.setBackground(skin.getDrawable("custom"));
        //root.debug().defaults().space(6);
        TextButton login = login();
        root.add(login);
        root.add(new TextButton("Button 2", skin)).row();
        root.add("Press spacebar to change the viewport:").colspan(2).row();
        root.add(label).colspan(2);

        camera = new OrthographicCamera(600,900);
        viewport = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(root);



    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize(int width, int height) {

        stage.getViewport().update(width, height, true);
    }
}