package com.mcelrea;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Title implements Screen {

    SpriteBatch batch;
    Texture titleImage;
    BitmapFont debugFont;

    @Override
    public void show() {

        batch = new SpriteBatch();
        titleImage = new Texture(Gdx.files.internal("menu screen.png"));
        debugFont = new BitmapFont();
        debugFont.setColor(Color.BLACK);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        checkForMouseClicks();

        batch.begin();
        batch.draw(titleImage, 0, 0);
        debugFont.draw(batch, "x=" + Gdx.input.getX(), 10, 420);
        debugFont.draw(batch, "y=" + Gdx.input.getY(), 10, 400);
        batch.end();

    }

    public void checkForMouseClicks() {
        //if the left mouse button is pressed
        if(Gdx.input.isButtonPressed(0)) {

            System.out.println("lkjwsdf");
            //store the mouse position
            int x = Gdx.input.getX();
            int y = Gdx.input.getY();

            //if they clicked on the EXIT button
            if(x > 275 && y > 355 && x < 518 && y < 455) {
                System.out.println("exit");
                Gdx.app.exit();
            }

            //if they clicked on the PLAY button
            if(x > 275 && y > 217 && x < 518 && y < 319) {
                ((Game)Gdx.app.getApplicationListener()).setScreen(new Gameplay());
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
