package com.vishera.chimera.models;

import com.badlogic.gdx.graphics.Texture;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private float x;
    private float y;
    private float width;
    private float height;
    private float speed;
    private Texture texture;


    public Player() {
        x = 0f;
        y = 0f;
        width = 190f;
        height = 190f;
        speed = 500f;
        texture = new Texture("data/0_Reaper_Man_Idle_000.png");
    }

    public void moveUp(float deltaTime) {
        y += speed * deltaTime;
    }

    public void moveDown(float deltaTime) {
        y -= speed * deltaTime;
    }

    public void moveRight(float deltaTime) {
        x += speed * deltaTime;
    }

    public void moveLeft(float deltaTime) {
        x -= speed * deltaTime;
    }
}
