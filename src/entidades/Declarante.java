package entidades;

import java.util.Date;

public class Declarante {

	private String cpf;
	private String rg;
	private String nome;
	private String sexo;
	private String cep;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String profissao;
	private String parentesco;
	private String telefone;
	private String celular;
	private String email;
	private Date nascimento;

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date dtnascDeclarante) {
		this.nascimento = dtnascDeclarante;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfDeclarnate) {
		this.cpf = cpfDeclarnate;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rgDeclarante) {
		this.rg = rgDeclarante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeDeclarante) {
		this.nome = nomeDeclarante;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cepDeclarante) {
		this.cep = cepDeclarante;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String enderecoDeclarante) {
		this.endereco = enderecoDeclarante;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numerocasaDec) {
		this.numero = numerocasaDec;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complementoDec) {
		complemento = complementoDec;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairroDeclarante) {
		this.bairro = bairroDeclarante;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidadeDeclarante) {
		this.cidade = cidadeDeclarante;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String ufDeclarante) {
		this.uf = ufDeclarante;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentescoDeclarante) {
		this.parentesco = parentescoDeclarante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefoneDeclarante) {
		this.telefone = telefoneDeclarante;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celularDeclarante) {
		this.celular = celularDeclarante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailDeclarante) {
		this.email = emailDeclarante;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexoDeclarante) {
		this.sexo = sexoDeclarante;
	}

}
