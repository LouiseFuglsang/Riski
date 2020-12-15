package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;


public class Controller {


    @FXML
    private TextArea riskTitle;

    @FXML
    private TextArea consequence;

    @FXML
    private TextArea priority;

    @FXML
    private Button save;

    @FXML
    private Button readIn;


    @FXML
    void saveChanges(ActionEvent event) {

        try {
            Scanner input = new Scanner(System.in);
            FileWriter myWriter = new FileWriter("data/archive.txt", true);
            myWriter.write("" + "riskAnalysisTitle" + '{' + '"' + riskTitle.getText() + '"' + ", " + '"' + consequence.getText() + '"' + ", " + '"' + priority.getText() + '"' + '}' + '\n');

            myWriter.close();
            System.out.println("Der er skrevet i filen");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    void readIn(ActionEvent event) {

        try {
            File myObj = new File("data/archive.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String archiveData = myReader.nextLine();
                riskTitle.setText(archiveData);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}