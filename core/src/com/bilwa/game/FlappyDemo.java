package com.bilwa.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bilwa.game.states.GameStateManager;
import com.bilwa.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	public static final int WIDTH=480;
	public static final int HEIGHT=800;

	public static final String TITLE="Flappy Bird";
	private GameStateManager gsm;
	private SpriteBatch batch;
	//SpriteBatch batch;
	Texture img;
	private Music music;
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm=new GameStateManager();
		music=Gdx.audio.newMusic(Gdx.files.internal("android_assets_music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
		img = new Texture("badlogic.jpg");
		ScreenUtils.clear(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		music.dispose();
	}
}
