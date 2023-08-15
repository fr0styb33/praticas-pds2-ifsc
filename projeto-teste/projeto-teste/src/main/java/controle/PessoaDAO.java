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

		ArrayList<Pessoa> pessoinhas = new ArrayList();

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

				pessoinhas.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		c.fecharConexao();
		return pessoinhas;
	}

	public boolean inserir(Pessoa p) {

		Conexao c = Conexao.getInstacia();
		Connection con = c.conectar();

		String query = "INSERT INTO pessoa " + "(id_pessoa, primeiro_nome) " + "VALUES (?, ?)";

		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, p.getIdPessoa());
			ps.setString(2, p.getPrimeiroNome());

			ps.executeUpdate();

			c.fecharConexao();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
