package com.vishera.chimera.gsm;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public abstract class GameState {
    private GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        log.debug("Initialized state: " + this.getClass().getCanonicalName());
        this.gsm = gsm;
    }

    public abstract void render();
    public abstract void update();
}
