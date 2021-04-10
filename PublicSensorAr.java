package cliente;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import cliente.AppHome;

public class PublicSensorAr {

	private static final String AR_NAME = "ar";


	  public static void main(String[] argv) throws Exception {
		  
		  
		  
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    	    
	    try (Connection connection = (Connection) factory.newConnection();
	         Channel channel = (Channel) connection.createChannel()) {
	         channel.exchangeDeclare(AR_NAME, "direct");

	        
	        while (true) {
	        	TimeUnit.SECONDS.sleep(10);

		        String message =  Integer.toString(getValSensor());
	       
		        channel.basicPublish(AR_NAME, "", null, message.getBytes("UTF-8"));	
		        System.out.println(" [x] Temperetura AR '" + message + "'");
			     
			}

	    }

	  }
		public static int getValSensor() {
	        int temp;
	        Random random = new Random();        
	        temp = random.nextInt(31);
			return temp;
			
		}  

}
