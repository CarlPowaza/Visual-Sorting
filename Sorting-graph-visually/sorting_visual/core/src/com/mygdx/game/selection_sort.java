package com.mygdx.game;


public class selection_sort {
    private gcol[] arr;
    private int curr;
    private int biggestval;
    private int currentlength;
    private int tempval;

    public selection_sort(gcol[]a){
        arr=a;
        curr=0;
        currentlength= a.length;
    }
    public gcol[] selectionSort(){
        if(currentlength ==0){
           // donegreen(); THIS IS THE END
        return arr;
        }
        if(curr ==0) {//if this is the first element
            arr[curr].blue();
            biggestval=curr;
            curr++;
            return arr;
        }else if(curr <currentlength){// gen case
             if(curr-1 != biggestval)
                 arr[curr-1].deSelect();
    
            if(isbigger(biggestval,curr)==true){//if the current biggest value is smaller then this new one
                arr[biggestval].deSelect();
                biggestval =curr;
                arr[biggestval].blue(); 
            }
            else
                arr[curr].red(); 
                curr++;
                return arr;
        }else{// after last element
            arr[biggestval].deSelect();
            
            arr[currentlength-1].red();
           
    
            swap(biggestval,currentlength-1);
    
    
    
            currentlength--;
           
            curr=0;
            return arr;
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
    
}
