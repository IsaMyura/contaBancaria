	import java.util.Scanner;
	import java.io.IOException;

	class Console {

    public static void clear(String... args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}

	class ContaBancaria {
		
	  static double saldo;  
	  
	  public static boolean validarSangria(double valor){    
		
		if(valor > saldo){
		  return false;
		}
		
		return true;
	  }
	  
	  public static void reforcoSaldo(double valor){
		  
		saldo = saldo + valor;
		
	  }
	  
	  public static void pressEnterForMenu()throws IOException, InterruptedException {
		  
		System.out.print("\n\n-- Pressione enter para voltar ao menu principal --\n\n");
		System.in.read();
		
	  }
		
	  public static void depositar() throws IOException, InterruptedException {
		
		System.out.print("\n-> Seu saldo atual eh " + saldo);
		
		Scanner teclado = new Scanner(System.in);   
		  
		double valor;
		  
		System.out.print("\n-> Qual o valor que voce deseja depositar?\n");
		  
		valor = teclado.nextDouble();
		  
		reforcoSaldo(valor);      
		  
		System.out.print("DEPOSITO REALIZADO COM SUCESSO!!");  
		System.out.print("\n-> Seu saldo atual eh \n" + saldo);
		  
		pressEnterForMenu();
		  
	    }
	  
	  public static void sacar()throws IOException, InterruptedException {
		   
		System.out.print("\n-> Seu saldo atual eh \n" + saldo);
		   
		Scanner teclado = new Scanner(System.in);  
		   
		double valor;
		  
		System.out.print("\n-> Qual o valor que voce deseja sacar?\n");
		valor = teclado.nextDouble();
		  
		if(validarSangria(valor) == false){
		System.out.print("\n SALDO INSUFICIENTE \n");
		pressEnterForMenu();
	    }
		  
		saldo = saldo - valor;
		  
		System.out.print("SAQUE REALIZADO COM SUCESSO!!");  
		System.out.print("\n-> Seu saldo atual eh \n" + saldo);
		  
		pressEnterForMenu();
		  
	    } 
	  
	  public static double exibirSaldo()throws IOException, InterruptedException {
		  
		System.out.print(saldo);
	    pressEnterForMenu();
			 
		return saldo;
	    }

  
	public static void menu()throws IOException, InterruptedException{
    Scanner teclado = new Scanner(System.in); 
	Console console = new Console();    
	console.clear();


    int opcao;
    System.out.print("+------------------------+\n");
    System.out.print("|         MENU           |");
    System.out.print("\n+ -----------------------+\n");
    System.out.print("|[1] - DEPOSITAR         |\n");
    System.out.print("|[2] - SACAR             |\n");
    System.out.print("|[3] - EXIBIR SALDO      |\n");
    System.out.print("|[4] - SAIR DO SISTEMA   |\n");
	System.out.print("+------------------------+\n");
	
	System.out.print("Selecione uma opcao:\n\n");
    
    opcao = teclado.nextInt();       
	
    switch (opcao) {
      case 1:
      depositar();
	  menu();
      break;

      case 2:
      sacar();
	  menu();
      break;

      case 3:
      exibirSaldo();
	  menu();
      break;

      case 4:
      System.exit(0);
      break;

    default:
      System.out.printf("ERROR!! Insira uma opcao válida");
      main(null);
    }
 
   }
  
	public static void main(String args[])throws IOException, InterruptedException{  
    
	
    saldo = 0;

    menu();    
    
    System.out.print(saldo);
    
    System.exit(0);
		
	}

}
