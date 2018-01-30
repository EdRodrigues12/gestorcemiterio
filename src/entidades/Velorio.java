package entidades;

import java.util.Date;

public class Velorio {
	
	private Long id;
	private String cpfFalecido;
	private String nomeFalecido;
	private String cpfDeclarante;
	private String nomeDeclarante;
	private int sala;
	private Date dia;
	private Date diaFim;
	private Date horaInicio;
	private Date horaFim;
	private boolean status;
	
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDiaFim() {
		return diaFim;
	}
	public void setDiaFim(Date diaFim) {
		this.diaFim = diaFim;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpfFalecido() {
		return cpfFalecido;
	}
	public void setCpfFalecido(String cpfFalecido) {
		this.cpfFalecido = cpfFalecido;
	}
	public String getNomeFalecido() {
		return nomeFalecido;
	}
	public void setNomeFalecido(String nomeFalecido) {
		this.nomeFalecido = nomeFalecido;
	}
	public String getCpfDeclarante() {
		return cpfDeclarante;
	}
	public void setCpfDeclarante(String cpfDeclarante) {
		this.cpfDeclarante = cpfDeclarante;
	}
	public String getNomeDeclarante() {
		return nomeDeclarante;
	}
	public void setNomeDeclarante(String nomeDeclarante) {
		this.nomeDeclarante = nomeDeclarante;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}
	
	

}
