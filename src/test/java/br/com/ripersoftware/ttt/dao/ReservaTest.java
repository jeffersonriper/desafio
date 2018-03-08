package br.com.ripersoftware.ttt.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ripersoftware.desafio.dao.ReservaDAO;
import br.com.ripersoftware.desafio.model.Reservas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservaTest {
	
	@Autowired
	ReservaDAO reservaDAO;
	
	@Test
	public void criar(){
		Reservas reserva=new Reservas();
		reserva.setPessoas("4");
		reserva.setHorario("09:10 AM");
		reserva.setData(new Date());
		
		Assert.assertNull(reserva.getId()); // verifica se o cod no inicio está nulo
		reservaDAO.save(reserva);
		Long id = reserva.getId();
		Assert.assertNotNull(id); // verifica se o cod depois que insere não está nulo
	}
	

}
