package com.vishera.chimera.input;

import org.lwjgl.glfw.GLFWKeyCallback;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class Keyboard extends GLFWKeyCallback {
    private static final Map<Integer, Boolean> keys = new HashMap<>();

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        keys.put(key, action != GLFW_RELEASE);
    }

    public static boolean getKey(int key) {
        Boolean result = keys.get(key);
        return result != null ? result : false;
    }
}
