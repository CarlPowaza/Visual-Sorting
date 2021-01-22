
     
<h1>Visual Sorting<!h1>




<a href="https://ibb.co/Vvgkt7M"><img src="https://i.ibb.co/kh4PxRq/vis-sort.png" alt="vis-sort" border="0"></a>

<h2>About</h2>
<p>
I made this project over winter break right after taking a data structures class.Ilearned quite a bit about even driven programming.It was my first time working with a framework or making any sort of application<br>I used the <a href="https://libgdx.badlogicgames.com/">libgdx game framework</a> to implement the project.<br><br><br>
</p>
  <p>
  <h2>How It works</h2>
    To run the program.Go to sorting_visual\desktop\src\com\mygdx\game\desktop <br>
    all of the code is in Sorting-graph-visually\sorting_visual\core\src\com\mygdx\game
     
  </p><p>
     The app.java file in screens is where all the events happen as well as rendering rectangles using values from an array of gcol objects.
    the program refreshes the rectangle size by checking if the current time is > saved time + a speed variable(vis_speed).I also used this refresh as a bottleneck for the sorting.Instead of using a loop, I just had if statements and the method is called only when updating the rectangles.
    
  </p>
  <p>
 <br>
The only sorting algorithm that works right now is selection sort.I'm Currently busy with school but I do plan on adding more starting with insertion sort,which I have already started working on.
 </p>


  
