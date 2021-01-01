package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class shapeDisplay {
        private OrthographicCamera cam;
        ShapeRenderer shapes;

        public shapeDisplay(){

        }
        public void bar(){
            shapes.setProjectionMatrix(cam.combined);
            shapes.begin(ShapeType.Filled);
            shapes.setColor(Color.YELLOW);
            shapes.rect(20,120,10,50);//width,height
            shapes.rect(40,120,10,40);
            shapes.end();
            
    
        }

    
}
