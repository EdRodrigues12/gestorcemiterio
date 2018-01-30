package entidades;

import java.util.Date;

public class Falecimento {

	private Date dtFalecimento;
	private Date dtExumacao;
	private Date hrExumacao;
	private Date hrFalecimeneto;
	private String local;
	private String cartorio;
	private Date dtRegistroObito;
	private String crm;
	private String causamorte;
	private String cpfFalecido;

	public String getCpfFalecido() {
		return cpfFalecido;
	}

	public void setCpfFalecido(String cpfFalecido) {
		this.cpfFalecido = cpfFalecido;
	}

	public Date getDtFalecimento() {
		return dtFalecimento;
	}

	public void setDtFalecimento(Date dtFalecimento) {
		this.dtFalecimento = dtFalecimento;
	}

	public Date getDtExumacao() {
		return dtExumacao;
	}

	public void setDtExumacao(Date dtExumacao) {
		this.dtExumacao = dtExumacao;
	}

	public Date getHrExumacao() {
		return hrExumacao;
	}

	public void setHrExumacao(Date hrExumacao) {
		this.hrExumacao = hrExumacao;
	}

	public Date getHrFalecimeneto() {
		return hrFalecimeneto;
	}

	public void setHrFalecimeneto(Date hrFalecimeneto) {
		this.hrFalecimeneto = hrFalecimeneto;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String localFalecimento) {
		this.local = localFalecimento;
	}

	public String getCartorio() {
		return cartorio;
	}

	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}

	public Date getDtRegistroObito() {
		return dtRegistroObito;
	}

	public void setDtRegistroObito(Date dtRegistroObito) {
		this.dtRegistroObito = dtRegistroObito;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCausamorte() {
		return causamorte;
	}

	public void setCausamorte(String causamorte) {
		this.causamorte = causamorte;
	}

}
