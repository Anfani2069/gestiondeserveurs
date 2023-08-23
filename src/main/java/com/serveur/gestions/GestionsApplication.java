package com.serveur.gestions;

import com.serveur.gestions.model.Server;
import com.serveur.gestions.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.serveur.gestions.enumeration.Status.SERVER_DOWN;
import static com.serveur.gestions.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class GestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionsApplication.class, args);

	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/image/server1.png", SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.58", "Fedora Linux", "16 GB", "Dell Tower","http://localhost:8080/server/image/server2.png", SERVER_DOWN));
			serverRepository.save(new Server(null, "192.168.1.21", "MS 2008", "32 GB", "Web Server", "http://localhost:8080/server/image/server3.png", SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "64 GB", "Mail Server", "http://localhost:8080/server/image/server4.png", SERVER_DOWN));
		};
	}

}
