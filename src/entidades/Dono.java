package entidades;

public class Dono {
	private int id;
	private String cpf;
	private String nome;
	private int codJazigo;
	private Jazigo jazigo;
	private String cep;
	private String endereco;
	private int numeroD;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Jazigo getJazigo() {
		return jazigo;
	}
	public void setJazigo(Jazigo jazigo) {
		this.jazigo = jazigo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodJazigo() {
		return codJazigo;
	}
	public void setCodJazigo(int codJazigo) {
		this.codJazigo = codJazigo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getnumeroD() {
		return numeroD;
	}
	public void setnumeroD(int numeroD) {
		this.numeroD = numeroD;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
