class Interpretador{
        int Interpreta(ArvoreSintatica arv){
        if(arv instanceof Mult){
        	return (Interpreta(((Mult) arv).arg1) * Interpreta(((Mult)arv).arg2));
        }
        if(arv instanceof Soma){
        	return (Interpreta(((Soma) arv).arg1) + Interpreta(((Soma)arv).arg2));
        }
        if(arv instanceof Div){
        	return (Interpreta(((Div) arv).arg1) / Interpreta(((Div)arv).arg2));
        }
        if(arv instanceof Sub){
        	return (Interpreta(((Sub) arv).arg1) - Interpreta(((Sub)arv).arg2));
        }
        if(arv instanceof Num){
        	return (((Num) arv).num);
        }
        return 0;
	}
}