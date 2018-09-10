import java.io.*;
import java.util.*;

/**************************************************
   Projeto de Compiladores
   Trabalho 1 - Maquina de Pilha
   Grupo: Geovana Silveira e Pedro Thiago 
***************************************************/

class MaquinadePilha{

private Stack<Integer> pilha = new Stack<>();
private int resultado = 0;
private int op = 0, op1 = 0, op2 = 0;
private BufferedReader arquivo;
private String linha;

public static void main(String[] args) throws IOException {
   MaquinadePilha stack = new MaquinadePilha(args[0]);
}

MaquinadePilha(String nomeArq) throws IOException{
   try{
     arquivo = new BufferedReader(new FileReader(nomeArq));
     Scanner leitura = new Scanner(arquivo);
      while((linha = arquivo.readLine()) != null){
        if(linha.contains("PUSH ")){
           linha = linha.replace("PUSH ","");
           pilha.push(Integer.valueOf(linha));
        }
        if(linha.contains("SUM")){
           sum();
        }
        if(linha.contains("SUB")){
           sub();
        }
        if(linha.contains("MULT")){
           mult();
        }
        if(linha.contains("DIV")){
           div();
        }
        if(linha.contains("PRINT")){
          print();
        }
      }
     }catch(FileNotFoundException e){
        System.out.println("Arquivo não encontrado");
     }
        arquivo.close();
}

void print(){
  System.out.println(pilha.pop());
}

void sum(){
  op1 = pilha.pop();
  op2 = pilha.pop();
  op = op1 + op2;
  pilha.push(op);
} 

void mult(){
  op1 = pilha.pop();
  op2 = pilha.pop();
  op = op1 * op2;
  pilha.push(op);
} 

void div(){
  op1 = pilha.pop();
  op2 = pilha.pop();
  op = op1 / op2;
  pilha.push(op);
}

void sub(){
  op1 = pilha.pop();
  op2 = pilha.pop();
  op = op1 - op2;
  pilha.push(op);
} 

}
