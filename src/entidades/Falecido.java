package entidades;

import java.util.Date;

public class Falecido {

	private String cpf;
	private String rg;
	private String nome;
	private String sexo;
	private String nacionalidade;
	private String naturalidade;
	private String etnia;
	private Date nascimento;
	private String profissao;
	private String estCivil;
	private String tituloEleitor;
	private int zona;
	private int secao;
	private String cep;
	private String endereco;
	private int numero;
	private String Complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cpfDeclarante;
	private int codJazigo;
	private byte[] foto;
	private Date dtFalecimento;
	private Date dtExumacao;
	private Date hrExumacao;
	private Date hrFalecimeneto;
	private String local;
	private String cartorio;
	private Date dtRegistroObito;
	private String crm;
	private String causamorte;
	private int idade;
	private Date dataSepultamento;
	private Date horaSepultamento;
	

	public String getCpfDeclarante() {
		return cpfDeclarante;
	}

	public void setCpfDeclarante(String cpfDeclarante) {
		this.cpfDeclarante = cpfDeclarante;
	}

	public int getCodJazigo() {
		return codJazigo;
	}

	public void setCodJazigo(int codJazigo) {
		this.codJazigo = codJazigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfFalecido) {
		this.cpf = cpfFalecido;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rgFalecido) {
		this.rg = rgFalecido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeFalecido) {
		this.nome = nomeFalecido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexoFalecido) {
		this.sexo = sexoFalecido;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidadeFal) {
		this.nacionalidade = nacionalidadeFal;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidadeFalecido) {
		this.naturalidade = naturalidadeFalecido;
	}

	public String getEtnia() {
		return etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascFalecido) {
		this.nascimento = nascFalecido;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissaoFalecido) {
		this.profissao = profissaoFalecido;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivilFal) {
		this.estCivil = estCivilFal;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitorFal) {
		this.tituloEleitor = tituloEleitorFal;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public int getSecao() {
		return secao;
	}

	public void setSecao(int secao) {
		this.secao = secao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cepFalecido) {
		this.cep = cepFalecido;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String enderecoFalecido) {
		this.endereco = enderecoFalecido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numerocasaFal) {
		this.numero = numerocasaFal;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complementoFal) {
		Complemento = complementoFal;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairroFalecido) {
		this.bairro = bairroFalecido;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidadeFalecido) {
		this.cidade = cidadeFalecido;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String ufFalecido) {
		this.uf = ufFalecido;
	}
	
	public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
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

	public void setLocal(String local) {
		this.local = local;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataSepultamento() {
		return dataSepultamento;
	}

	public void setDataSepultamento(Date dataSepultamento) {
		this.dataSepultamento = dataSepultamento;
	}

	public Date getHoraSepultamento() {
		return horaSepultamento;
	}

	public void setHoraSepultamento(Date horaSepultamento) {
		this.horaSepultamento = horaSepultamento;
	}

	

}
