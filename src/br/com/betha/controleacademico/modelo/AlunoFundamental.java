package br.com.betha.controleacademico.modelo;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class AlunoFundamental {

	private int codigo;
	private String periodo;
	private Date vencMatricula;
	private int percentDesc;
	private int percentAcresc;
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
	public int getPercentDesc() {
		return percentDesc;
	}
	public int getPercentAcresc() {
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
	public void setPercentDesc(int percentDesc) {
		this.percentDesc = percentDesc;
	}
	public void setPercentAcresc(int percentAcresc) {
		this.percentAcresc = percentAcresc;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	

}
