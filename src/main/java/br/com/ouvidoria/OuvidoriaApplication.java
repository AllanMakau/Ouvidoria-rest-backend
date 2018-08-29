package br.com.ouvidoria;

import br.com.ouvidoria.entity.Meio;
import br.com.ouvidoria.repository.MeioRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OuvidoriaApplication implements CommandLineRunner{

    @Autowired
    MeioRepository meio;
	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
       
        Meio m1 = new Meio(null, "Email");
        Meio m2 = new Meio(null, "Telefone");;
        Meio m3 = new Meio(null, "Carta");
        Meio m4 = new Meio(null, "Fax");
        
        meio.saveAll(Arrays.asList(m1,m2,m3,m4));

        
    }
}
