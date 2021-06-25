package entidades_Listas;

public class LinhaOnibus {

	private int poltrona;
	private String Nome;

	@Override
	public String toString() {
		return "LinhaOnibus [poltrona=" + poltrona + ", Nome=" + Nome + "]";
	}

	public int getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public LinhaOnibus(int poltrona, String nome) {
		this.poltrona = poltrona;
		this.Nome = nome;
	}

}
