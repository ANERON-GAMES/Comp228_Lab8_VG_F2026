package com.vg.week8.registration;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Author: Vadim Gubin
 * Student ID: 301538942
 * Date: November 5, 2026
 * Description: College registration screen. BorderPane with a form in the centre.
 */

public class RegistrationApp extends Application {

	private TextField idField;
	private TextField nameField;
	private TextField emailField;
	private TextField programField;
	private Label statusLabel;

	public void start(Stage stage) {
		BorderPane root = new BorderPane();
		root.setTop(buildTitle());
		root.setLeft(buildSideMenu());
		root.setCenter(buildCentre());

		Scene scene = new Scene(root, 680, 430);
		stage.setTitle("Student Registration");
		stage.setScene(scene);
		stage.show();
	}

	private HBox buildTitle() {
		Label title = new Label("College Student Registration");
		title.setStyle("-fx-font-size: 18px;");
		HBox bar = new HBox(title);
		bar.setAlignment(Pos.CENTER_LEFT);
		bar.setPadding(new Insets(12, 16, 12, 16));
		bar.setStyle("-fx-background-color: #d9d9d9;");
		return bar;
	}

	private VBox buildSideMenu() {
		VBox menu = new VBox(8);
		menu.setPadding(new Insets(12));
		menu.setPrefWidth(150);
		menu.getChildren().addAll(
				menuButton("Dashboard"),
				menuButton("Registration"),
				menuButton("Courses"),
				menuButton("Help"));
		return menu;
	}

	private Button menuButton(String text) {
		Button button = new Button(text);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setOnAction(e -> statusLabel.setText(text + " page is not ready."));
		return button;
	}

	private VBox buildCentre() {
		idField = new TextField();
		nameField = new TextField();
		emailField = new TextField();
		programField = new TextField();

		GridPane form = new GridPane();
		form.setHgap(10);
		form.setVgap(8);
		form.add(new Label("Student ID"), 0, 0);
		form.add(idField, 1, 0);
		form.add(new Label("Full Name"), 0, 1);
		form.add(nameField, 1, 1);
		form.add(new Label("Email"), 0, 2);
		form.add(emailField, 1, 2);
		form.add(new Label("Program"), 0, 3);
		form.add(programField, 1, 3);

		Button registerButton = new Button("Register");
		Button clearButton = new Button("Clear");
		registerButton.setOnAction(e -> registerStudent());
		clearButton.setOnAction(e -> clearForm());

		HBox actions = new HBox(10, registerButton, clearButton);

		statusLabel = new Label("Fill the form and press Register.");
		statusLabel.setWrapText(true);

		VBox centre = new VBox(14);
		centre.setPadding(new Insets(16));
		centre.getChildren().addAll(form, actions, statusLabel);
		return centre;
	}

	// cheks that the four fields are not empty
	private void registerStudent() {
		if (idField.getText().trim().equals("")
				|| nameField.getText().trim().equals("")
				|| emailField.getText().trim().equals("")
				|| programField.getText().trim().equals("")) {
			statusLabel.setText("Please fill all required feilds.");
			return;
		}
		statusLabel.setText("Registered: " + nameField.getText().trim()
				+ " (" + idField.getText().trim() + ")");
	}

	private void clearForm() {
		idField.clear();
		nameField.clear();
		emailField.clear();
		programField.clear();
		statusLabel.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
