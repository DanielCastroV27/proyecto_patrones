package com.mygdx.proyecto_patrones;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.proyecto_patrones.screens.MainMenuScreen;

public class RPGGame extends Game {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));

	}

	@Override
	public void render () {
		super.render();

	}
}
