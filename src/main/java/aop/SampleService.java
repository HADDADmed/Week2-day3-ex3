package aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

    @TimeIt
    public void doWork() {
        try {
            Thread.sleep(1000); // Simulate work
        } catch (InterruptedException e) {
            logger.error("Thread interrupted while simulating work", e);
        }
    }
}