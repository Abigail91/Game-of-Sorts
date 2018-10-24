package application;
	
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application implements Runnable {
	public ImageView img,bala,fondo,fondomenu,Titulo;
	Stage window;
	Stage menu = new Stage();
	Pane root = new Pane();
	Pane menuPane = new Pane();
	String actualAction = "drakefly";
	static Image dragonimg = new Image("/Multi/dragon.gif");
	public 
	Thread hilo;
	int x,x1,posx,dirx;
	int y,y1,posy,diry;
	boolean balaon;
	dragongui drake1;
	ArrayList<dragongui> drakeslist = new ArrayList<dragongui>();
	AnimationTimer timer = new AnimationTimer() {
		
			public void handle(long arg0) {
				if (actualAction.equals("updatepos")) {
					for (int i = 0; i<drakeslist.size(); i++) {
						double a = Math.random()*(1200-800)+800;
						double b = Math.random()*700;
						System.out.println(a);
						updatepos(a,b,i);	
					}actualAction = "drakefly";
						
				}
				else if(actualAction.equals("drakefly")) {
					update();
				}
			
		}
		
	};
	public void start(Stage primaryStage) {
		try {
			window = primaryStage;
			Scene scene = new Scene(root,400,400);
			Scene menuScene = new Scene(menuPane,400,400);
			Image grifo = new Image("/Multi/grifo.gif");
			Image b = new Image("/Multi/bala.gif");
			Image fondoimg = new Image("/Multi/fondo.jpeg");
			Image menuimg = new Image("/Multi/fondomenu.jpg");
			Label titulo = new Label("Game of Sorts");
//			System.out.println(javafx.scene.text.Font.getFamilies());
			titulo.setStyle("-fx-background-color: transparent;-fx-text-fill: red; -fx-font-size: 40");
			titulo.relocate(80, 100);
			fondo = new ImageView();
			fondo.setImage(fondoimg);
			fondomenu = new ImageView();
			fondomenu.setImage(menuimg);
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
//			Botones
			Button gamebtn = new Button();
			gamebtn.setOnAction(e->{
				menu.close();
				drakespam();
				timer.start();
				window.show();
			});
			gamebtn.setText("Play");
			gamebtn.relocate(300, 300);
			
//			
			balaon=true;
			img.setFocusTraversable(true);
			img.setLayoutX(100);
			img.setLayoutY(100);
			img.setImage(grifo);
			drake1 = new dragongui(200, 200,"drake");
			window.setFullScreen(true);
			root.getChildren().addAll(fondo,img,bala,drake1);
			menuPane.getChildren().addAll(fondomenu,gamebtn,titulo);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			menu.setScene(menuScene);
			menu.show();
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
						bala.relocate(x, y);
						actualAction = "updatepos";
						start1();
						balaon = false;
					}

					
				}
				updateimg();
			  }
			});
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

	private static class dragongui extends ImageView {
		boolean dead;
		String name;
		dragongui(int x, int y, String name){
			super(dragonimg);
			name = this.name;
			setTranslateX(x);
			setTranslateY(y);
		}
		public void drakefly() {
			setTranslateX(getTranslateX()-0.1);
		}
		public void automove(int dirx,int diry ) {
			while (dirx != getTranslateX()) {
				
			}
		}
	}
	
	
//	public ArrayList<dragongui> drakes(){
//		ArrayList<dragongui> drakeslist2 = root.getChildren().stream().map(n -> (dragongui)n).collect(Collectors.toArrayList());
//		return drakeslist2;
//	}
	
	
	@Override
	public void run() {
			try {
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
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	public void start1() {
		hilo = new Thread(this);
		hilo.start();
	}

	
	public void drakespam() {
		int w = 8;
		for(int i=0; i<20; i++) {
			if (i<10) {
				dragongui drake = new dragongui(900, w*90,"drake");
				root.getChildren().addAll(drake);
				drakeslist.add(drake);
				w=w-1;
			}if(i == 10) {
				w = 8;
			}
			
			if(i>10) {
				dragongui drake = new dragongui(800, w*90,"drake");
				root.getChildren().addAll(drake);
				drakeslist.add(drake);
				w=w-1;
			}
			
			
		}
		
	}
	private void update() {
		drakeslist.forEach(drake ->{ 
				drake.drakefly();
		});
	}
	private void updatepos(double a, double b, int i) {
				TranslateTransition randommove = new TranslateTransition();
				randommove.setToX(a);
//				System.out.println(a);
				randommove.setToY(b);
//				System.out.println(b);
				randommove.setNode(drakeslist.get(i));
				System.out.println();
				randommove.play();
	}
//	public void automove(int dirx, int diry){
//		while(dirx != posx) {
//			if(posx>dirx) {
//				posx = posx-5;
////				dragon.relocate(posx, posy);
//			}else if(posx<dirx) {
//				posx = posx+5;
////				dragon.relocate(posx, posy);
//			}
//			
//			}while(diry != posy) {
//				if(posy>diry) {
//					posy = posy-5;
////					dragon.relocate(posx, posy);
//					hilo2=null;
//				}else if(posy<diry) {
//					posy = posy+5;
////					dragon.relocate(posx, posy);
//					hilo2=null;
//				}
//			}
//		}
//	public static double randomX() {
//		double a = Math.random()*1200;
//		if (a<800) {
//			randomX();
//		}else {
//			return a;
//		}
//		
//	}

	
	
	
		
	
}