package graphics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Visual.Onibuss;

public class Poltrona_click extends MouseAdapter {
	
	public Poltrona_Grapich2d Poltrona;
	public Onibuss onibuss;
	public int Num_Poltrona;
	public Color CorOriginal;
	
		
	public Poltrona_click(Poltrona_Grapich2d p1, Onibuss onibuss)
	{
		this.Poltrona=p1;
		
		this.onibuss=onibuss;
	}
		
	//Escutador de click
	@Override
	public void mouseClicked(MouseEvent e) {
				
		System.out.println("to clicando");
		VeriicaNumeroPoltrona();
		onibuss.botaoAlocaPassageiro(Poltrona, Num_Poltrona);
		
	}
	
	//Volta a cor padrão quando o mouse sair do objeto
	@Override
	public void mouseExited(MouseEvent e) {
				
		Poltrona.setBackground(CorOriginal);
		Poltrona.CadeiraOcupada(CorOriginal);
		
		}
	
	//Faz animação ao passar o mouse
	@Override
	public void mouseEntered(MouseEvent e) {
	
		LcpegaCor();
		if(Poltrona.c1== Color.RED)
		{
			Color vermlhoEscuro = new Color(204, 0, 51);
			
			Poltrona.c1= vermlhoEscuro;
		
			Poltrona.setBackground(vermlhoEscuro);
			
		}
		else 
		{
			Poltrona.setBackground( new Color(0, 255, 255));
			Poltrona.c1 = new Color(0, 255, 255);
		
		
		}
	}
	

	
	//PEGA A COR PADRÃO DO OBJETO(ANTES DE MUDAR QUANDO O MOUSE PASSAR)
	public void LcpegaCor()
	{
		CorOriginal=Poltrona.getC1();
	}
	
	
	public void VeriicaNumeroPoltrona ()
	{
		
		switch (Poltrona.Npoltrona) {
		
		case "01":
			
			Num_Poltrona=1;
			
			break;
			
		case "02":
			
			Num_Poltrona=2;
			
				break;	
				
		case "03":
				
				Num_Poltrona=3;
				
				break;
				
				
		case "04":
			
			Num_Poltrona=4;
			
			break;
				
					
		case "05":
				
				Num_Poltrona=5;
				
				break;	
				
				
		case "06":
			
			Num_Poltrona=6;
			
			break;	
				
				
				
		case "07":
			
			Num_Poltrona=7;
			
			break;		
			
		case "08":
			
			Num_Poltrona=8;
			
			break;
		
		case "09":
			
			Num_Poltrona=9;
			
			break;
		
			
			
		case "10":
			
			Num_Poltrona=10;
			
			break;	
			
			
			
		case "11":
			
			Num_Poltrona=11;
			
			break;	
			
			
		case "12":
			
			Num_Poltrona=12;
			
			break;	
			
		case "13":
			
			Num_Poltrona=13;
			
			break;	
			
		
		case "14":
			
			Num_Poltrona=14;
			
			break;	
			
		case "15":
			
			Num_Poltrona=15;
			
			break;	
			
		case "16":
			
			Num_Poltrona=16;
			
			break;	
			
			
			
			
			
			default:
				break;
			}
			
			
			
		}
		
		
	
	
	
	













}
