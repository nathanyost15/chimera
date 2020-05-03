package com.vishera.chimera.game;

import com.vishera.chimera.states.BaseGameState;
import com.vishera.chimera.gsm.GSM;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Chimera implements Runnable {
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
            log.info("Adding base game state");
            var gsm = new GSM(screenWidth, screenHeight, fullScreen);
            gsm.push(new BaseGameState(gsm));
            gsm.run();
        } catch (Exception exception) {
            log.error("Unhandled exception thrown during run: ", exception);
        }
    }
}
