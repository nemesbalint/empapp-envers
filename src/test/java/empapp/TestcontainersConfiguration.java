package empapp;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

@TestConfiguration(proxyBeanMethods = false)
public class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        var container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
                .withUsername("employees")
                .withPassword("employees")
                .withDatabaseName("employees")
                .withExposedPorts(5432)
                .withReuse(true);
        container.setPortBindings(List.of("5432:5432"));
        return container;
    }
}
