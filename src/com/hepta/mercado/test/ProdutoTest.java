package com.hepta.mercado.test;

import java.util.List;

import org.junit.Test;

import com.hepta.mercado.entity.Fabricante;
import com.hepta.mercado.entity.Produto;
import com.hepta.mercado.persistence.FabricanteDAO;
import com.hepta.mercado.persistence.ProdutoDAO;

public class ProdutoTest {
	
	@Test
	public void salvarProduto(){
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produto.setNome("Bermuda");
		produto.setEstoque(50);
		produto.setUnidade("M");
		produto.setVolume(40.0);
		try {
			FabricanteDAO dao = new FabricanteDAO();
			
			produto.setFabricante(dao.find(1));
			produtoDAO.save(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void updateProduto(){
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			produto = produtoDAO.find(1);
			produto.setNome("Colar");
			produto = produtoDAO.update(produto);
			System.out.println(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void listarTudo(){
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		try {
			List<Produto> produtos = produtoDAO.getAll();
			System.out.println(produtos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletarFabricante(){
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			produto = produtoDAO.find(2);
			produtoDAO.delete(produto.getId());
			System.out.println("Deletado com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
