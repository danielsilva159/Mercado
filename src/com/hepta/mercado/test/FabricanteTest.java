package com.hepta.mercado.test;

import java.util.List;

import org.junit.Test;

import com.hepta.mercado.entity.Fabricante;
import com.hepta.mercado.persistence.FabricanteDAO;

public class FabricanteTest {
	
	@Test
	public void salvarFabricante(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricante.setNome("www");
		try {
			fabricanteDAO.save(fabricante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void updateFabricante(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		try {
			fabricante = fabricanteDAO.find(1);
			fabricante.setNome("Casas Bahia");
			fabricante = fabricanteDAO.update(fabricante);
			System.out.println(fabricante);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void listarTudo(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		try {
			List<Fabricante> fabricantes = fabricanteDAO.getAll();
			System.out.println(fabricantes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletarFabricante(){
		Fabricante fabricante = new Fabricante();
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		try {
			fabricante = fabricanteDAO.find(2);
			fabricanteDAO.delete(fabricante.getId());
			System.out.println("Deletado com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
