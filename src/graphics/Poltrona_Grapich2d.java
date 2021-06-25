package graphics;

import java.awt.*;

public class Poltrona_Grapich2d extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3066194957771437160L;
	public String Npoltrona;
	public Color c1;
	public Color c2;

	Graphics graphics;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	private String Status;

	// constructor
	public Poltrona_Grapich2d(Color c1, Color c2, String Npoltrona, String Status) {

		this.c1 = c1;
		this.c2 = c2;
		this.Npoltrona = Npoltrona;
		this.Status = Status;

	}

	public void CadeiraOcupada(Color c1) {
		this.c1 = c1;
	}

	public String getNpoltrona() {
		return Npoltrona;
	}

	public void setNpoltrona(String npoltrona) {
		Npoltrona = npoltrona;
	}

	public Color getC1() {
		return c1;
	}

	public void setC1(Color c1) {
		this.c1 = c1;
	}

	public Color getC2() {
		return c2;
	}

	public void setC2(Color c2) {
		this.c2 = c2;
	}

	@Override
	public void paint(Graphics graphics) {
		// Draw Circle with a Color for border and fill
		// Filled Rect with a Color

		graphics.setColor(c1);
		graphics.fillRect(0, 0, 44, 38);
		graphics.setColor(c2);
		graphics.drawRect(0, 0, 44, 38);

		graphics.drawString(Npoltrona, 18, 24);

		SetColor(getGraphics());

	}

	public void SetColor(Graphics graphics) {
		graphics.setColor(Color.RED);
	}

}
