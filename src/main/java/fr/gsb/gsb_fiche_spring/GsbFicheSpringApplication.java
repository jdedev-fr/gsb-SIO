package fr.gsb.gsb_fiche_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class GsbFicheSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(GsbFicheSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner testDatabaseConnection(DataSource dataSource) {
		return args -> {
			try (Connection connection = dataSource.getConnection()) {
				System.out.println("✅ CONNEXION MYSQL RÉUSSIE ! Base : " + connection.getCatalog());
			} catch (Exception e) {
				System.err.println("❌ ÉCHEC DE LA CONNEXION MYSQL : " + e.getMessage());
			}
		};
	}
}
