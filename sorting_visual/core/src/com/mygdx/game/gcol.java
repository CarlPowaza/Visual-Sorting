package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class gcol {// graph columns    
       private int width_pos;
       private int height_pos;
       private int width_shape;
       private int height_shape;// this is what we will be sorting
       private Color cur_color;
      

       

        public gcol(int a,int b,int c,int d){
            width_pos =a;
            height_pos=b;
            width_shape =c;
            height_shape=d;
            cur_color = Color.YELLOW;
            
        }
        public int get_width_pos(){
            return width_pos;

        }
        public int get_height_pos(){
            return height_pos;

        }
        public int get_width_shape(){
            return width_shape;

        }
        public int get_height_shape(){
            return  height_shape;

        }
        public Color get_color(){
            return cur_color;
        }
        public void set_color(Color a){
           cur_color= a;
        }
      

}
