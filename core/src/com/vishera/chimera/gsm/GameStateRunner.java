package com.vishera.chimera.gsm;

public class GameStateRunner {
    private GameStateManager gsm;

    public GameStateRunner(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public void run() {
        var gameState = gsm.getCurrentGameState();
        render(gameState);
        update(gameState);
    }

    private void render(GameState gameState) {
        gameState.render();
    }

    private void update(GameState gameState) {
        gameState.update();
    }
}
