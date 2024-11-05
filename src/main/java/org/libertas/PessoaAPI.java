package org.libertas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

import org.libertas.objetos.Resposta;

import com.google.gson.Gson;

/**
 * Servlet implementation class PessoaAPI
 */
//@WebServlet("/PessoaAPI/*")
public class PessoaAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PessoaAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PessoaDao pdao = new PessoaDao();
		Gson gson = new Gson();
		
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt( request.getPathInfo().substring(1) );
		} catch (Exception e) {
		}
		
		String resposta; 
		if (id==0) {
			//listar todos
			resposta = gson.toJson(pdao.listar());
		} else {
			//consultar apenas 1
			resposta = gson.toJson(pdao.consultar(id));
		}
		
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da requisição
		String body = request.getReader().lines().collect(
					Collectors.joining(System.lineSeparator())
				);
		
		//converte o body para um objeto Java
		Gson gson = new Gson();
		Pessoa p = gson.fromJson(body, Pessoa.class);
		
		//salva a nova pessoa
		PessoaDao pdao = new PessoaDao();
		
		Resposta r;
		if (pdao.inserir(p)) {
			r = new Resposta(true, "Pessoa inserida com sucesso");
		} else {
			r = new Resposta(false, "Falha ao inserir Pessoa");
		}
		String resposta = gson.toJson(r);
		
		//envia resposta
		response.setHeader("content-type", "application/json");
		response.getWriter().print(resposta);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o body da requisição
		String body = request.getReader().lines().collect(
					Collectors.joining(System.lineSeparator())
				);
		
		//converte o body para um objeto Java
		Gson gson = new Gson();
		Pessoa p = gson.fromJson(body, Pessoa.class);
		
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt( request.getPathInfo().substring(1) );
		} catch (Exception e) {
		}
		p.setIdpessoa(id);
		
		//salva a nova pessoa
		PessoaDao pdao = new PessoaDao();
		Resposta r;
		if (pdao.alterar(p)) {
			r = new Resposta(true, "Pessoa alterada com sucesso");
		} else {
			r = new Resposta(false, "Falha ao alterar Pessoa");
		}
		String resposta = gson.toJson(r);
		response.getWriter().print(resposta);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pega o id passado por parametro
		int id = 0;
		try {
			id = Integer.parseInt( request.getPathInfo().substring(1) );
		} catch (Exception e) {
		}
		
		//exclui a nova pessoa
		PessoaDao pdao = new PessoaDao();
		Pessoa p = new Pessoa();
		p.setIdpessoa(id);

		Resposta r;
		if (pdao.excluir(p)) {
			r = new Resposta(true, "Pessoa excluida com sucesso");
		} else {
			r = new Resposta(false, "Falha ao excluir Pessoa");
		}
		Gson gson = new Gson();
		String resposta = gson.toJson(r);
		
		//envia resposta
		response.getWriter().print(resposta);
	}
}
