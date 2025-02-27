import aop.SampleService;
import config.AopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopExample {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        SampleService sampleService = ctx.getBean(SampleService.class);
        sampleService.doWork(); // This will trigger the aspect
    }
}