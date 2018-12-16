package com.xingyun;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/***
 * 生产者
 * ********/
public class NewTask {
	private static final String TASK_QUEUE_NAME = "task_queue";

	  public static void main(String[] argv) throws Exception {
		  
		//创建和消息队列的连接  
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    //第二个参数为true 确保关闭RabbitMQ服务器时执行持久化
	    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

	    //从命令行发送任意消息
	    String message = getMessage(argv);

	    //将消息标记为持久性 - 通过将MessageProperties（实现BasicProperties）设置为值PERSISTENT_TEXT_PLAIN。
	    channel.basicPublish("",
	    		TASK_QUEUE_NAME,//指定消息队列的名称
	    		MessageProperties.PERSISTENT_TEXT_PLAIN,//指定消息持久化
	        message.getBytes("UTF-8"));//指定消息的字符编码
	    //打印生产者发送成功的消息
	    System.out.println(" [x] Sent '" + message + "'");

	    //关闭资源
	    channel.close();
	    connection.close();
	  }

	  
	  /***
	   * 一些帮助从命令行参数获取消息
	   * @param strings 从命令行发送任意消息字符串
	   * */
	  private static String getMessage(String[] strings) {
	    if (strings.length < 1)
	      return "Hello World!";
	    return joinStrings(strings," ");
	  }

	  /**
	   * 字符串数组
	   * @param delimiter 分隔符
	   * */
	  private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	      words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	  }
}
