package com.vishera.chimera.gsm;

import com.vishera.chimera.states.GameState;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

@Getter
@Setter
@Slf4j
public class GSM {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final Stack<GameState> gameStates = new Stack<>();

    private int screenWidth;
    private int screenHeight;
    private boolean running;
    private long gameWindow;

    public GSM(int screenWidth, int screenHeight, boolean fullScreen) throws Exception {
        log.info("Initializing GSM");
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        GSMInitializer.init(this);
    }

    public void push(GameState gameState) {
        log.info("Initializing new gamestate " + gameState.getClass().getCanonicalName());
        gameState.init();
        log.debug("Added new gamestate " + gameState.getClass().getCanonicalName());
        gameStates.push(gameState);
    }

    public GameState pop() {
        log.debug("Removing gamestate " + gameStates.peek().getClass().getCanonicalName());
        return gameStates.pop();
    }

    public void run() throws Exception{
        startGame();
        log.info("Game loop started");
        while(running) {
            var currentGameState = gameStates.peek();
            currentGameState.render();
            currentGameState.update();

            if(glfwWindowShouldClose(gameWindow)) {
                stopGame();
            }
        }
        log.info("Game loop ended");
    }

    public void stopGame() {
        log.info("Game requested stop");
        running = false;
    }

    public void startGame() {
        log.info("Starting game");
        running = true;
    }
}
