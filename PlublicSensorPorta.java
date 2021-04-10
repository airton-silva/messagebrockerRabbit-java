package cliente;


import java.util.Scanner;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class PlublicSensorPorta {
	  private static final String PORTA_NAME = "porta";


	  public static void main(String[] argv) throws Exception {
		  

	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    try (Connection connection = (Connection) factory.newConnection();
	         Channel channel = (Channel) connection.createChannel()) {
	         channel.exchangeDeclare(PORTA_NAME, "direct");


	        Scanner ler = new Scanner(System.in);	        
	        System.out.println("Digite a sua geolocalização");
		        String message = ler.next();
		    ler.close();    
			        channel.basicPublish(PORTA_NAME, "", null, message.getBytes("UTF-8"));	
			        System.out.println(" [x] GeoLocalização '" + message + "'");

	    }
	 } 
}
