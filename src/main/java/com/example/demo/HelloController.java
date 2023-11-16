package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class HelloController {
    int max;
    int position= 1; //Variable de parcours des images du fichier
    @FXML
    public ImageView imageG;
    public ImageView imageD;

    public ImageView background;

    Timer t = new Timer();

    public void update(){
        if(position > max) position = 1;
        File directory = new File("src/main/resources/com/example/demo/assets/images");
        Image fond = new Image(directory.getAbsolutePath()+"/image"+position+".png");
        background.setImage(fond);
    }

    public HelloController(){
        max = new File("src/main/resources/com/example/demo/assets/images").listFiles().length;
        System.out.println(max);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                position+=1;
                update();
            }
        }, 0, 3000);
    }

    @FXML
    public void clickGauche() throws IOException {
        position+= 1;
        update();
    }

    public void clickDroit() {
        position+= 1;
        update();
    }
}