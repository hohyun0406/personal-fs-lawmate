package site.lawmate.lawcase.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.DateFormatter;


@Configuration
public class ServerConfig {

    @Bean
    public String datePattern(){
        return "yyyy-MM-dd'T'HH:mm:ss.xxx";
    }

    @Bean
    public DateFormatter defaultDateFormatter(){
        return new DateFormatter(datePattern());
    }

}
