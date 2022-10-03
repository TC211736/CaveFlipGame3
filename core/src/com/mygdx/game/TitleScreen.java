package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class TitleScreen extends ScreenAdapter {

    MyGdxGame game;
    ShapeRenderer shape;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font12;
    Texture playButtonImage;
    Texture shopButtonImage;
    Texture exitButtonImage;
    Texture backgroundImage;
    Rectangle playButton;
    Rectangle shopButton;
    Rectangle exitButton;
    Rectangle background;


    public TitleScreen(MyGdxGame game) {
        this.game = game;
    }

    private void setViewport() {
        game.viewport = new ScalingViewport(Scaling.none,1920,1080,game.camera);
        game.camera.setToOrtho(false, 1920, 1080);
    }
    private void fontCreation() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("Cloude_Regular_Bold_1.02.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 500;
        font12 = generator.generateFont(parameter);
    }


    private void setPlayButton() {
        playButtonImage = new Texture(Gdx.files.internal("playButton.png"));
        playButton = new Rectangle();
        playButton.x = 96;
        playButton.y = 412;
        playButton.width = 512;
        playButton.height = 256;
    }

    private void setShopButton() {
        shopButtonImage = new Texture(Gdx.files.internal("shopButton.png"));
        shopButton = new Rectangle();
        shopButton.x = 704;
        shopButton.y = 412;
        shopButton.width = 512;
        shopButton.height = 256;
    }

    private void setExitButton() {
        exitButtonImage = new Texture(Gdx.files.internal("exitButton.png"));
        exitButton = new Rectangle();
        exitButton.x = 1312;
        exitButton.y = 412;
        exitButton.width = 512;
        exitButton.height = 256;
    }

    private void setBackground() {
        backgroundImage = new Texture(Gdx.files.internal("caveFlipBackground.png"));
        background = new Rectangle();
        background.x = 0;
        background.y = 0;
        background.width = 1920;
        background.height = 1080;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });


        setPlayButton();
        setShopButton();
        setExitButton();
        fontCreation();
        setBackground();
        setViewport();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(backgroundImage, background.x, background.y);
        game.batch.draw(playButtonImage, playButton.x, playButton.y);
        game.batch.draw(shopButtonImage, shopButton.x, shopButton.y);
        game.batch.draw(exitButtonImage, exitButton.x, exitButton.y);
        font12.draw(game.batch, "CAVEFLIP", 450, 940);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.camera.unproject(touchPos);
            if (playButton.contains(touchPos.x, touchPos.y)) {
                game.setScreen(new GameScreen(game));
            } else if (shopButton.contains(touchPos.x, touchPos.y)) {
                game.setScreen(new ShopScreen(game));
            } else if (exitButton.contains(touchPos.x, touchPos.y)) { //CREATE A STAGE AND ADD ALL VARIABLES TO STAGE - more efficient (you got this bb cakes)
                System.exit(0);
            }
        }
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

    }

    @Override
    public void dispose() {
        generator.dispose();
    }
}