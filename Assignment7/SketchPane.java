/* Assignment #: 7
 Name: Kaytlyn Daffern
 StudentID: 1221263225
 Lecture: Tu-Th 1:30-2:45pm
 Time took you to complete the assignment: 1 days
 Description: 
 */
import javafx.scene.layout.*;
import javafx.scene.shape.Shape;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;
import javafx.scene.control.ComboBox;


public class SketchPane extends BorderPane {
	
	//Task 1: Declare all instance variables listed in UML diagram
	private ArrayList<Shape> shapeList;
	private ArrayList<Shape> tempList;
	
	private Button undoButton;
	private Button eraseButton;
	
	private Label fillColorLabel;
	private Label strokeColorLabel;
	private Label strokeWidthLabel;
	
	private ComboBox<String> fillColorCombo;
	private ComboBox<String> strokeWidthCombo;
	private ComboBox<String> strokeColorCombo;
	
	private RadioButton radioButtonLine;
	private RadioButton radioButtonRectangle;
	private RadioButton radioButtonCircle;
	
	private Pane sketchCanvas;
	
	private Color[] colors;
	private String[] strokeWidth;
	private String[] colorLabels;
	
	private Color currentStrokeColor;
	private Color currentFillColor;
	private int currentStrokeWidth;
	
	private Line line;
	private Circle circle;
	private Rectangle rectangle;
	
	private double x1;
	private double y1;
	//Task 2: Implement the constructor
	public SketchPane() {
		// Colors, labels, and stroke widths that are available to the user
		colors = new Color[] {Color.BLACK, Color.GREY, Color.YELLOW, Color.GOLD, Color.ORANGE, Color.DARKRED, Color.PURPLE, Color.HOTPINK, Color.TEAL, Color.DEEPSKYBLUE, Color.LIME} ;
        colorLabels = new String[] {"black", "grey", "yellow", "gold", "orange", "dark red", "purple", "hot pink", "teal", "deep sky blue", "lime"};
        fillColorLabel = new Label("Fill Color:");
        strokeColorLabel = new Label("Stroke Color:");
        strokeWidthLabel = new Label("Stroke Width:");
        strokeWidth = new String[] {"1", "3", "5", "7", "9", "11", "13"};    
        
        shapeList = new ArrayList<Shape>();
    	tempList = new ArrayList<Shape>();
    	
    	undoButton = new Button("Undo");
    	eraseButton = new Button("Erase");
    	
    	undoButton.setOnAction(new ButtonHandler());
    	eraseButton.setOnAction(new ButtonHandler());
    	
    	fillColorCombo = new ComboBox<String>();
    	strokeWidthCombo = new ComboBox<String>();
    	strokeColorCombo = new ComboBox<String>();
    	
    	fillColorCombo.getItems().addAll(colorLabels);
    	strokeWidthCombo.getItems().addAll(strokeWidth);
    	strokeColorCombo.getItems().addAll(colorLabels);
    	
    	fillColorCombo.setOnAction(new ColorHandler());
    	strokeColorCombo.setOnAction(new ColorHandler());
    	strokeWidthCombo.setOnAction(new WidthHandler());
    	
    	currentStrokeColor = Color.BLACK;
    	currentFillColor = Color.BLACK;
    	currentStrokeWidth = 1;
   	
    	radioButtonLine = new RadioButton("Line");
    	radioButtonRectangle = new RadioButton("Rectangle");
    	radioButtonCircle = new RadioButton("Circle");
    	
    	ToggleGroup shapeTypes = new ToggleGroup();
    	radioButtonLine.setToggleGroup(shapeTypes);
    	radioButtonRectangle.setToggleGroup(shapeTypes);
    	radioButtonCircle.setToggleGroup(shapeTypes);
    	
    	radioButtonLine.setSelected(true);
    	
    	sketchCanvas = new Pane();
    	sketchCanvas.setStyle("-fx-background-color: white;");
    	
    	HBox hboxCombo = new HBox(20);
    	hboxCombo.setMinSize(20,40);
    	hboxCombo.setAlignment(Pos.CENTER);
    	hboxCombo.setStyle("-fx-background-color: lightgrey;");
    	
    	hboxCombo.getChildren().addAll(fillColorLabel, fillColorCombo, strokeColorLabel, strokeColorCombo, strokeWidthLabel, strokeWidthCombo);
    	
    	HBox hboxRadio = new HBox(20);
    	hboxRadio.setMinSize(20,40);
    	hboxRadio.setAlignment(Pos.CENTER);
    	hboxRadio.setStyle("-fx-background-color: lightgrey;");
    	
    	hboxRadio.getChildren().addAll(radioButtonLine, radioButtonRectangle, radioButtonCircle, undoButton, eraseButton);
    	
    	setCenter(sketchCanvas);
    	setTop(hboxCombo);
    	setBottom(hboxRadio);
    	
    	x1 = 0;
    	y1 = 0;
    	
    	sketchCanvas.setOnMousePressed(new MouseHandler());
    	sketchCanvas.setOnMouseDragged(new MouseHandler());
    	sketchCanvas.setOnMouseReleased(new MouseHandler());
    }

