package com.vishera.chimera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishera.chimera.gsm.GameState;
import com.vishera.chimera.gsm.GameStateManager;
import com.vishera.chimera.gsm.GameStateRunner;
import com.vishera.chimera.states.MainMenu;

public class Chimera extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private static final GameStateManager gsm = new GameStateManager();
	private static final GameState baseGameState = new MainMenu(gsm);
	private static final GameStateRunner gsr = new GameStateRunner(gsm);

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		gsm.push(baseGameState);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		gsr.run();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
