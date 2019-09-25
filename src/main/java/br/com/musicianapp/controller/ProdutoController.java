package br.com.musicianapp.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musicianapp.controller.viewhelper.CadastroProdutoVH;
import br.com.musicianapp.domain.EntidadeDominio;
import br.com.musicianapp.domain.Produto;
import br.com.musicianapp.impl.Resultado;
import br.com.musicianapp.repository.ProdutoRepository;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private Facade facade;
	
	@Autowired
	private Produto produto;
	
	@Autowired
	private CadastroProdutoVH cadastroProduto;
	
	@GetMapping("{id}")
	public Produto consultarProduto(@PathVariable int id){
		this.produto.setId(id);
		this.facade.setParametro("prodId");
		List<EntidadeDominio> entidades = facade.consultar(this.produto);
		Produto produto = (Produto) entidades.get(0);
		return produto;	
	}
	
	@GetMapping()
	public List<Produto> consultarProduto(){
		this.facade.setParametro("all");
		List<EntidadeDominio> entidades = facade.consultar(this.produto);
		List<Produto> produtos = new ArrayList<Produto>();
		for (EntidadeDominio ent : entidades) {
			produtos.add((Produto)ent);
		}
		return produtos;
	}
	
	@PostMapping("teste2")
	public Produto getImage() throws IOException{
        Optional<Produto> optProduto= repository.findById(252);
        Produto p = optProduto.get();
        byte[] imageByte = p.getImagem();
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        BufferedImage image = ImageIO.read(bis);
        
        ImageIO.write(image, "JPG", new File("//home//douglas//Imagens//resultado.jpeg") );
		return null;
	}
	@Autowired
	private ProdutoRepository repository;
	@PostMapping("teste")
	public Produto teste(@RequestBody Produto produto) throws IOException{
		File img = new File(produto.getPathImage());
		BufferedImage image = ImageIO.read(img); 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
        try {
            ImageIO.write(image, "JPG", bos);
            byte[] imageBytes = bos.toByteArray();
 
//            Produto produto = new Produto();
            produto.setImagem(imageBytes);
//            repository.save(produto);
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	@PostMapping
	public Produto salvarProduto(@RequestBody Produto produto){
		produto = (Produto) cadastroProduto.prepararParaSalvar(produto);
		facade.salvar(produto);
		return null;
	}
	
	@PutMapping("{id}")
	public Object alterarProduto(@RequestBody Produto produto, @PathVariable int id){
		produto.setId(id);
		produto = (Produto) cadastroProduto.prepararParaSalvar(produto);

		Resultado resultado = this.facade.alterar(produto);
		
		if(resultado!=null) {
			return resultado;
		}
		
		return null;
	}
	
	@DeleteMapping("{id}")
	public void deletarProduto(@PathVariable int id){
		produto.setId(id);
		facade.apagar(produto);
	}
}
