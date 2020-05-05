package com.vishera.chimera.gsm;

public class GameStateRunner {
    public void run() {
        var gameState = GSM.getCurrentGameState();
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
