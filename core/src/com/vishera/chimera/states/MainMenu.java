package com.vishera.chimera.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.vishera.chimera.gsm.GameState;
import com.vishera.chimera.gsm.GSM;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainMenu extends GameState {
    @Override
    public void render() {

    }

    @Override
    public void update() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            log.debug("Switching state to level_1");
            GSM.push(new Level_1());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
        }
    }
}
