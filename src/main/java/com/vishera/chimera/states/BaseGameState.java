package com.vishera.chimera.states;

import com.vishera.chimera.gsm.GSM;
import lombok.extern.slf4j.Slf4j;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;

@Slf4j
public class BaseGameState implements GameState {
    private GSM gsm;

    public BaseGameState(GSM gsm) {
        this.gsm = gsm;
    }

    @Override
    public void init() {
    }

    @Override
    public void render() {
        glfwSwapBuffers(gsm.getGameWindow());
    }

    @Override
    public void update() {
        glfwPollEvents();
    }
}