DIGITO	[0-9]
LETRA	[a-zA-Z]
RESERVADA "class"|"public"|"static"|"void"|"main"|"String"|"extends"|"if"|"while"|"System.out.println"|"else"|"new"|"this"|"return"|"length"
TIPO "int"|"boolean"
OPERADOR  "&&"|"<"|"+"|"-"|"*"|"="
PONTO_VIRGULA ";"
VIRGULA ","
ABRE_PAR "("
FECHA_PAR ")"	
ABRE_COL  "["
FECHA_COL "]"
ABRE_CHA  "{"
FECHA_CHA  "}"
BOOL "true"|"false"
PONTO "."
EXCLAMACAO "!"
ENDLINE			.
COMENTARIO "/*"({LETRA})*"*/"|"//"{ENDLINE}*
EOF "EOF"
ID	{LETRA}({LETRA}|{DIGITO})*	

%%
{DIGITO}+	     	   {printf("Inteiro: %s\n",yytext);}
{DIGITO}+"."{DIGITO}+  {printf("Real: %s\n",yytext);} 
{RESERVADA}            {printf("Palavra Reservada: %s\n",yytext);}
{OPERADOR}             {printf("Operador: %s\n",yytext);}
{TIPO}                 {printf("Tipo: %s\n",yytext);}
{PONTO_VIRGULA}        {printf("Ponto e Vírgula: %s\n",yytext);}
{VIRGULA}	           {printf("Vírgula: %s\n",yytext);}
{COMENTARIO}	       {printf("Comentário: %s\n",yytext);}
{ABRE_PAR}             {printf("Abre parênteses: %s\n",yytext);}
{FECHA_PAR}            {printf("Fecha parênteses: %s\n",yytext);}
{ABRE_COL}             {printf("Abre colchete: %s\n",yytext);}
{FECHA_COL}            {printf("Fecha colchete: %s\n",yytext);}
{ABRE_CHA}             {printf("Abre chaves: %s\n",yytext);}
{FECHA_CHA}            {printf("Fecha chaves: %s\n",yytext);}
{BOOL}                 {printf("Booleano: %s\n",yytext);}
{PONTO}                {printf("Ponto: %s\n",yytext);}
{EXCLAMACAO}           {printf("Exclamação: %s\n",yytext);}
{EOF}                  {printf("Final de arquivo: %s\n",yytext);}
{ID}                   {printf("var: %s\n",yytext);}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}
