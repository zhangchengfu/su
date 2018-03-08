1,访问 http://start.spring.io/
2,生成项目，解压，导入项目

application配置文件，hibernate.hbm2ddl.auto作用：自动创建|更新|验证数据库表结构，有四个值：
        create： 每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
        create-drop ：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
        update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据 model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。
        validate ：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。
dialect 主要是指定生成表名的存储引擎为InneoDB
show-sql 是否打印出自动生产的SQL，方便调试的时候查看

spring boot中文乱码解决：
1，约定传参编码格式都是utf-8
2，修改application.properties
    spring.http.encoding.force=true
    spring.http.encoding.charset=UTF-8
    spring.http.encoding.enabled=true
    server.tomcat.uri-encoding=UTF-8
3，
    3.1，修改Controller的@RequestMapping:produces="application/json;charset=UTF-8"  ，也可在配置类：
    3.2，
    @Configuration
    public class CustomMVCConfiguration extends WebMvcConfigurerAdapter {

        @Bean
        public HttpMessageConverter<String> responseBodyConverter() {
            StringHttpMessageConverter converter = new StringHttpMessageConverter(
                    Charset.forName("UTF-8"));
            return converter;
        }

        @Override
        public void configureMessageConverters(
                List<HttpMessageConverter<?>> converters) {
            super.configureMessageConverters(converters);
            converters.add(responseBodyConverter());
        }

        @Override
        public void configureContentNegotiation(
                ContentNegotiationConfigurer configurer) {
            configurer.favorPathExtension(false);
        }
    }

4,启动项目后，http://localhost:8080,用户名：admin，密码：123456