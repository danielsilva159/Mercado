package com.hepta.mercado.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.hepta.mercado.entity.Fabricante;
import com.hepta.mercado.persistence.FabricanteDAO;

@Path("/fabricantes")
public class FabricanteService {
	@Context
	private HttpServletRequest request;

	@Context
	private HttpServletResponse response;

	private FabricanteDAO dao;
	
	public FabricanteService() {
		dao = new FabricanteDAO();
	}
	protected void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	/**
	 * Lista todos os fabricantes do mercado
	 * 
	 * @return response 200 (OK) - Conseguiu listar
	 */
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response fabricanteRead() {
		List<Fabricante> fabricante = new ArrayList<>();
		try {
			System.out.println("Fabricantes=====");
			fabricante = dao.getAll();
		} catch(Exception e) {
			System.out.println("aquiii");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao buscar fabricante").build();
		}
		
		GenericEntity<List<Fabricante>> entity = new GenericEntity<List<Fabricante>>(fabricante) {};
		return Response.status(Status.OK).entity(entity).build();
	}
	
}
