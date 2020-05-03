package com.vishera.chimera.game;

import lombok.extern.slf4j.Slf4j;

import static com.vishera.chimera.constants.Constants.GAME;

@Slf4j
public class Application {

    public static void main(String[] args) {
        try {
            log.info("Starting thread: " + GAME);
            var gameThread = new Thread(new Chimera(args), GAME);
            gameThread.start();
            gameThread.join();
            log.info("Thread: " + GAME + " terminated");
        } catch (Exception exception) {
            log.error("Unhandled exception thrown at application: ", exception);
        }
    }
}
