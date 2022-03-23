package com.mygdx.proyecto_patrones.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.proyecto_patrones.RPGGame;

public class Mapa implements Screen {

    RPGGame game;

    FitViewport viewport;


    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    public Mapa(RPGGame game) {

        this.game = game;
    }


    @Override
    public void show() {

        map = new TmxMapLoader().load("Map.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        camera = new OrthographicCamera();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.update(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        renderer.setView((OrthographicCamera) viewport.getCamera());

        renderer.render();

    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false,1280,1280);
        camera.translate(0,0);
        camera.update();
        viewport = new FitViewport(1280,1280,camera);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
    }
}
