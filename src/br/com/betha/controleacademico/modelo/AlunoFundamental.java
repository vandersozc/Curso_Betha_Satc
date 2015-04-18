package br.com.betha.controleacademico.modelo;


public class AlunoFundamental {

	private int codigo;
	private String periodo;
	private String vencMatricula;
	private Double percentDesc;
	private Double percentAcresc;
	private String Observacao;
	
	
	public int getCodigo() {
		return codigo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public String getVencMatricula() {
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
	public void setVencMatricula(String vencMatricula) {
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
