package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {
    Texture texture;
    Polygon hitbox;

    public Obstacle(Texture texture, Polygon hitbox) {
        this.texture = texture;
        this.hitbox = hitbox;
    }


}
