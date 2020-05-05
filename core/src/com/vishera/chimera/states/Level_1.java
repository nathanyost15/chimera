package com.vishera.chimera.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishera.chimera.gsm.GameState;
import com.vishera.chimera.models.Player;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Level_1 extends GameState {
    SpriteBatch batch;
    Player player;

    public Level_1() {
        batch = new SpriteBatch();
        player = new Player();
    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(player.getTexture(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
        batch.end();
    }

    @Override
    public void update(float deltaTime) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            player.moveUp(deltaTime);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            player.moveDown(deltaTime);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.moveRight(deltaTime);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.moveLeft(deltaTime);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.getTexture().dispose();
    }
}
