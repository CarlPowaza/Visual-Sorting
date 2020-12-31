package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class inf_array {

    private gcol[] arr;// initulize array of my columns
    private int length;
    private int loc_width;/// how far from left render starts
    private int loc_height;// how far from bottom render starts

    private int size_width;///how wide the rect is
    private int max_size;





    public inf_array(int a){
        length = a;
        arr = new gcol[a];
        loc_width =20;
        loc_height = 120;
        size_width = 10;
        max_size = 500;
        init_array(a,arr);
      
    }
    
        public int rwp(int a){// return_width_pos
            return  arr[a].get_width_pos();

        }
        public int rhp(int a){//return_height_pos
            return arr[a].get_height_pos();

        }
        public int rws(int a){//return_width_shape
            return arr[a].get_width_shape();

        }
        public int rhs(int a){//return_height_shape
            return arr[a].get_height_shape();

        }
        public Color rcv(int a){ //return_color_value
            return arr[a].get_color();
        }
        public void scv(int a,Color b){ //set_color_value
            arr[a].set_color(b);
        }

        




    private void init_array(int a,gcol[] arr){
        for (int i = 0; i < a; i++) {
            arr[i]= new gcol(loc_width*(i+1),loc_height,size_width,getRandomNumber());
            
        }

    }

    private int getRandomNumber() {
        return (int) ((Math.random() * (max_size - 1)) + 1);
    }


}
   /*  private int[] arr;
    private int length;
    public int colorthis=0;
   
    public inf_array(int a){
        arr = new int[a];
        length=a;
        numgen();
        print();
        


    }
    private void numgen(){
        for (int i = 0; i < length; i++) {
            arr[i]= getRandomNumber();  
        }

    }
    public Color node_color(int a){
        if(a == colorthis)
        return Color.RED;
        else
        return  Color.YELLOW;
    }
    public int node_info(int a){
        return arr[a];



    }
    public void print(){
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]+" ");
            
        }
    }
    private int getRandomNumber() {
        return (int) ((Math.random() * (500 - 1)) + 1);
    }
    
}
 */