package controle;

import java.sql.Connection;

import modelo.Pessoa;

public class PessoaDAO {

	public boolean inserir(Pessoa p) {
		
		Conexao c = Conexao.getInstacia();
		Connection con = c.conectar();
		
		return true;
	}
}
