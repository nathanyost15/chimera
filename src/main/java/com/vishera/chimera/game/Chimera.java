package com.vishera.chimera.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

@Slf4j
@Getter
public class Chimera implements Runnable {
    private static boolean running;
    private static long gameWindow;
    private int screenWidth;
    private int screenHeight;
    private boolean fullScreen;

    Chimera(String[] args) {
        if(args.length != 3) {
            log.error("Need to provide screenWidth, screenHeight, and fullScreen=true/false");
            throw new IndexOutOfBoundsException(String.format("Required 3 args but %s given", args.length));
        }
        screenWidth = Integer.parseInt(args[0]);
        screenHeight = Integer.parseInt(args[1]);
        fullScreen = Boolean.parseBoolean(args[2]);
    }

    @Override
    public void run() {
        try {
            startGame();
            runGame();
        } catch (Exception exception) {
            log.error("Unhandled exception thrown during run: ", exception);
        }
    }

    public void stopGame() {
        log.info("Game requested stop");
        running = false;
    }

    public void startGame() {
        log.info("Starting game");
        running = true;
    }

    private void init() throws Exception {
        log.info("Initializing game");
        if(!glfwInit()) {
            throw new Exception("Could not initialize game!");
        }

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        gameWindow = glfwCreateWindow(screenWidth, screenHeight, "Chimera", NULL, NULL);
        log.debug("GameWindow index = " + gameWindow);

        var screenStruct = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(gameWindow, (screenStruct.width() - screenWidth) / 2, (screenStruct.height() - screenHeight) / 2);
        glfwMakeContextCurrent(gameWindow);
        glfwShowWindow(gameWindow);
    }

    private void runGame() throws Exception{
        init();
        log.info("Game loop started");
        while(running) {
            update();
            render();
            if(glfwWindowShouldClose(gameWindow)) {
                stopGame();
            }
        }
        log.info("Game loop finished");
    }

    private void render() {
        glfwSwapBuffers(gameWindow);
    }

    private void update() {
        glfwPollEvents();
    }
}
