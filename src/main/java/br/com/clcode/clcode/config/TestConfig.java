package br.com.clcode.clcode.config;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.clcode.clcode.model.entities.Cliente;
import br.com.clcode.clcode.model.entities.Endereco;
import br.com.clcode.clcode.model.entities.OrdemServico;
import br.com.clcode.clcode.model.entities.PrestadorServico;
import br.com.clcode.clcode.model.entities.Servico;
import br.com.clcode.clcode.model.entities.Usuario;
import br.com.clcode.clcode.repositories.ClienteRepository;
import br.com.clcode.clcode.repositories.EnderecoRepository;
import br.com.clcode.clcode.repositories.OrdemServicoRepository;
import br.com.clcode.clcode.repositories.PrestadorServicoRepository;
import br.com.clcode.clcode.repositories.ServicoRepository;
import br.com.clcode.clcode.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PrestadorServicoRepository prestadorServicoRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Administrador", "admin@admin.com", "admin123");
		Usuario u2 = new Usuario(null, "Caroline Lameirão", "carolinelameirao@outlook.com", "123456cl");
		
		Endereco e1 = new Endereco(null, "Rua Florêncio Lima", 330, "", "Sarapui", "Duque de Caxias", "RJ", "25050-130");
		Endereco e2 = new Endereco(null, "Rua das Flores", 100, "", "Centro", "Rio de Janeiro", "RJ", "22050-000");
		
		Cliente c1 = new Cliente(null, "Caroline Lameirão", "127.878.537-06", "(21) 98293-5810", "carolinelameirao@outlook.com", LocalDate.parse("1987-10-13"), e1);
		Cliente c2 = new Cliente(null, "Maria da Silva", "123.456.789-06", "(21) 96325-7412", "mariadasilva@outlook.com", LocalDate.parse("2000-10-16"), e2);
		
		PrestadorServico ps1 = new PrestadorServico(null, "Caroline Lameirão", "Desenvolvedora Java", "127.878.537-06", "(21) 98293-5810", "carolinelameirao@outlook.com", LocalDate.parse("1987-10-13"), e1);
		PrestadorServico ps2 = new PrestadorServico(null, "Maria da Silva", "Design", "123.456.789-06", "(21) 96325-7412", "mariadasilva@outlook.com", LocalDate.parse("2000-10-16"), e2);
		
		Servico s1 = new Servico(null, "Site", "Landing Page", 800.00);
		Servico s2 = new Servico(null, "Design", "Identidade Visual", 200.00);
		
		OrdemServico os1 = new OrdemServico(null, Instant.now(), LocalDate.parse("2023-02-25"), c2, ps1, s1);
		OrdemServico os2 = new OrdemServico(null, Instant.now(), LocalDate.parse("2023-03-01"), c1, ps2, s2);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
		
		prestadorServicoRepository.saveAll(Arrays.asList(ps1, ps2));
		
		servicoRepository.saveAll(Arrays.asList(s1, s2));
		
		ordemServicoRepository.saveAll(Arrays.asList(os1, os2));
	}	
}
