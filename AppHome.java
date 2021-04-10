package cliente;

import java.util.Random;

public class AppHome {
	
	private int tmpIdeal;
	private int lumisIdeal;
	private String posGeo;
	private String acaoFec;
	private String acaoSpr;
	private String acaoSprDesl;
	
	public AppHome() {
		//construtor vazio
	}
	
	public AppHome(int tmpIdeal, String posGeo, String acaoFec, String acaoSpr, int lumisIdeal, String acaoSprDesl) {
		this.tmpIdeal = tmpIdeal;
		this.posGeo = posGeo;
		this.acaoFec = acaoFec;
		this.acaoSpr = acaoSpr;
		this.lumisIdeal = lumisIdeal;
		this.acaoSprDesl = acaoSprDesl;
	}
	
	
	public void ligarAr(String message) {
		int msg = Integer.parseInt(message);
		if(msg > this.tmpIdeal)
			System.out.println("[<>] Mensagem Recebida Temp = "+msg
					+" Ligando AR_Condicionado");
	}
	
	public void ligarLuzes(String message) {
		int msg = Integer.parseInt(message);
		if(msg < this.lumisIdeal)
			System.out.println("[*] Mensagem Recebida Luninosidade = "+message
					+"  Acender as Luzes");
	}
	
	public void acaoPorta(String message) {
		if(message.equals(this.posGeo))
			System.out.println("[>>] Mensagem Recebida GeoLocalização = "+message
					+"  Abrir a porta da Frente");
		if(message.equals(this.acaoFec))
			System.out.println("[<<] Mensagem Recebida GeoLocalização = "+message
					+"  Fechar a porta da Frente");
	}
	
	public void acaoAspirador(String message) {
		if(message.equals(this.acaoSpr))
			System.out.println("[#] Mensagem Recebida  = "+message
					+"  Ligar Aspirador");
		if(message.equals(this.acaoSprDesl))
			System.out.println("[<<] Mensagem Recebida  = "+message
					+"  Desligar aspirador");
		
	}
	
	
	
	public int getTmpIdeal() {
		return tmpIdeal;
	}
	
	public void setTmpIdeal(int tmpIdeal) {
		this.tmpIdeal = tmpIdeal;
	}
	
	public int getLumis() {
		return lumisIdeal;
	}
	
	public void setLumis(int lumis) {
		this.lumisIdeal = lumis;
	}
	
	public String getPosGeo() {
		return posGeo;
	}
	
	public void setPosGeo(String posGeo) {
		this.posGeo = posGeo;
	}
	
	public String getAcaoFec() {
		return acaoFec;
	}
	
	public void setAcaoFec(String acaoFec) {
		this.acaoFec = acaoFec;
	}
	
	public String getAcaoSpr() {
		return acaoSpr;
	}
	
	public void setAcaoSpr(String acaoSpr) {
		this.acaoSpr = acaoSpr;
	}
	
	
	
	
	

}
