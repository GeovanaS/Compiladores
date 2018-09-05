class Compilador{

	public static void main(String[]args)
        {	
	    ArvoreSintatica arv=null;
	
	    try{

		AnaliseLexica al = new AnaliseLexica(args[0]);
		Parser as = new Parser(al);
		
		arv = as.parseProg();
	
		//CodeGen backend = new CodeGen();
		//String codigo = backend.geraCodigo(arv);
		//System.out.println(codigo);

                Interpretador interpretador = new Interpretador();
                int resultado = interpretador.Interpreta(arv);
                System.out.println(resultado);


		}catch(Exception e)
		{
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
