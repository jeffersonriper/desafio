package br.com.ripersoftware.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import br.com.ripersoftware.desafio.dao.ReservaDAO;
import br.com.ripersoftware.desafio.model.JsonResponse;
import br.com.ripersoftware.desafio.model.Reservas;
import br.com.ripersoftware.desafio.model.Status;



@Controller
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	ReservaDAO reservaDAO;
	
	//criar (POST)
			@RequestMapping(value="/criar", method=RequestMethod.POST) 
			@ResponseBody
			public JsonResponse criar(@RequestBody Reservas reserva){
				JsonResponse resposta = new JsonResponse();
				
				try {
					reservaDAO.save(reserva);
					resposta.setStatus(Status.SUCESSO);
					resposta.setMensagem("Sucesso ao salvar!");
					
				} catch (Exception e) {
					resposta.setStatus(Status.ERRO);
					resposta.setMensagem("Ocorreu um erro ao salvar: " + e.getMessage());
				}
				return resposta ;
			}
			
			
	//deletar (DELETE)
			@RequestMapping(value="/deletar/{codigo}",method=RequestMethod.DELETE)
			@ResponseBody
			public JsonResponse deletar(@PathVariable Long codigo){
				JsonResponse resposta = new JsonResponse();
				
				try {
					reservaDAO.delete(codigo);
					resposta.setStatus(Status.SUCESSO);
					resposta.setMensagem("Sucesso ao deletar!");
					
				} catch (Exception e) {
					resposta.setStatus(Status.ERRO);
					resposta.setMensagem("Ocorreu um erro ao deletar" + e.getMessage());
				}
				
				
				return resposta;
			}
			
	//atualizar (PUT)
			@RequestMapping(value="/atualizar", method=RequestMethod.POST) 
			@ResponseBody
			public JsonResponse atualizar(@RequestBody Reservas reserva){
				JsonResponse resposta = new JsonResponse();
				
				try {
				
					reservaDAO.save(reserva);
					resposta.setStatus(Status.SUCESSO);
					resposta.setMensagem("Sucesso ao atualizar!");
					
				} catch (Exception e) {
					resposta.setStatus(Status.ERRO);
					resposta.setMensagem("Ocorreu um erro ao atualizar: " + e.getMessage());
				}
				return resposta ;
			}
			
	//buscar (GET)
			@RequestMapping(value="/buscarTodos", method=RequestMethod.GET)  
			@ResponseBody
			public JsonResponse buscarTodos(){
				JsonResponse resposta = new JsonResponse();
				try {
					List<Reservas> lista = reservaDAO.findAll();
					resposta.setObjeto(lista);
					resposta.setStatus(Status.SUCESSO);
					resposta.setMensagem("Sucesso ao buscar!");
					
				} catch (Exception e) {
					resposta.setStatus(Status.ERRO);
					resposta.setMensagem("Ocorreu um erro ao Buscar: " + e.getMessage());
				}
				return resposta; 
			}
}
