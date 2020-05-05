package com.vishera.chimera.gsm;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class GameStateManager {
    private static final Stack<GameState> gameStates = new Stack<>();

    public void push(GameState gameState) {
        log.debug(String.format("Adding new state to GSM %s", gameState.getClass().getCanonicalName()));
        gameStates.push(gameState);
    }

    public GameState pop() {
        var oldGameState = gameStates.peek();
        if(gameStates.size() > 1) {
            log.debug(String.format("Removing game state from GSM %s", gameStates.peek().getClass().getCanonicalName()));
            gameStates.pop();
        }
        return oldGameState;
    }

    public GameState replaceState(GameState newGameState) {
        var oldGameState = pop();
        push(newGameState);
        return oldGameState;
    }

    public GameState getCurrentGameState() {
        return gameStates.peek();
    }
}
