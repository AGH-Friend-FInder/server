package agh.pin.pals.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionRunner implements CommandLineRunner {

    private final DatabaseConnectionTestService databaseConnectionTestService;

    public DatabaseConnectionRunner(DatabaseConnectionTestService databaseConnectionTestService) {
        this.databaseConnectionTestService = databaseConnectionTestService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(databaseConnectionTestService.testConnection());
    }
}

