package com.mygdx.game;

import com.badlogic.gdx.Game;

import com.mygdx.game.screens.app;


// launcher 
public class sortVis extends Game {
    app app;
	@Override
	public void create () {
		app = new app();
		this.setScreen(app);
	}


}
