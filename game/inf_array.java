package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

public class inf_array {

    private gcol[] arr;// initulize array of my columns
    private int[] check;
    private int length;
    private int loc_width;/// how far from left render starts
    private int loc_height;// how far from bottom render starts
    private int check_rng;
    private int size_width;///how wide the rect is
    private int max_size;
    private gcol temp;
    private boolean bogo_done;





    public inf_array(int a){
        length = 0;
        arr = new gcol[a];
        loc_width =20;
        loc_height = 120;
        size_width = 10;
        max_size = 500;
        check_rng = 0;
        check = new int[a];
        bogo_done = false;
        init_array(a,arr);
    
       
        // i dont like having duplicates so ima just check against a array of used values
       
      

    }
        public void monkeysort(){
            if(bogo_done ==false)
                if(length == arr.length)
                {
                        if(check_sorted()==false)
                        {
                            bogo_done=true;
                        }

                }
                randomify(length);
                length++;
            }
               

        }
        private void randomify(int a){
                temp =arr[a];
                arr[a]= arr[getRandomNumber(arr.length)];


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