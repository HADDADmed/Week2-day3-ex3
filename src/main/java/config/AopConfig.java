package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // Enables AspectJ auto-proxying
@ComponentScan(basePackages = "aop") // Scans for components
public class AopConfig {}