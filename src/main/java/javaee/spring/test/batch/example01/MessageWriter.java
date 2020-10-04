package javaee.spring.test.batch.example01;

import java.util.List;

import javaee.spring.test.pojo.Message;

import org.springframework.batch.item.ItemWriter;

public class MessageWriter implements ItemWriter<Message> {
    @Override
    public void write(List<? extends Message> items) throws Exception {
        System.out.println("Results:");
        for (Message item : items) {
            System.out.println(item.getContent());
        }
    }
}