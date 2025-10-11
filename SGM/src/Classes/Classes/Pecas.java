package Classes;


public class Pecas {
	
	private String 	nomePeca;
	private double		valorPecas;
	private String 	unid;
	private int 	quat_Pecas;
	private String 	tipo_elemento;

		public Pecas(String nomePeca, double valorPecas, String unid, int quat_Pecas, String tipo_elemento) {
		super();
		
		this.nomePeca 			= nomePeca;
		this.valorPecas 		= valorPecas;
		this.unid 				= unid;
		this.tipo_elemento 		= tipo_elemento;
		this.quat_Pecas 		= quat_Pecas;
		
		}
		public Pecas() {
			super();
			
		this.nomePeca 			= null;
		this.valorPecas 		= 0;
		this.unid 				= null;
		this.quat_Pecas 		= 0;
		this.tipo_elemento 		= null;
		
		
		
		}
		public String getNomePeca() {
			return nomePeca;
		}
		public void setNomePeca(String nomePeca) {
			this.nomePeca = nomePeca;
		}
		public double getValorPecas() {
			return valorPecas;
		}
  		public void setValorPecas(double valorPecas) {
			this.valorPecas = valorPecas;
		}
		public String getUnid() {
			return unid;
		}
		public void setUnid(String unid) {
			this.unid = unid;
		}
		public String getTipo_elemento() {
			return tipo_elemento;
		}
		public void setTipo_elemento(String tipo_elemento) {
			this.tipo_elemento = tipo_elemento;
		}
		public int getQuat_Pecas() {
			return quat_Pecas;
		}
		public void setQuat_Pecas(int quat_Pecas) {
			this.quat_Pecas = quat_Pecas;
		}
		@Override
		public String toString() {
			return "Pecas: " + nomePeca + " | valor R$: "+ valorPecas + " | Quat. Pecas: "+ quat_Pecas +" "+  unid + 
					" | Tipo do elemento " + tipo_elemento ;
		}
	
		
		
		
		
}
