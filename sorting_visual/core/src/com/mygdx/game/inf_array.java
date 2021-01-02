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

    //selection stuff
    private int curr;
    private int biggestval;
    private int currentlength;
    private int tempval;



    public inf_array(int a){
        length = 0;
        arr = new gcol[a];// array length
        loc_width =20;
        loc_height = 10;
        size_width = 10;
        max_size = 500;
        check_rng = 0;
        check = new int[a];
        curr=0;
        currentlength=a;
        
        

        init_array(a,arr);// array filled here

    }
        public void re_init_array(int a){
            arr = new gcol[a];
            init_array(a, arr);


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
     //////////////////////////////////////selection sort here//////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////         



    public long selectionSort(){
    if(currentlength ==0){
        donegreen();
    return TimeUtils.nanoTime();
    }
    if(curr ==0) {//if this is the first element
        curbig(curr);
        biggestval=curr;
        curr++;
        return TimeUtils.nanoTime();
    }else if(curr <currentlength){// gen case
         if(curr-1 != biggestval)
             deSelect(curr-1);

        if(isbigger(biggestval,curr)==true){//if the current biggest value is smaller then this new one
            deSelect(biggestval);
            biggestval =curr;
            curbig(biggestval);
        }
        else
            highlight(curr); 
            curr++;
        return TimeUtils.nanoTime();
    }else{// after last element
        deSelect(biggestval);
        highlight(currentlength-1);

        swap(biggestval,currentlength-1);



        currentlength--;
       
        curr=0;
        return TimeUtils.nanoTime();
        }    
    }

    private boolean isbigger(int a,int b){// true if a is less then b
        if(arr[a].get_height_shape()<arr[b].get_height_shape())
            return true;
        else
            return false;
    }
    private void swap(int a,int b){
        tempval = arr[a].get_height_shape();
        arr[a].set_height_shape(arr[b].get_height_shape());
        arr[b].set_height_shape(tempval);


    }
    


         //////////////////////////////////////selection sort here//////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
    private void green(int a){
        arr[a].set_color(Color.GREEN);
    }
    private void curbig(int a){
        arr[a].set_color(Color.BLUE);
    }
    private void highlight(int a){//turns arr[a] red
        arr[a].set_color(Color.RED);
    }
    private void deSelect(int a){//turns arr[a] yellow
        arr[a].set_color(Color.YELLOW);
    }
    
        private void donegreen(){
            for (int i = 0; i < arr.length; i++) {
                green(i);
                
            }
        }

        private void randomify(int a){
                check_rng = (int)(Math.random()*a);
                //check_rng =getRandomNumber(arr.length);
                col_temp =arr[a];
                arr[a].set_height_shape(arr[check_rng].get_height_shape());


                arr[check_rng].set_height_shape(col_temp.get_height_shape());

        }

        
          //  here live a group of getter that i made because im dumb
       
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

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
   
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

    private int getRandomNumber(int a) {
        return (int) ((Math.random() * (a - 1)) + 1);
    }


}
