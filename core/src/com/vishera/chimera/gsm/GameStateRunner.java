package com.vishera.chimera.gsm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameStateRunner {
    public void run() {
        var gameState = GSM.getCurrentGameState();
        render(gameState);
        update(gameState);
    }

    private void render(GameState gameState) {
        clearGraphicsBuffer();
        gameState.render();
    }

    private void clearGraphicsBuffer() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void update(GameState gameState) {
        gameState.update(Gdx.graphics.getDeltaTime());
    }
}
