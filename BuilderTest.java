import java.util.*;


public class BuilderTest{
	public static void main(String[] args){
		 Pessoa kevin = new BuilderConcreto()
		 	.identificadaPor(1)
		 	.getPessoa();
	
		System.out.println(kevin.getRG());
	}
	//////////////////////////////
	static abstract class PessoaBuilder{
		protected Pessoa pessoa;
		PessoaBuilder(){pessoa = new Pessoa();}
		abstract PessoaBuilder identificadaPor(long id);
		public Pessoa getPessoa(){return pessoa;}
	}
	//////////////////////////////
	static class BuilderConcreto extends PessoaBuilder{
		public PessoaBuilder identificadaPor(long id){
			String rg = Banco.getPessoa(id).getRG();
			pessoa.rg = rg;
			return this;
		}
	}
	//////////////////////////////
	static class Banco{
		static Map<Long, Pessoa> dados = new HashMap<>();
		static{
		dados.put((long)1, new Pessoa("Kevin","45.878.998-X") );
		dados.put((long)2, new Pessoa("Robson","40.878.998-9") );
		dados.put((long)3, new Pessoa("Anna","42.868.987-7") );
		}
		public static Pessoa getPessoa(long id){
			return dados.get(id);
		}
	}
	//////////////////////////////
	static class Pessoa{
		private String name;
		private String rg;
		public Pessoa(){}
		public Pessoa(String name, String rg){this.name = name; this.rg = rg;}
		public String getName(){ return name;}
		public String getRG(){ return rg;}
	}
	//////////////////////////////
}
