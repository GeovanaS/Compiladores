DIGITO	[0-9]
LETRA	[a-zA-Z]
PALAVRA_RESERVADA "class"|"public"|"static"|"void"|"main"|"String"|"extends"|"int"|"boolean"|"if"|"while"|"System.out.println"|"else"|"true"|"false"|"new"|"return"|"length"
ID	{LETRA}({LETRA}|{DIGITO})*	
%%
{DIGITO}+		{printf("Inteiro: %s\n",yytext);}
{DIGITO}+"."{DIGITO}+	{printf("Real: %s\n",yytext);} 
{PALAVRA_RESERVADA} {printf("Palavra Reservada: %s\n", yytext);}
{ID}			{printf("var: %s\n",yytext);}

%%
int yywrap();

main(){
  yylex();
}

int yywrap(){
 return 1;
}
