package model;

import java.util.ArrayList;
import java.util.List;

import dao.DAOException;

import dao.FalecimentoDAO;
import dao.FalecimentoDAOImpl;

import entidades.Falecimento;

public class FalecimentoMB {
	
	private FalecimentoDAO falecimentoDao = new FalecimentoDAOImpl();
	private Falecimento falecimento = new Falecimento();
	private List<Falecimento> lista1 = new ArrayList<Falecimento>();
	
	
	public String adicionar() throws DAOException {;
	falecimentoDao.adicionar(falecimento);
	falecimento = new Falecimento();
	return "";
}

public String pesquisar() throws DAOException {
	String codigo = falecimento.getCpfFalecido();
	falecimento = new Falecimento();
	falecimento = falecimentoDao.pesquisar1(codigo);
	return "";
}

public String atualizar() throws DAOException {
	falecimentoDao.atualizar(falecimento);
	return "";
}

public String deletar() throws DAOException {
	falecimentoDao.deletar(falecimento.getCpfFalecido());
	return "";

}

	

	public Falecimento getFalecimento() {
		return falecimento;
	}

	public void setFalecimento(Falecimento falecimento) {
		this.falecimento = falecimento;
	}

	public List<Falecimento> getLista1() {
		return lista1;
	}

	public void setLista1(List<Falecimento> lista1) {
		this.lista1 = lista1;
	}
	
	

}

