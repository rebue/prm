package rebue.prm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;

//这个注解是为了使该包内的过滤器生效。
@ServletComponentScan("rebue.sbs.smx.filter")
@SpringCloudApplication
public class PrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrmApplication.class, args);
    }

}