package app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class appComponent {
    public appComponent(String bar) { log.info("constructing foo component using string {}", bar); }
}
