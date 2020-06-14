## 自定义starter

### 步骤

1. **引入springboot的基础依赖包**

   ~~~xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter</artifactId>
       <version>2.1.3.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-configuration-processor</artifactId>
       <optional>true</optional>
       <version>2.1.13.RELEASE</version>
   </dependency>
   ~~~

   

2. **创建属性配置类**

   ~~~java
   @ConfigurationProperties(prefix = "hello")
   public class HelloServiceProperties {
       private String msg = "world";
   
       public String getMsg() {
           return msg;
       }
   
       public void setMsg(String msg) {
           this.msg = msg;
       }
   }
   ~~~

   

3. **自动配置类**

   ~~~java
   @Configuration
   @EnableConfigurationProperties(HelloServiceProperties.class)
   @ConditionalOnClass(HelloService.class)
   @ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
   public class HelloServiceAutoConfiguration {
   
       @Bean
       @ConditionalOnMissingBean(HelloService.class)
       public HelloService helloService(HelloServiceProperties helloServiceProperties) {
           final String msg = helloServiceProperties.getMsg();
           HelloService helloService = new HelloService();
           helloService.setMsg(msg);
           return helloService;
       }
   
   }
   ~~~

   

4. **注册配置**

   ~~~properties
   org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
   com.hxp.HelloServiceAutoConfiguration
   ~~~

   

5. **测试**

   引入自定义starter的坐标

   ~~~xml
   <!-- 引入自定义的starter -->
   <dependency>
       <groupId>com.hxp</groupId>
       <artifactId>spring-boot-starter-hello</artifactId>
       <version>1.0-SNAPSHOT</version>
   </dependency>
   ~~~

   

6. **配置.properties文件，如果能读取成功，那么说明自定义starter成功**