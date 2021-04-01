package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

//Cria os consumers para os tópicos...
public class EmailService {

    public static void main(String[] args) {
        var emailService = new EmailService();
        var service = new KafkaService(
                EmailService.class.getSimpleName(),
                "ECOMMERCE_SEND_EMAIL",
                emailService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String,String> record){
        System.out.println("-----------------------------------------------");
        System.out.println("Enviando email...");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());

        //Simula uma verificação de fraude
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email enviado!");
    }





}
