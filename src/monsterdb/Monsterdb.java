/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monsterdb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.MenuItem;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.Timer;

/**
 *
 * @author dev
 */
public class Monsterdb extends Application {
      int life=0;
      int love=0;
      ImageView view;
      Group root=new Group(); 
    @Override
    public void start(Stage stage) { 
        Label menu=new Label();
        menu.setText("สัตว์เลี้ยงน่ารักของคุณ");
        Timer timer=new Timer(6000,new TimerListener());
        timer.start();
            try(FileReader reader=new FileReader("db.properties")){
                    Properties properties=new Properties();
                    properties.load(reader);
                    life=Integer.parseInt(properties.getProperty("db.life"));
                    love=Integer.parseInt(properties.getProperty("db.love"));
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
           if(life<1000){
            view=new ImageView("monsterdb/animation/egg_basic.gif");
            root.getChildren().add(view);
        root.getChildren().add(menu);
        Scene scene = new Scene(root,300, 250,Color.TRANSPARENT);
            
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setText("เค้ายังเป็นไข่อยู่เลย..");
            }
        });
        view.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setText("สัตว์เลี้ยงน่ารักของคุณ");
            }
        });
        view.setEffect(new Reflection());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setX(1200);
        stage.setY(550);
        stage.setTitle("Pet");
        stage.setScene(scene);
        stage.show();
            }else if(life>1000){
             view=new ImageView("monsterdb/animation/bunkhouse_smoke.gif");
             root.getChildren().add(view);
        root.getChildren().add(menu);
        Scene scene = new Scene(root,300, 250,Color.TRANSPARENT);
           
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setText("เค้าอยู่ในบ้านหลังใหญ่แล้วนะ");
            }
        });
        view.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setText("สัตว์เลี้ยงน่ารักของคุณ");
            }
        });
        view.setEffect(new Reflection());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setX(1200);
        stage.setY(550);
        stage.setTitle("Pet");
        stage.setScene(scene);
        stage.show();
            }else{
        root.getChildren().add(view);
        root.getChildren().add(menu);
        Scene scene = new Scene(root,300, 250,Color.TRANSPARENT); 
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.setText("Internet เค้าหายไปไหน");
            }
        });
        view.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                menu.setText("สัตว์เลี้ยงน่ารักของคุณ");
            }
        });
        view.setEffect(new Reflection());
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setX(1200);
        stage.setY(550);
        stage.setTitle("Pet");
        stage.setScene(scene);
        stage.show();
        }
           ContextMenu contextMenu = new ContextMenu();
                MenuItem power=new MenuItem("พลังงาน");
                power.setOnAction(ActionEvent->menu.setText("พลังงาน '"+life+"' ความรัก '"+love+"'"));
                MenuItem foot = new MenuItem("อาหาร");
                foot.setOnAction(ActionEvent->{
                   menu.setText("อร่อยจุง");
                   life+=100;
                });
                MenuItem play = new MenuItem("ความรัก");
                play.setOnAction(ActionEvent->{
                    menu.setText("ขอบคุณสำหรับความรัก จุ๊บๆ");
                    love++;
                            });
                MenuItem exit = new MenuItem("นอน");
                exit.setOnAction(ActionEvent->{
                    Properties prop=new Properties();
                    prop.setProperty("db.life", String.valueOf(life));
                    prop.setProperty("db.love", String.valueOf(love));
                    try {
                        File f = new File("db.properties");
                        OutputStream out = new FileOutputStream( f );
                        prop.store(out, null);
                        System.exit(0);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Monsterdb.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Monsterdb.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                });
                MenuItem about=new MenuItem("ไข่เกิดจากอะไร ?");
                about.setOnAction(AcitonEvent->{
                    menu.setText("kokinoxp@gmail.com ผู้สร้างไข่");
                });
                contextMenu.getItems().addAll(power,foot,play,exit,about);
                menu.setContextMenu(contextMenu);       
    }   
  private class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            life--;
            
        }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
