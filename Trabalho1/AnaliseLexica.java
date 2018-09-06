import java.io.*;

enum TokenType{ NUM, SOMA, MULT, DIV, SUB ,APar, FPar, EOF}

class Token{
  char lex;
  TokenType token;
  String lexema;


 Token(char l, TokenType t){
     lex = l;
     token = t;
  }	
 
 Token (String l, TokenType t){
     lexema = l; 
     token = t;
 }	

}

class AnaliseLexica {

	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception
	{
		
	     this.arquivo = new BufferedReader(new FileReader(a));
		
	}

       Token getNextToken() throws Exception
       {	
	  Token token;
	  int eof = -1;
	  char currchar;
	  int currchar1;
	  String numN = "";

	  do{
	    currchar1 =  arquivo.read();
            currchar = (char) currchar1;
	  }while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
			
	  if(currchar1 != eof && currchar1 !=10){
	     if (currchar >= '0' && currchar <= '9'){
	       do{
                  numN += Character.toString(currchar);
                  do{
                    arquivo.mark(1); //marca a posição corrente no arquivo
                    currchar1 = arquivo.read();
                    currchar = (char) currchar1;
                   } while (currchar == '\n' || currchar == ' ' || currchar == '\t' || currchar == '\r');
	         } while (currchar >= '0' && currchar <= '9');
                   arquivo.reset(); // reposiciona para a posição da ultima chamada ao metodo mark()
	           return (new Token (numN, TokenType.NUM));
          }else{
	      switch (currchar){
		  case '(':
			return (new Token (currchar,TokenType.APar));
	          case ')':
			return (new Token (currchar,TokenType.FPar));
	          case '+':
		        return (new Token (currchar,TokenType.SOMA));
		  case '*':
			return (new Token (currchar,TokenType.MULT));
		  case '/':
			return (new Token (currchar,TokenType.DIV));
		  case '-':
			return (new Token (currchar,TokenType.SUB));
		  default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
	      }
	 }
      }
		arquivo.close();
		return (new Token(currchar,TokenType.EOF));
       }
}
