package org.libertas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class PessoaDao {

	//private static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
	
	
	public boolean salvar(Pessoa p) {
		if (p.getIdpessoa()>0) {
			return alterar(p);
		} else {
			return inserir(p);
		}
	}
	
	public boolean inserir(Pessoa p) {
		//lista.add(p);
		
		Conexao con = new Conexao();
		boolean resposta = false;
		try {
			String sql = "INSERT INTO pessoa (nome, telefone, email, cidade) "
					+ " VALUES (?,?,?,?)";
			PreparedStatement prep = con.getConnection().prepareStatement(sql);
			prep.setString(1, p.getNome());
			prep.setString(2, p.getTelefone());
			prep.setString(3, p.getEmail());
			prep.setString(4, p.getCidade());
			prep.execute();
			resposta = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		
		return resposta;
	}
	
	
	public boolean alterar(Pessoa p) {
		Conexao con = new Conexao();
		boolean resposta = false;
		try {
			String sql = "SELECT idpessoa "
					+ " FROM pessoa "
					+ " WHERE idpessoa = " + p.getIdpessoa();
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				sql = "UPDATE pessoa SET "
						+ " nome = ?, telefone = ?, "
						+ " email = ?, cidade = ? "
						+ " WHERE idpessoa = ?";
				PreparedStatement prep = con.getConnection().prepareStatement(sql);
				prep.setString(1, p.getNome());
				prep.setString(2, p.getTelefone());
				prep.setString(3, p.getEmail());
				prep.setString(4, p.getCidade());
				prep.setInt(5, p.getIdpessoa());
				prep.execute();
				resposta = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		
		return resposta;
	}
	
	
	public boolean excluir(Pessoa p) {
		Conexao con = new Conexao();
		boolean resposta = false;
		try {
			String sql = "SELECT idpessoa "
					+ " FROM pessoa "
					+ " WHERE idpessoa = " + p.getIdpessoa();
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				sql = "DELETE FROM pessoa "
						+ " WHERE idpessoa = ?";
				PreparedStatement prep = con.getConnection().prepareStatement(sql);
				prep.setInt(1, p.getIdpessoa());
				prep.execute();
				resposta = true;
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		
		return resposta;
	}
	
	
	public LinkedList<Pessoa> listar() {
		//return lista;
		LinkedList<Pessoa> lista = new LinkedList<Pessoa>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa ORDER BY nome";
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Pessoa p = new Pessoa();
				p.setIdpessoa(res.getInt("idpessoa"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
				lista.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return lista;
	}
	

	public Pessoa consultar(int id) {
		System.out.println("Consultando pessoa " + id);
		Pessoa p = new Pessoa();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT * FROM pessoa WHERE idpessoa = " + id;
			Statement sta = con.getConnection().createStatement();
			ResultSet res = sta.executeQuery(sql);
			if (res.next()) {
				p.setIdpessoa(res.getInt("idpessoa"));
				p.setNome(res.getString("nome"));
				p.setTelefone(res.getString("telefone"));
				p.setEmail(res.getString("email"));
				p.setCidade(res.getString("cidade"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
		return p;
	}
}
