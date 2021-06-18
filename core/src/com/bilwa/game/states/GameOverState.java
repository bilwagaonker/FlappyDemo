package com.bilwa.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bilwa.game.FlappyDemo;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class GameOverState extends State{
    private Texture gameOver;
    private Texture playBtn;
    private Texture bg;
    public GameOverState(GameStateManager gsm){
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH/2, FlappyDemo.HEIGHT/2);
        gameOver=new Texture("gameover.png");
        bg=new Texture("backgroud.png");

    }
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0,0);
        sb.draw(gameOver, cam.position.x-gameOver.getWidth()/2, cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        gameOver.dispose();
        System.out.println("Background and game over disposed");
    }
}
