package visao;

import java.util.ArrayList;

import controle.PessoaDAO;
import modelo.Pessoa;

public class TelaPessoa {
	
	public static void main(String[] args) {
		PessoaDAO dao = new PessoaDAO();
		
		ArrayList<Pessoa> pessoinhas = dao.listar();
		
		for (Pessoa pessoa: pessoinhas) {
			
		}
	}

}
