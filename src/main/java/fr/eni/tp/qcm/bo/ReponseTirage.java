package fr.eni.tp.qcm.bo;

public class ReponseTirage {

	private int idEpreuve;
	private int idProposition;
	
	public ReponseTirage() {
		super();
	}
	
	public ReponseTirage(int idEpreuve, int idProposition) {
		super();
		this.idEpreuve = idEpreuve;
		this.idProposition = idProposition;
	}
	
	public int getIdEpreuve() {
		return idEpreuve;
	}
	
	public void setIdEpreuve(int idEpreuve) {
		this.idEpreuve = idEpreuve;
	}
	
	public int getIdProposition() {
		return idProposition;
	}
	
	public void setIdProposition(int idProposition) {
		this.idProposition = idProposition;
	}
	
	
	
}
