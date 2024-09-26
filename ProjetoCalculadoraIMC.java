import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ProjetoCalculadoraIMC extends Application{
	@Override
	public void start(Stage palco){
		Label etiquetaPeso = new Label("Peso");
		Label etiquetaAltura = new Label("Altura");

		TextField campoPeso = new TextField();
		campoPeso.setPromptText("Peso em kg");
		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em metros");

		Label etiquetaResultado = new Label();
		Label etiquetaTabela = new Label();

		Button botaoCalcular = new Button("Calcular IMC");
		botaoCalcular.setOnAction(e -> {
			try{
			double peso = Double.parseDouble(campoPeso.getText().replace(",","."));
			double altura = Double.parseDouble(campoAltura.getText().replace(",","."));

			double imc = peso/(altura * altura);
			etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));

			if (imc < 16){
				etiquetaTabela.setText("Magreza grave");
			} else if (imc >= 16 && imc <= 16.9){
				etiquetaTabela.setText("Magreza moderada");
			} else if (imc >= 17 && imc <= 18.5){
				etiquetaTabela.setText("Magreza leve");
			}else if (imc >= 18.6 && imc <= 24.9){
				etiquetaTabela.setText("peso ideal");
			}else if (imc >= 25 && imc <= 29.9){
				etiquetaTabela.setText("Sobrepeso");
			}else if (imc >= 30 && imc <= 34.9){
				etiquetaTabela.setText("Obesidade grau 1");
			}else if (imc >= 35 && imc <= 39.9){
				etiquetaTabela.setText("Obesidade grau 2 ou severa");
			}else {
				etiquetaTabela.setText("Obesidade grau III ou mórbida");
			}

		}catch(NumberFormatException ex){
			etiquetaResultado.setText("valores inválidos!");
		}
		});
		VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado, etiquetaTabela);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);

		Scene cena = new Scene(layout, 300, 250);
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();
	}
	public static void main(String[] args){
		launch(args);
	}
}