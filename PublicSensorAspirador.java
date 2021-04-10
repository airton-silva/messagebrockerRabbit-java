package cliente;

import java.util.Scanner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class PublicSensorAspirador {

	  private static final String ASPI_NAME = "aspi";

	  public static void main(String[] argv) throws Exception {
		  

	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    try (Connection connection = (Connection) factory.newConnection();
	         Channel channel = (Channel) connection.createChannel()) {
	         channel.exchangeDeclare(ASPI_NAME, "direct");
   
	         //pegar valores do usuario
		        Scanner ler = new Scanner(System.in);	        
		        System.out.println("Digite a sua Ação do Aspirador");
			        String message = ler.next();
			    ler.close();   

			        channel.basicPublish(ASPI_NAME, "", null, message.getBytes("UTF-8"));
			        System.out.println(" [x] Ação  ASPIRADOR'" + message + "'");
			        
		
	    }
	 } 
}
