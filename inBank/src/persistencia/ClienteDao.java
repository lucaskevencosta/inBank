package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Cliente;

public class ClienteDao {
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	
	public void salvar(Cliente c) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/inbank", "postgres",
					"123456");

			String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?)";
			PreparedStatement instrucao = con.prepareStatement(sql);

			instrucao.setInt(1, c.getCpf());
			instrucao.setString(2, c.getNome());
			instrucao.setInt(3, c.getIdade());
			instrucao.setDouble(4, c.getSalLiquido());

			instrucao.execute();

			instrucao.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void editar(Cliente c) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/inbank", "postgres",
					"123456");

			String sql = "UPDATE cliente set nome= ?, idade = ?, salario = ? WHERE cpf = ?";
			PreparedStatement instrucao = con.prepareStatement(sql);
			
			instrucao.setString(1, c.getNome());
			instrucao.setInt(2, c.getIdade());
			instrucao.setDouble(3, c.getSalLiquido());
			instrucao.setInt(4, c.getCpf());
			
			instrucao.execute();
			
			instrucao.close();		
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(Integer cpf) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/inbank", "postgres",
					"123456");

			String sql = "DELETE FROM cliente WHERE cpf = ?";
			PreparedStatement instrucao = con.prepareStatement(sql);

			instrucao.setInt(1, cpf);

			instrucao.execute();

			instrucao.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Cliente> listar() {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/inbank", "postgres",
					"123456");
			
			String sql = "SELECT * FROM cliente";
			PreparedStatement instrucao = con.prepareStatement(sql);
			
			ResultSet rs = instrucao.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente(rs.getString(2), rs.getInt(1), rs.getDouble(4), rs.getInt(3));
				clientes.add(cliente);
			}
			
			rs.close();
			instrucao.close();
			con.close();
			
			return (ArrayList<Cliente>) clientes;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
