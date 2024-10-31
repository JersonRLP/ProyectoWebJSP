package Conectar.Cinehome;

public class TestConectarBD {

	public static void main(String[] args) {
		conectarbd();
	}

	
public static void conectarbd(){
	//instanciamos la respectiva clase..
			ConectarBD conec=new ConectarBD();
			//invocamos al metodo
			conec.ConexionMysql();
	
}
	
	
}


