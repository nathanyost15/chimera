package com.vishera.chimera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishera.chimera.gsm.GSM;
import com.vishera.chimera.gsm.GameStateRunner;
import com.vishera.chimera.states.Level_1;
import com.vishera.chimera.states.MainMenu;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Chimera extends ApplicationAdapter {
	private static final GameStateRunner gsr = new GameStateRunner();

	@Override
	public void create () {
		initGameWindow();
		GSM.push(new Level_1());
	}

	private void initGameWindow() {
		Gdx.graphics.setWindowedMode(1920, 1080);
		//Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
	}

	@Override
	public void render () {
		gsr.run();
	}
	
	@Override
	public void dispose () {
	}
}
