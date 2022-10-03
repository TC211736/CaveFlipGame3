package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameScreen extends ScreenAdapter {
    MyGdxGame game;

    public GameScreen(MyGdxGame game) {
        this.game = game;
    }

    OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    float bottomLeftY = 0;
    float bottomLeftX = 0;
    float rectWidth;
    float rectHeight;
    float moveSpeed = 200;

    @Override
    public void show() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
        camera.update();

        shapeRenderer = new ShapeRenderer();
        rectWidth = Gdx.graphics.getWidth() / 2;
        rectHeight = Gdx.graphics.getHeight() / 2;

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen2(game));
                }
                return true;
            }
        });

    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            camera.translate(0, moveSpeed * Gdx.graphics.getDeltaTime());
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            camera.translate(0, -moveSpeed * Gdx.graphics.getDeltaTime());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            camera.translate(-moveSpeed * Gdx.graphics.getDeltaTime(), 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            camera.translate(moveSpeed * Gdx.graphics.getDeltaTime(), 0);
        }

        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 0, 0, 1);
        shapeRenderer.rect(bottomLeftX, bottomLeftY, rectWidth, rectHeight);
        shapeRenderer.setColor(0, 1, 0, 1);
        shapeRenderer.rect(bottomLeftX + rectWidth, bottomLeftY, rectWidth, rectHeight);
        shapeRenderer.setColor(0, 0, 1, 1);
        shapeRenderer.rect(bottomLeftX + rectWidth, bottomLeftY + rectHeight, rectWidth, rectHeight);
        shapeRenderer.setColor(1, 1, 0, 1);
        shapeRenderer.rect(bottomLeftX, bottomLeftY + rectHeight, rectWidth, rectHeight);
        shapeRenderer.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }


}