	private class MouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent event) {
			// TASK 3: Implement the mouse handler for Circle and Line
			// Rectange Example given!
			if (radioButtonRectangle.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					rectangle = new Rectangle();
					rectangle.setX(x1);
					rectangle.setY(y1);
					shapeList.add(rectangle);
					rectangle.setFill(Color.WHITE);
					rectangle.setStroke(Color.BLACK);	
					sketchCanvas.getChildren().add(rectangle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					if (event.getX() - x1 <0) {
						rectangle.setX(event.getX());
					}
					if (event.getY() - y1 <0) {
						rectangle.setY(event.getY());
					}
					rectangle.setWidth(Math.abs(event.getX() - x1));
					rectangle.setHeight(Math.abs(event.getY() - y1));

				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					rectangle.setFill(currentFillColor);
					rectangle.setStroke(currentStrokeColor);
					rectangle.setStrokeWidth(currentStrokeWidth);
				}
			}
			if (radioButtonCircle.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					circle = new Circle();
					circle.setCenterX(x1);
					circle.setCenterY(y1);
					shapeList.add(circle);
					circle.setFill(Color.WHITE);
					circle.setStroke(Color.BLACK);	
					sketchCanvas.getChildren().add(circle);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
					circle.setRadius(Math.abs(getDistance(x1, y1, event.getX(), event.getY())));
				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					circle.setFill(currentFillColor);
					circle.setStroke(currentStrokeColor);
					circle.setStrokeWidth(currentStrokeWidth);
				}
			}
			if (radioButtonLine.isSelected()) {
				//Mouse is pressed
				if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					x1 = event.getX();
					y1 = event.getY();
					line = new Line();
					line.setStartX(x1);
					line.setStartY(y1);
					line.setEndX(x1);
					line.setEndY(y1);
					shapeList.add(line);
					line.setStroke(Color.BLACK);	
					sketchCanvas.getChildren().add(line);
				}
				//Mouse is dragged
				else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) { 
						line.setEndX(event.getX()); 
						line.setEndY(event.getY());
				}
				//Mouse is released
				else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
					line.setStroke(currentStrokeColor);
					line.setStrokeWidth(currentStrokeWidth);
				}
			}
		}
	}
		
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// TASK 4: Implement the button handler
			if((event.getSource() == undoButton) && (!shapeList.isEmpty())) {
				sketchCanvas.getChildren().remove(shapeList.size() - 1);
				shapeList.remove(shapeList.size() - 1);	
			}
			else if(shapeList.isEmpty()) {
				for(int i = 0; i < tempList.size(); i++) {
					shapeList.add(tempList.get(i));
				}
				
				tempList.clear();
				
				for(int i = 0; i < shapeList.size(); i++) {
					sketchCanvas.getChildren().add(shapeList.get(i));
				}
			}
			if((event.getSource() == eraseButton) && (!shapeList.isEmpty())) {
				tempList.clear();
				for(int i = 0; i < shapeList.size(); i++) {
					tempList.add(shapeList.get(i));
				}
				shapeList.clear();
				sketchCanvas.getChildren().clear();
			}
		}
	}

	private class ColorHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			int indexFill = fillColorCombo.getSelectionModel().getSelectedIndex();
			currentFillColor = colors[indexFill];
			
			int indexStroke = strokeColorCombo.getSelectionModel().getSelectedIndex();
			currentStrokeColor = colors[indexStroke];
		}
	}
	
	private class WidthHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event){
			// TASK 6: Implement the stroke width handler
			int indexWidth = strokeWidthCombo.getSelectionModel().getSelectedIndex();
			currentStrokeWidth = Integer.parseInt(strokeWidth[indexWidth]);
		}
	}
	
		
	// Get the Euclidean distance between (x1,y1) and (x2,y2)
    private double getDistance(double x1, double y1, double x2, double y2)  {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

}