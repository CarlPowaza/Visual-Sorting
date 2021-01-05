package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;

public class inf_array {

    private gcol[] arr;// initulize array of my columns
    private int[] check;
    private int length;
    private int loc_width;/// how far from left render starts
    private int loc_height;// how far from bottom render starts
    private int check_rng;
    private int size_width;///how wide the rect is
    private int max_size;
    private gcol col_temp;
    selection_sort sel_sort;
    insertion_sort ins_sort;


    public inf_array(int a){
        length = 0;
        arr = new gcol[a];// array length
        loc_width =20;
        loc_height = 10;
        size_width = 10;
        max_size = 500;
        check_rng = 0;
        check = new int[a];
        

        init_array(a,arr);// array filled here
        sel_sort = new selection_sort(arr);
        ins_sort = new insertion_sort(arr);
    }
        public void re_init_array(int a){
            arr = new gcol[a];
            init_array(a, arr);
            // pass through new gcol[] here
            sel_sort = new selection_sort(arr);


        }
        public long do_insertionSort(){
            arr = ins_sort.insertionsort();

            return TimeUtils.nanoTime();
        }

        public long do_selectionSort(){
           
            if(check_sorted()==true)
            donegreen();
            else
            arr = sel_sort.selectionSort();

            return TimeUtils.nanoTime();


        }
        public void monkeysort(){
            if(check_sorted()!=true)
            {
                if(length == arr.length)
                     length=0;
                  else{
                     randomify(length);
                     length++;
            }
        
          }
        }

 



            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    private void donegreen(){
        for (int i = 0; i < arr.length; i++) {
           arr[i].green();
        }
        }
    
    private void randomify(int a){
        check_rng = (int)(Math.random()*a);
        //check_rng =getRandomNumber(arr.length);
        col_temp =arr[a];
        arr[a].set_height_shape(arr[check_rng].get_height_shape());


        arr[check_rng].set_height_shape(col_temp.get_height_shape());

}

    private boolean check_sorted(){

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1].get_height_shape()>arr[i].get_height_shape())
                return false;          
        }
        return true;
    }
  

    private void init_array(int a,gcol[] arr){
        for (int i = 0; i < a; i++) {
            arr[i]= new gcol(loc_width*(i+1),loc_height,size_width,getRandomNumber(max_size));
            
        }
        
    }
    private int getRandomNumber(int a) {
        return (int) ((Math.random() * (a - 1)) + 1);
    }
    

    private int checknums(int a){
        //put an array and test if num been used
        check_rng = getRandomNumber(max_size);
        if(a==0)
        {
            check[0]=check_rng;
            return check_rng;
        }
        else{
        for (int i = 0; i < a; i++) {
            
            if(check[i]== check_rng)
            {
                i = -1;
                check_rng = getRandomNumber(max_size);
            }
            
        }
    }
        check[a]=check_rng;
        return check_rng;
    }


              //  here live a group of getter that i made because im dumb
       
              public int rwp(int a){ return  arr[a].get_width_pos();}// return_width_pos
              public int rhp(int a){return arr[a].get_height_pos();}//return_height_pos
              public int rws(int a){return arr[a].get_width_shape();}//return_width_shape
              public int rhs(int a){return arr[a].get_height_shape();}//return_height_shape
              public Color rcv(int a){return arr[a].get_color(); } //return_color_value
              public void scv(int a,Color b){  arr[a].set_color(b); }//set_color_value


}
