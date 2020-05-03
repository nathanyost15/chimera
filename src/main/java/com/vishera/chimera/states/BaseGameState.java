package com.vishera.chimera.states;

import com.vishera.chimera.gsm.GSM;
import com.vishera.chimera.input.Keyboard;
import lombok.extern.slf4j.Slf4j;

import static org.lwjgl.glfw.GLFW.*;

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
        if(Keyboard.getKey(GLFW_KEY_SPACE)) {
            log.debug("Space bar is pressed!");
        }
    }
}