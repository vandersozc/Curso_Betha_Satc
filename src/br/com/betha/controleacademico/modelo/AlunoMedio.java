package br.com.betha.controleacademico.modelo;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class AlunoMedio {

	private int codigo;
	private String periodo;
	private Date vencMatricula;
	private Double percentDesc;
	private Double percentAcresc;
	private String Observacao;
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public Date getVencMatricula() {
		return vencMatricula;
	}
	public Double getPercentDesc() {
		return percentDesc;
	}
	public Double getPercentAcresc() {
		return percentAcresc;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public void setVencMatricula(Date vencMatricula) {
		this.vencMatricula = vencMatricula;
	}
	public void setPercentDesc(Double percentDesc) {
		this.percentDesc = percentDesc;
	}
	public void setPercentAcresc(Double percentAcresc) {
		this.percentAcresc = percentAcresc;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	
	
	
	
}
