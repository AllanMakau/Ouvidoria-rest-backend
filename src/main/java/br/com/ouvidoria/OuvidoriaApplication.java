package br.com.ouvidoria;

import br.com.ouvidoria.entity.Cidade;
import br.com.ouvidoria.entity.Estado;
import br.com.ouvidoria.entity.Manifestante;
import br.com.ouvidoria.entity.Meio;
import br.com.ouvidoria.entity.Tipologia;
import br.com.ouvidoria.enums.Sexo;
import br.com.ouvidoria.enums.TipoManifestante;
import br.com.ouvidoria.repository.CidadeRespository;
import br.com.ouvidoria.repository.EstadoRespository;
import br.com.ouvidoria.repository.ManifestanteRepository;
import br.com.ouvidoria.repository.MeioRepository;
import br.com.ouvidoria.repository.TipologiaRepository;
import java.text.SimpleDateFormat;
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
    
    @Autowired
    ManifestanteRepository manifRespository;
    
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
                Estado est3 = new Estado(null,"BA", "Bahia");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
                Cidade c4 = new Cidade(null, "Salvador", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
                est3.getCidades().addAll(Arrays.asList(c4));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3,c4)); 
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                
                Manifestante M1 = new Manifestante(Integer.SIZE, "Alan de Jesus Lima", Sexo.MASCULINO, sdf.parse("18/02/1989 00:00"), 
                        TipoManifestante.PESSOA_FISICA, m1, "40.342-000", "Rua Dr Aristides de Oliveira", "750 E", 
                        "Final de Linha", "Santa Mônica", "Brasil", c4, "alan.makau@gmail.com", "71 3377-5633", "71 991637645");
                
                 Manifestante M2 = new Manifestante(Integer.SIZE, "Fernanda Santos Silva", Sexo.FEMININO, sdf.parse("05/01/1993 00:00"), 
                        TipoManifestante.PESSOA_FISICA, m2, "01.307-000", "Rua Frei Caneca", "92", 
                        "Frei Caneca Life", "Consolaçao", "Brasil", c3, "afeh.05@gmail.com", "71 3377-5633", "71 992923224");
                 
                 Manifestante M3 = new Manifestante(Integer.SIZE, "TRIGG CARTÕES", Sexo.NAOAPLICA, sdf.parse("05/01/1980 00:00"), 
                        TipoManifestante.PESSOA_JURIDICA, m2, "01.307-000", "Centro", "99", 
                        "Sé", "Centro", "Brasil", c2, "trigg@trigg.com", "0800 700 5442", "71 3003-2142");
                 
                 manifRespository.saveAll(Arrays.asList(M1,M2,M3));
                
    }
}
