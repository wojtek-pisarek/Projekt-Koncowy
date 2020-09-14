package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProjektKoncowyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektKoncowyApplication.class, args);
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode("567");
//		System.out.println(hashedPassword);
//	}

}
