package com.NKSA.application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application implements Runnable {

	public ImageView img,bala,fondo;
	Stage window;
	Pane root;
	Image dragonimg = new Image("/com/NKSA/multi/dragon.jpeg");
	ImageView dragon = new ImageView(dragonimg);
	Thread hilo,ct,hilo2,dragonmove;
	int x,x1,posx,dirx;
	int y,y1,posy,diry;
	boolean balaon;
	ArrayList<ImageView> dragonlist;
	String 	a ="Ahora si puerk";
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			root = new Pane();
			Scene scene = new Scene(root,400,400);
			Image grifo = new Image("/com/NKSA/multi/grifo.jpeg");
			Image b = new Image("/com/NKSA/multi/bala.gif");
			Image fondoimg = new Image("/com/NKSA/multi/fondo.jpeg");
			fondo = new ImageView();
			fondo.setImage(fondoimg);

			bala = new ImageView();
			bala.setImage(b);
			bala.setLayoutX(-1000);
			bala.setLayoutY(-1000);
			img = new ImageView();
			y = 100;
			x = 100;
			x1 = 150;
			posx = 300;
			dirx = 200;
			diry = 600;
			balaon=true;
			dragon.setX(100);
			dragon.setY(100);
			root.setOnMouseClicked(e ->{
				start2();
				});
			img.setOnKeyPressed(new EventHandler<KeyEvent>() {
				public void handle(KeyEvent move) {
				if (move.getCode().equals(KeyCode.RIGHT) || move.getCode().equals(KeyCode.D)) {
					if (x<1300 && y>=0 && y<720) {
						x = x+3;
					}
				}else if(move.getCode().equals(KeyCode.LEFT) || move.getCode().equals(KeyCode.A)) {
					if (x>=0 && y>=0 && y<720) {
						x = x-3;
					}
				}else if (move.getCode().equals(KeyCode.UP) || move.getCode().equals(KeyCode.W)) {
					if (x<1300 && x>=0 && y>=-10) {
						y = y-3;
					}
				}else if(move.getCode().equals(KeyCode.DOWN) || move.getCode().equals(KeyCode.S)) {
					if (x<1300 && x>=0 && y<720) {
						y = y+3;
					}
				}else if(move.getCode().equals(KeyCode.E)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y-3;
						x = x+3;
					}
				}else if(move.getCode().equals(KeyCode.C)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y+3;
						x = x+3;
					}
				}else if(move.getCode().equals(KeyCode.Z)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y+3;
						x = x-3;
					}
				}else if(move.getCode().equals(KeyCode.Q)) {
					if (x<1300 && x>=0 && y>=0 && y<720) {
						y = y-3;
						x = x-3;
					}
				}else if(move.getCode().equals(KeyCode.SPACE)) {
					if (balaon == true) {
						x1 = x;
						y1 = y;
						posx = (int) (Math.random()*1200);
						posy = (int) (Math.random()*700);
						dragon.relocate(posx,posy);
						bala.relocate(x, y);
						start1();
						balaon = false;
					}

					
				}
				updateimg();
			  }
			});
			img.setFocusTraversable(true);
			img.setLayoutX(100);
			img.setLayoutY(100);
			img.setImage(grifo);
			window.setFullScreen(true);
			
			root.getChildren().addAll(fondo,img,dragon,bala);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void updateimg() {
		img.relocate(x, y);
	}


	@Override
	public void run() {
		ct = Thread.currentThread();
			try {
				if(ct == hilo) {
				while(true) {
						while(x1<1500) {
							Thread.sleep(25);
							x1 = x1+5;
							bala.relocate(x1,y1);
						}
						hilo.getState();
						balaon = true;
						bala.relocate(-100000, -1000000);
						hilo = null;
				}
				}else if(ct == hilo2) {
					while(true) {
						while(dirx != posx) {
							if(posx>dirx) {
								Thread.sleep(25);
								posx = posx-1;
								dragon.relocate(posx, posy);
							}else if(posx<dirx) {
								Thread.sleep(25);
								posx = posx+1;
								dragon.relocate(posx, posy);
							}
							
							}while(diry != posy) {
								if(posy>diry) {
									Thread.sleep(25);
									posy = posy-1;
									dragon.relocate(posx, posy);
									hilo2=null;
								}else if(posy<diry) {
									Thread.sleep(25);
									posy = posy+1;
									dragon.relocate(posx, posy);
									hilo2=null;
								}
							}hilo2 = null;
					}
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	public void start1() {
		hilo = new Thread(this);
		hilo.start();
	}
	public void start2() {
		dragonmove = new DragonThread("First drake");
		dragonmove.start();
	}
	public void updateDrake(int posx, int posy)  {
		System.out.println(posx);
		System.out.println("Hola");
	}
	
	public void dragonspam() {
			dragon = new ImageView();
			dragon.setImage(dragonimg);
			dragon.setX(Math.random()*1200);
			dragon.setY(Math.random()*800);
			root.getChildren().addAll(dragon);
		
	}
	public void automove(int dirx, int diry){
		while(dirx != posx) {
			if(posx>dirx) {
				posx = posx-5;
				dragon.relocate(posx, posy);
			}else if(posx<dirx) {
				posx = posx+5;
				dragon.relocate(posx, posy);
			}
			
			}while(diry != posy) {
				if(posy>diry) {
					posy = posy-5;
					dragon.relocate(posx, posy);
					hilo2=null;
				}else if(posy<diry) {
					posy = posy+5;
					dragon.relocate(posx, posy);
					hilo2=null;
				}
			}
		}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	}
