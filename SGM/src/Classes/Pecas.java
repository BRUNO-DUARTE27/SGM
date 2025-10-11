package Classes;


public class Pecas {
	
	private String 	nomePeca;
	private int		valorPecas;
	private String 	data_recebimento;
	private String 	data_uso;
	private int 	quat_Pecas;
	

		public Pecas(String nomePeca, int valorPecas, String data_recebimento, String data_uso, int quat_Pecas) {
		super();
		
		this.nomePeca 			= nomePeca;
		this.valorPecas 		= valorPecas;
		this.data_recebimento 	= data_recebimento;
		this.data_uso 			= data_uso;
		this.quat_Pecas 		= quat_Pecas;
		
		}
		public Pecas() {
			super();
			
		this.nomePeca 			= null;
		this.valorPecas 		= 0;
		this.data_recebimento 	= null;
		this.data_uso 			= null;
		this.quat_Pecas 		= 0;
		
		
		}
		public String getNomePeca() {
			return nomePeca;
		}
		public void setNomePeca(String nomePeca) {
			this.nomePeca = nomePeca;
		}
		public int getValorPecas() {
			return valorPecas;
		}
  		public void setValorPecas(int valorPecas) {
			this.valorPecas = valorPecas;
		}
		public String getData_recebimento() {
			return data_recebimento;
		}
		public void setData_recebimento(String data_recebimento) {
			this.data_recebimento = data_recebimento;
		}
		public String getData_uso() {
			return data_uso;
		}
		public void setData_uso(String data_uso) {
			this.data_uso = data_uso;
		}
		public int getQuat_Pecas() {
			return quat_Pecas;
		}
		public void setQuat_Pecas(int quat_Pecas) {
			this.quat_Pecas = quat_Pecas;
		}
	
		
		
		
		
}
