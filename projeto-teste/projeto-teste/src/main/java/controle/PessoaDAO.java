package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {

	public ArrayList<Pessoa> listar() {
		Conexao c = Conexao.getInstacia();
		Connection con = c.conectar();

		ArrayList<Pessoa> pessoinha = new ArrayList();

		String query = "SELECT * FROM pessoa";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int idPessoa = rs.getInt("id_pessoa");

				String primeiroNome = rs.getString("primeiro_nome");
				Pessoa p = new Pessoa();
				p.setIdPessoa(idPessoa);
				p.setPrimeiroNome(primeiroNome);

				pessoinha.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean inserir(Pessoa p) {

		return true;
	}
}
