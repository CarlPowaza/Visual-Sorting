package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.inf_array;

public class app implements Screen {
    OrthographicCamera cam;
    Stage stage;
    TextButton test;
    TextButton reset;
    Skin skin;  
    private ShapeRenderer shapes;
    private inf_array arr_data;//array of graph columns
    public BitmapFont font;
    public SpriteBatch batch;


    private final int screenWidth = 1280, screenHeight = 720 ;
    private long startTime=0;
    private long tempTime=0;
    private int arr_size =60;
    private int node_width =20;
    private int colorthis;
    float vis_speed=50000;
    float lol =0;
    float x = 0;
    float y =300; 
    int pulse;
    int bogo;


    public app()
    {
        startTime = TimeUtils.nanoTime();  
        shapes = new ShapeRenderer();
        initcam(); 
        arr_data = new  inf_array(arr_size);
        font = new BitmapFont();
        batch = new SpriteBatch();
        tempTime =TimeUtils.nanoTime();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        pulse =0;
        bogo=0;
        colorthis = 0;
     

    }
    private void initcam(){
        cam = new OrthographicCamera();
        cam.setToOrtho(false,screenWidth,screenHeight);
        cam.update();
    }

    @Override
    public void show() {
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        table.setPosition(x,y);
        stage.addActor(table);
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        TextButton reset= new TextButton("reset", skin);
        TextButton demo = new TextButton("pulse", skin);
        TextButton test2 = new TextButton("Sort", skin);

    
        table.add(reset).padTop(lol);
        table.add(demo).padTop(lol);
        table.add(test2).padTop(lol);

        reset.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
                pulse =0;
                bogo=0;
               arr_data.re_init_array(arr_size);
			}
			
        });  
        demo.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
                if(pulse == 0)
                    pulse =1;
                else
                    pulse =0;
					
			}
			
        });  
        test2.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
                if(bogo == 0)
                    bogo =1;
                else
                    bogo =0;
					
			}
			
		});      
    


      
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));//do actions
        stage.draw();
        showGraph();
        pulsing();
        
    }

    private void showGraph(){

        shapes.setProjectionMatrix(cam.combined);
        shapes.begin(ShapeType.Filled);

            for (int i = 0; i < arr_size; i++) {          
                 shapes.setColor(arr_data.rcv(i));                                                 //uses a bunch of getters to grab info about
                 shapes.rect(arr_data.rwp(i),arr_data.rhp(i),arr_data.rws(i),arr_data.rhs(i));//the columns from gcol
        }  
        shapes.end();

    }

    private void demo(){
        if(colorthis == arr_size-1){
            arr_data.scv(colorthis,Color.RED);
            arr_data.scv(colorthis-1,Color.YELLOW);
            colorthis++;
            tempTime= TimeUtils.nanoTime();
        
        }else if(colorthis==arr_size){
            arr_data.scv(colorthis-1,Color.YELLOW);
            colorthis=0;
            tempTime= TimeUtils.nanoTime();
        }else{
           
        arr_data.scv(colorthis,Color.RED);
        if(colorthis!=0)
        arr_data.scv(colorthis-1,Color.YELLOW);
       
        colorthis++;
        tempTime = TimeUtils.nanoTime();
        }
    }
    private void pulsing(){
        
        if(TimeUtils.nanoTime() -tempTime> vis_speed)
        {
            if(pulse == 1)
            demo();
            if(bogo ==1)
           tempTime= arr_data.selectionSort();
        }
         
    }


    private void words(){
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        font.draw(batch, "testin", 700, 700);
        batch.end();

    }
    
        
        

    
    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        stage.dispose();
        shapes.dispose();
        batch.dispose();
        font.dispose();
        

    }
    
}
