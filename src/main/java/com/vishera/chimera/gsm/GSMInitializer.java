package com.vishera.chimera.gsm;

import com.vishera.chimera.input.Keyboard;
import lombok.extern.slf4j.Slf4j;
import org.lwjgl.opengl.GL;

import static com.vishera.chimera.constants.Constants.CHIMERA;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

@Slf4j
public class GSMInitializer {

    public static void init(GSM gsm) throws Exception{
        log.info("Initializing game window");
        if(!glfwInit()) {
            throw new Exception("Could not initialize game window!");
        }
        var screenWidth = gsm.getScreenWidth();
        var screenHeight = gsm.getScreenHeight();
        var gameWindow = getNewGameWindow(screenWidth, screenHeight);
        setWindowPositionOnScreen(gameWindow, screenWidth, screenHeight);
        setKeyCallbacks(gameWindow);
        setWindowInContext(gameWindow);
        gsm.setGameWindow(gameWindow);
    }

    private static void setWindowInContext(long gameWindow) {
        glfwMakeContextCurrent(gameWindow);
        glfwShowWindow(gameWindow);
        GL.createCapabilities();
        glClearColor(0f, 0f, 0f, 0f);
        glEnable(GL_DEPTH_TEST);
        log.info("Using OpenGL version: " + glGetString(GL_VERSION));
    }

    private static void setKeyCallbacks(long gameWindow) {
        glfwSetKeyCallback(gameWindow, new Keyboard());
    }
    private static void setWindowPositionOnScreen(long gameWindow, int screenWidth, int screenHeight) {
        var screenStruct = glfwGetVideoMode(glfwGetPrimaryMonitor());
        glfwSetWindowPos(gameWindow, (screenStruct.width() - screenWidth) / 2, (screenStruct.height() - screenHeight) / 2);
    }

    private static long getNewGameWindow(int screenWidth, int screenHeight) {
        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        return glfwCreateWindow(screenWidth, screenHeight, CHIMERA, NULL, NULL);
    }
}
