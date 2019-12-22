package com.example.springbootapp.controller;
import java.util.Date;
 
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
 
public class Main
{
    public static void main(String[] args)
    {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(JMSApplication.class, args);
 
        //Get JMS template bean reference
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
 
        // Send a message
        System.out.println("Sending a message.");
        jmsTemplate.convertAndSend("jms.message.endpoint", new Message(1001L, "test body", new Date()));
    }
}
/*@SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration and 
 * @ComponentScan with their default attributes. It is shortcut to easily configure a spring application
 *  with annotation configuration.

@EnableJms enable the @JmsListener annotated endpoints that are created under the cover by a 
JmsListenerContainerFactory.
The JmsListenerContainerFactory is responsible to create the listener container responsible for a 
particular endpoint. Typical implementations, as the DefaultJmsListenerContainerFactory,
 provides the necessary configuration options that are supported by the underlying MessageListenerContainer.
MappingJackson2MessageConverter is used to turn the payload of a Message from serialized form to a typed Object 
and vice versa.
We have configured MessageType.TEXT. This message type can be used to transport text-based messages. 
When a client receives a TextMessage, it is in read-only mode. If a client attempts to write to the
 message at this point, a MessageNotWriteableException is thrown.*/