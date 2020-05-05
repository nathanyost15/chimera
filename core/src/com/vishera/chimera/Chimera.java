package com.vishera.chimera;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.vishera.chimera.gsm.GSM;
import com.vishera.chimera.gsm.GameStateRunner;
import com.vishera.chimera.states.MainMenu;

public class Chimera extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	private static final GameStateRunner gsr = new GameStateRunner();

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		GSM.push(new MainMenu());
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
