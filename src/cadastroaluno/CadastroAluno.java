package cadastroaluno;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CadastroAluno extends Application {
    
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("BEM-VINDO!");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Cadastro de Aluno");
        scenetitle.setId("cadastro-texto");
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label nome = new Label("Nome Completo:");
        grid.add(nome, 0, 1);

        final TextField nomeTextField = new TextField();
        grid.add(nomeTextField, 1, 1);
        
        Label ra = new Label("RA:");
        grid.add(ra, 0, 2);

        final TextField raTextField = new TextField();
        grid.add(raTextField, 1, 2);
        
        Label sexo = new Label("Sexo:");
        grid.add(sexo, 0, 3);
        
        final ToggleGroup group = new ToggleGroup();
        
        final RadioButton masc = new RadioButton("Masculino");
        masc.setToggleGroup(group);
        masc.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(masc, 1, 3);
        
        final RadioButton fem = new RadioButton("Feminino");
        fem.setToggleGroup(group);
        fem.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(fem, 2, 3);
        
        Label estado = new Label("Estado:");
        grid.add(estado, 0, 4);
        
        final ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(
                "AM", "MS", "SP", "RJ", "RS")
        );
        grid.add(cb, 1, 4);
        
        
        Label ativo = new Label("Ativo:");
        grid.add(ativo,0,5);
        
        final CheckBox chb = new CheckBox();
        chb.setSelected(true);
        grid.add(chb, 1, 5);
        
        Button salvar = new Button("Salvar");
        grid.add(salvar, 0, 7);
        
        Button limpar = new Button("Limpar");
        grid.add(limpar, 1, 7);
        
        final Text actiontarget = new Text();
        
        salvar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Salvo s = new Salvo();
                s.start(primaryStage);
            }
        });
        
        limpar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
//                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setId("actiontarget");
                masc.setSelected(false);
                fem.setSelected(false);
                cb.getItems().clear();
                cb.setItems(FXCollections.observableArrayList(
                "AM", "MS", "SP", "RJ", "RS"));
                chb.setSelected(false);
                nomeTextField.setText(null);
                raTextField.setText(null);
            }
        });
        
        
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(CadastroAluno.class.getResource("cadastro.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
