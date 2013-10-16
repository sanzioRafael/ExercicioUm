/*
 * Cuiabá, dia 11 de Outubro de 2013
 */
package exercicioum;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.LabelBuilder;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Rafael Sanzio Macedo Porto
 * @professor Ruy de Oliveira
 * @classe 4° semestre de sistemas para internet, matutino
 */
public class SampleController implements Initializable {
    
    /*
     * Controle dos objetos da calculadora como: TextField, Button, Hbox. Neste caso
     * Pois para realizarmos as funções, criar ações para eles.
     */
    @FXML
    private TextField fieldWord, fieldWordChange;
    @FXML
    private Button btnChange;
    @FXML
    private HBox hboxFont, hboxColor;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        /*
         * O text recebe o texto do fieldWord
         * E o array recebe o split dos valores digitados, exemolo:
         * Valor: "Rafael Sanzio", o split é = " " texts["Rafael","Sanzio"]
         * e é criado um char que examinara cada char do array de String
         */
        String text = fieldWord.getText().toString();
        String[] texts = text.split(" ");
        char[] change = null;
        
        /*
         * O campo fieldWordChange, recebe o resultado do metodo, changeUpperCase
         * Que deixa as letras assim: Entrada:"Rafael Sanzio" e saída: "RaFaEl SaNzIo"
         */
        fieldWordChange.setText(changeUpperCase(text, texts, change));
        
        /*
         * O array de char recebe o Texto principal em forma de um array de Char
         * E o array de texts e recebe um array de String, onde o token é o " "
         * O text = "Rafael Sanzio" e o texts["Rafael", "Sanzio"]
         */
        change = fieldWord.getText().toCharArray();
        texts = text.split(" ");
                
        //O hbox está recuperando as suas informações atuais
        hboxFont.getChildren().removeAll(hboxFont.getChildren());
        
        /*
         * Este loop alem de recuperar o valor atual do hbox, vai adicionando
         * char por char da variavel change (tipo char[]), e cada char destá variavel
         * vai aumentando a tamaho da sua font gradualmente, de forma que pareça que a letra
         * esteja aumentando
         */
        for (int i = 0; i < change.length; i++) {
            hboxFont.getChildren().add(LabelBuilder.create().text(""+change[i]).font(new Font((5+i*2)/0.5)).build());
        }
        /*
         * A variavel boolean vermelha, verde e azul é responsavel para definir de que cor a font do char vai ser
         * Um outro hbox recupera seus valores de cor para ser alterado no loop
        */
        boolean vermelha, verde, azul;
        hboxColor.getChildren().removeAll(hboxColor.getChildren());
        
