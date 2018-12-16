package com.xingyun;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/***
 * 消费者
 * ****/
public class Recv {
 private final static  String QUEUE_NAME="hello";
     
     public static void main(String[] args) throws IOException, TimeoutException {
         
          /**
           * 设置与发布者相同; 
           * 我们打开一个连接和一个通道，并声明我们将要使用的队列。 
           * 请注意，这与发送发布到的队列相匹配
           * */
           ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            /**
             * 请注意，我们也在这里声明队列。 
             * 因为我们可能会在发布者之前启动消费者，所以我们希望在我们尝试使用消息之前确保队列已存在。   
             * */
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            
            /**
             *  我们即将告诉服务器将队列中的消息传递给我们。
             *   由于它会异步推送消息，因此我们以对象的形式提供回调，该消息将缓冲消息，直到我们准备好使用它们。 
             *  这是一个DefaultConsumer子类的作用。
             * */

            Consumer consumer = new DefaultConsumer(channel) {
                  @Override
                  public void handleDelivery(String consumerTag, Envelope envelope,
                                             AMQP.BasicProperties properties, byte[] body)
                      throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                  }
                };
            channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
