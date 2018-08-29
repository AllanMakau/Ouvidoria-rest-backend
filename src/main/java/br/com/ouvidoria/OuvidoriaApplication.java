package br.com.ouvidoria;

import br.com.ouvidoria.entity.Cidade;
import br.com.ouvidoria.entity.Estado;
import br.com.ouvidoria.entity.Meio;
import br.com.ouvidoria.entity.Tipologia;
import br.com.ouvidoria.repository.CidadeRespository;
import br.com.ouvidoria.repository.EstadoRespository;
import br.com.ouvidoria.repository.MeioRepository;
import br.com.ouvidoria.repository.TipologiaRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OuvidoriaApplication implements CommandLineRunner{

    @Autowired
    MeioRepository meio;
    
    @Autowired
    TipologiaRepository tipo;
    
    @Autowired
    CidadeRespository cidadeRepository;
    
    @Autowired
    EstadoRespository estadoRepository;
    
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

        Tipologia t1 = new Tipologia(null, "Reclamação");
        Tipologia t2 = new Tipologia(null, "Informação");;
        Tipologia t3 = new Tipologia(null, "Elogio");
        Tipologia t4 = new Tipologia(null, "Sugestão");
        Tipologia t5 = new Tipologia(null, "Denúncia");
        
        tipo.saveAll(Arrays.asList(t1,t2,t3,t4,t5));
        
        
                Estado est1 = new Estado(null,"MG", "Minas Gerais");
		Estado est2 = new Estado(null,"SP", "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