        // Este for é responsavel para dar o loop completo em todas as strings que pertencem ao texto
        for(int j = 0; j < texts.length; j++){
            // O array de char (change) recebe o array de char da variavel texts[i], que é a posição, atual do vetor no loop
            change = texts[j].toCharArray();
            
            verde = false;
            vermelha = false;
            azul = false;
            
            // Este for é responsável para dar o loop completo no change
            for (int i = 0; i < change.length; i++) {
                 /*
                 * Está verificação e muito importan pois,
                 * A primeira String do array de String.
                 * Começará com uma ordem diferente de cor de preto vermelho e azul,
                 * Enquanto as proximas começa com verde, azul e vermelho
                 * e este é responsável pelas proximas depois do inicio
                 */
                if(j != 0){
                    /*
                     * Verifica como inicializará as ordens das cores, pois no inicio as cores são todas falsas
                     * e inicializa a ordem das cores, com verde como verdadeiro, e quando passa pra proxima
                     * todas ficam falsas e o azul fica veradeiro, e assim vai pro vermelho e cria-se o loop das cores
                     * com a orde de verde, azul e vermelho
                     */
                    if((azul || verde || vermelha) == false){
                        verde = true;
                        azul = false;
                        vermelha = false;
                        //
                    }
                    if(verde){
                        if(i == 0){
                            hboxColor.getChildren().add(LabelBuilder.create().text(" "+change[i]).textFill(Color.GREEN).build());
                            verde = false;
                            azul = true;
                            vermelha = false;
                        }else{
                            hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.GREEN).build());
                            verde = false;
                            azul = true;
                            vermelha = false;
                        }
                    }else if(azul){
                        hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.BLUE).build());
                        azul = false;
                        vermelha = true;
                        verde = false;
                    }else if(vermelha){
                        hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.RED).build());
                        vermelha = false;
                        verde = true;
                        azul = false;
                    }
                    //Este for responsável para lidar com as cores do inicio
                }else{
                    /*
                     * Verifica como inicializará as ordens das cores, pois no inicio as cores são todas falsas
                     * e inicializa a ordem das cores, com vermelho como verdadeiro, e quando passa pra proxima
                     * todas ficam falsas e o azul fica veradeiro, e assim vai pro verde e cria-se o loop das cores
                     * com a orde de vemelho, azul e verde
                     * Mais só no inicio é preto
                     */
                    if((azul || verde || vermelha) == false){
                        verde = false;
                        azul = false;
                        vermelha = true;
                    }
                    if(verde && i != 0){
                        hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.GREEN).build());
                        verde = false;
                        azul = true;
                        vermelha = false;
                    }else if(azul && i != 0){
                        hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.BLUE).build());
                        azul = false;
                        vermelha = true;
                        verde = false;
                    }else if(vermelha && i != 0){
                        hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.RED).build());
                        vermelha = false;
                        verde = true;
                        azul = false;
                    }else{
                        hboxColor.getChildren().add(LabelBuilder.create().text(""+change[i]).textFill(Color.BLACK).build());
                        vermelha = true;
                        verde = false;
                        azul = false;
                    }
                    if(i == change.length - 1){
                        verde = true;
                        azul = false;
                        vermelha = false;
                    }
                }   
            }
        }
        
    }
    
    
    /*
     * Meotodo responsável para fazer a atualização de uma palavar ou frase
     * Exemplo "Rafael porto" para "RaFaEl PoRtO"
     * Ele recebe o texto original, faz o splite dele para um array de texts
     * onde o token é o " ", e dentro deste loop um array de char recebe o valor
     * atual do array de string
     * O proximo passo é fazer o loop no array de char
     * Craindo uma lógica que todo o valor 0 ou divisivel por 2 em maiusculo (neste casso usamo o metodo toUpperCasse(cahnge[i]))
     * E caso seha diferente disto o texto fica em minusculo
     */
    public String changeUpperCase(String text,String[] texts, char[] change){
        for(int i = 0; i < texts.length; i++){
            change = texts[i].toCharArray();
            for(int j = 0; j < change.length; j++){
                if(j % 2 == 0 || j == 0){
                    change[j] = Character.toUpperCase(change[j]);
                }else{
                    change[j] = Character.toLowerCase(change[j]);
                }
            }
            texts[i] = new String(change);
        }
        
        /* Depois de realizar está na hora de acrecentar os epaços, pois foi removido para fazer o aumento
         * O loop vai ser enquanto os não estiverem na posição zero eles receberam um espaço antes deles
         * E tudo isto vai ser juntando em uma String, formando a palavra
         * Como: texts["RaFaEl", "SaNzIo"] para "RaFaEl SaNzIo" 
        */ 
        for(int i = 0; i < texts.length; i++){
            if(i != 0){
                text += " "+texts[i];
            }else{
                text = texts[i];
            }
        }
        return text;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hboxFont.setStyle("-fx-border-style: solid; -fx-border-width: 2; -fx-border-color: #ddd; -fx-border-radius: 2px");
        hboxColor.setStyle("-fx-border-style: solid; -fx-border-width: 2; -fx-border-color: #ddd; -fx-border-radius: 2px");
    }    
}
