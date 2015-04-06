package br.com.betha.controleacademico.modelo;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class AlunoSuperior extends Aluno {

	private String periodo;
	private String nivelEnsino;
	private Date vencMatricula;

	public String getPeriodo() {
		return periodo;
	}

	public String getNivelEnsino() {
		return nivelEnsino;
	}

	public Date getVencMatricula() {
		return vencMatricula;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setNivelEnsino(String nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public void setVencMatricula(Date vencMatricula) {
		this.vencMatricula = vencMatricula;
	}

}
