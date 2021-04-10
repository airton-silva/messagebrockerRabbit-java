package cliente;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RecebLeituraSensor {
	private static final String AR_NAME= "ar";
	private static final String LUZ_NAME = "Luz";
	private static final String PORTA_NAME= "porta";
	private static final String ASPI_NAME = "aspi";
	
	
	public static void main(String[] argv) throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
	
		channel.exchangeDeclare(AR_NAME, "direct");
		String queueName = channel.queueDeclare().getQueue();
//		channel.queueBind(queueName, AR_NAME, "");
		
		channel.queueBind(queueName, ASPI_NAME, "");
		channel.queueBind(queueName, AR_NAME, "");
		channel.queueBind(queueName, LUZ_NAME, "");
		channel.queueBind(queueName, PORTA_NAME, "");
				
//		channel.exchangeDeclare(LUZ_NAME, "direct");
//		String queueName2 = channel.queueDeclare().getQueue();
//		channel.queueBind(queueName2, LUZ_NAME, "");
		
//		channel.exchangeDeclare(PORTA_NAME, "direct");
//		String queueName3 = channel.queueDeclare().getQueue();
//		channel.queueBind(queueName3, PORTA_NAME, "");
//		
//		channel.exchangeDeclare(ASPI_NAME, "direct");
//		String queueName4 = channel.queueDeclare().getQueue();
//		channel.queueBind(queueName4, ASPI_NAME, "");
		
		AppHome app = new AppHome(22, "00372-00421", "fechar", "ligar", 10, "desligar");

			System.out.println(" [*] Aguardando mensagem... Precione CTRL+C para sair");

			
			DeliverCallback deliverCallback =(consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "UTF-8");
				
				if(delivery.getEnvelope().getExchange().equals("ar"))
					app.ligarAr(message); 
				if(delivery.getEnvelope().getExchange().equals("Luz")) 
					app.ligarLuzes(message);
				if(delivery.getEnvelope().getExchange().equals("porta")) 
					app.acaoPorta(message);
				if(delivery.getEnvelope().getExchange().equals("aspi"))
					app.acaoAspirador(message);
					
			};		

			

			
			channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
//			channel.basicConsume(queueName2, true, deliverCallback, consumerTag -> { });
//			channel.basicConsume(queueName3, true, deliverCallback, consumerTag -> { });
//			channel.basicConsume(queueName4, true, deliverCallback, consumerTag -> { });

		
	}


}