import static java.lang.Boolean.TRUE;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.via.varejo.produto.controller.ProdutoController;
import br.com.via.varejo.produto.model.Produto;
import br.com.via.varejo.produto.service.ProdutoService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProdutoController.class)
public class ViaVarejoApplicationTest {

	@MockBean
	private ProdutoService produtoService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void givenProdutoTest() {

		Produto produto = new Produto();

		produto.setId(1L);
		produto.setAtivo(TRUE);
		produto.setNome("Produto Teste");
		produto.setValor(new BigDecimal(2000.00));

		List<Produto> listaProduto = new ArrayList<Produto>();

		listaProduto.add(produto);

		when(produtoService.obterTodos()).thenReturn(listaProduto);

	}

	@Test
	public void getProdutoByIdTest() {

		Produto produto = new Produto();

		produto.setId(1L);
		produto.setAtivo(TRUE);
		produto.setNome("Produto Teste");
		produto.setValor(new BigDecimal(2000.00));

		when(produtoService.obterUm(1L)).thenReturn(produto);
	}

	@Test
	public void saveProdutoTest() {

		Produto produto = new Produto();

		produto.setId(1L);
		produto.setAtivo(TRUE);
		produto.setNome("Produto Teste");
		produto.setValor(new BigDecimal(2000.00));

		Produto saved = produto;
		saved.setId(1L);
		saved.setAtivo(TRUE);
		saved.setNome("Produto Teste");
		saved.setValor(new BigDecimal(2000.00));

		when(produtoService.salvar(produto)).thenReturn(saved);
	}

	@Test
	public void deleteProdutoTest() throws Exception {

		mvc.perform(delete("/api/produto/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
