package com.mygdx.game;

public  class insertion_sort {
    private gcol[] arr;

    private int length;
    private int curr; 
    private int comp;

    public insertion_sort(gcol[]a){
        arr=a;
        length = arr.length;
        curr = 0;
        comp=0;
        
    }
    public gcol[] insertionsort(){
        arr[curr+1].cyan();
        if(curr ==0){
            arr[curr].blue();
            curr++;
           
        }else if(curr == length){
            arr[curr].blue();

            

        }else{
            arr[curr].blue();
           // step(comp,curr);

            curr++;
        }
        return arr;


    }
    public void step(int last,int checking){
        if(arr[last].get_height_shape()>arr[checking].get_height_shape()){


        }
        

    }

    
}
