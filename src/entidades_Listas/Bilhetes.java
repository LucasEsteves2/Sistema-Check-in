package entidades_Listas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Bilhetes {

	List<Passageiro> bilhete = new ArrayList<Passageiro>();

	private Integer Idbilhete;
	private String origem;
	private String Destino;
	private String hora_embarque;
	private String hora_partida;
	private Date horaparede;
	private int poltrona;

	public int getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}

	public Bilhetes(List<Passageiro> bilhete, Integer idbilhete, String origem, String destino, String hora_embarque,
			String hora_partida, Date horaparede, int Poltrona) {

		this.bilhete = bilhete;
		Idbilhete = idbilhete;
		this.origem = origem;
		Destino = destino;
		this.hora_embarque = hora_embarque;
		this.hora_partida = hora_partida;
		this.horaparede = horaparede;
		this.poltrona = Poltrona;
	}

	public Bilhetes(Integer idbilhete, String origem, String destino, String hora_embarque, String hora_partida,
			java.util.Date data, int Poltrona) {

		Idbilhete = idbilhete;
		this.origem = origem;
		Destino = destino;
		this.hora_embarque = hora_embarque;
		this.hora_partida = hora_partida;
		this.poltrona = Poltrona;

	}

	public Integer getIdbilhete() {
		return Idbilhete;
	}

	public void setIdbilhete(Integer idbilhete) {
		Idbilhete = idbilhete;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public String getHora_embarque() {
		return hora_embarque;
	}

	public void setHora_embarque(String hora_embarque) {
		this.hora_embarque = hora_embarque;
	}

	public String getHora_partida() {
		return hora_partida;
	}

	public void setHora_partida(String hora_partida) {
		this.hora_partida = hora_partida;
	}

	public Date getHoraparede() {
		return horaparede;
	}

	public void setHoraparede(Date horaparede) {
		this.horaparede = horaparede;
	}

	@Override
	public String toString() {
		return "Bilhetes [bilhete=" + bilhete + ", Idbilhete=" + Idbilhete + ", origem=" + origem + ", Destino="
				+ Destino + ", hora_embarque=" + hora_embarque + ", hora_partida=" + hora_partida + ", horaparede="
				+ horaparede + ", poltrona=" + poltrona + "]";
	}

	public List<Passageiro> getBilhete() {
		return bilhete;
	}

	public void setBilhete(List<Passageiro> bilhete) {
		this.bilhete = bilhete;
	}

	public void adicionar(Passageiro x) {

		bilhete.add(x);

	}

}
