package com.vishera.chimera.game;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String[] args) {
        try {
            new Thread(new Chimera(args), "GameThread").start();
        } catch (Exception exception) {
            log.error("Unhandled exception thrown at application: ", exception);
        }
    }
}
