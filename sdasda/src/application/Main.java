package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


public class Main extends Application {
	

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 750);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // drawShapes(gc);
       // drawRect(gc, 0.5, 10, 10, 10);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        int [][] array = ArrayGen.randomSquareArray(100);
        
		//ArrayGen.printArray(array);
		System.out.println("Smmothing");
		
		//drawArray(array,0 ,gc);
		MyRGB[][] array2 =ArrayGen.fillRGB(50);
		drawArray(array2,0,gc);
		
		drawArray(ArrayGen.smoothArray(array2),1,gc);
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
    
    public void drawRect(GraphicsContext gc, double scale, int x, int y, int size) {
    	gc.setFill(Color.gray(scale));
    	gc.fillRect(x, y, size, size);
    }
    
    public void drawArray(int[][] array,int slot , GraphicsContext gc) {
    	int size = (400/array.length);
    	
    	for(int i=0; i<array.length;i++) {
    		for(int k =0; k<array.length;k++) {
    			Double grayScale= (double) array[i][k]/255;
    			drawRect(gc, grayScale, (slot*400)+size*k, size*i,size );
    		}
    	}
    }
    
    public void drawPixel(GraphicsContext gc, MyRGB pix, int x, int y, int size) {
    	gc.setFill(Color.rgb(pix.getR(), pix.getG(), pix.getB()));
    	gc.fillRect(x, y, size, size);
    }
    
    public void drawArray(MyRGB[][] array, int slot, GraphicsContext gc) {
    	int size = (400/array.length);
    	
    	for(int i=0; i<array.length;i++) {
    		for(int k =0; k<array.length;k++) {
    			drawPixel(gc, array[i][k],(slot*400)+size*k, size*i,size);
    		}
    	}
    }
    
	
	public static void main(String[] args) {
		launch(args);
	}
}
