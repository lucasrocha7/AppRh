package com.AppRH.AppRH.controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Principal extends JFrame{
   
   public static String nomeaq = " ";
   
   private final JDesktopPane tela = new JDesktopPane();
   JTextArea folha; 
   
   public Principal(){
        //chama metodo construtor da classe JFrame
        super("Bloco de notas"+nomeaq);
        this.MontaJanela();
      }
   
   private void MontaJanela(){
      
      add(tela);
      
      JMenuBar menuB = new JMenuBar();
      JMenu menu = new JMenu("Arquivo");
      JMenuItem abrir = new JMenuItem("abrir");
      JMenuItem salvar = new JMenuItem("salvar");
      JMenuItem sair = new JMenuItem("Sair");
      
      menu.add(abrir);
      menu.add(salvar);
      menu.add(sair);
      menuB.add(menu);
      setJMenuBar(menuB);
      
      folha = new JTextArea(300,400);
      JScrollPane bb= new JScrollPane(folha);
      add(bb);
      
      /* Aqui é adicionado as funções do menu*/      
      
      /*inseri o evento para sair do programa*/
      sair.addActionListener( 
                new ActionListener(){
                    public void actionPerformed(ActionEvent evento){
                           System.exit(0);
                    }
               
                }
      );
      
      /*inseri o evento para salvar do programa*/
      salvar.addActionListener( 
                new ActionListener(){
                    public void actionPerformed(ActionEvent evento){
                       salvar(JOptionPane.showInputDialog(null,"Entre com o nome do arquivo"));
                    }

               
                }
      );
      /*inseri o evento para abrir do programa*/
      abrir.addActionListener( //permite que uma acao seja executada qdo o item é selecionado
                new ActionListener(){
                    public void actionPerformed(ActionEvent evento){
                       try {
                     abrir(JOptionPane.showInputDialog("Entre com o nome do arquivo"));
                  } catch (HeadlessException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                  }            
               }   
                }
          );
      
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
   }
   
    /*Cria um novo arquivo texto e salva*/
    public void salvar (String nome){
       try {
         FileOutputStream arq = new FileOutputStream(nome);
         PrintStream Saida = new PrintStream(arq); 
         Saida.print(folha.getText());
         nomeaq=nome;
      } catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "Falha");
         
      }
       
    }
    
    public void abrir(String nome) throws HeadlessException, IOException {
              folha.setText(" ");      
              String txt = "";
              BufferedReader in = null;
            try {
               /*carrega o arquivo especificado pelo nome*/
               in = new BufferedReader(new FileReader(nome));
            } catch (FileNotFoundException e) {
               JOptionPane.showMessageDialog(null, "Falha ao ler o arquivo "+ nome);
            }
              
              
              while(in.readLine() != null){
                 /* le linha a linha até o final que e apontado com o 
                 retorno null da função readLine que pode fazer com que o arquivo nao seja
                  lido ate o final
                 */
                 txt = txt + in.readLine()+"\n";// concatena cada linha em txt
              }
              this.setTitle("Bloco de nota - "+nome); //coloca o titulo do arquivo na tela
              folha.setText(txt);//imprime texto lido na tela

       }
   
    public static void main(String[] args){
          //Cria objeto:
         Principal janela = new Principal();
          janela.setSize(800,600);
          janela.setVisible(true);
      }
    
   
}