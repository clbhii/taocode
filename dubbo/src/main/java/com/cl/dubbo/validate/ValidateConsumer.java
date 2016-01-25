package com.cl.dubbo.validate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValidateConsumer {

    public static void main(String[] args) throws Exception {
        String config = ValidateConsumer.class.getPackage().getName().replace('.', '/') + "/validate-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        
        ValidationService service = (ValidationService)context.getBean("validateService");
        ValidationParameter param = new ValidationParameter();
        param.setName("1");
        param.setEmail("clbhii@163.com");
        param.setAge(20);
        service.save(param);
        
    }
}
