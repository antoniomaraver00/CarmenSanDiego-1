package carmensandiego.test.unittest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Embajada;
import com.carmensandiego.model.espacio.Home;
import com.carmensandiego.model.interfaz.Viajable;
import com.carmensandiego.model.interfaz.Visitable;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Canada;
import com.carmensandiego.model.pais.Egipto;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.personajes.Antagonista;
import com.carmensandiego.model.personajes.PersonajeSecundario;
import com.carmensandiego.model.personajes.Protagonista;
import com.carmensandiego.model.pista.Pista;

public class PersonajeTest {
	
	private Protagonista protagonista;
	private Antagonista antagonista;
	private PersonajeSecundario secundario;
	
	private static Integer cantidadPaises = 5;
	private static Integer paisesDestino = 4;
	
	@Before
	public void initProtagonista() {
		protagonista = new Protagonista();
		protagonista.setNombre("Wincho");
		protagonista.setDescripcion("El mejor detective de todos los tiempos");
		Viajable paisDeOrigen = new Argentina();
		Visitable hogar = new Home();
		protagonista.viajar(paisDeOrigen);
		protagonista.visitar(hogar);
		
	}
	
	@Before
	public void initAntagonista() {
		antagonista = new Antagonista();
		antagonista.setNombre("Carmen San Diego");
		antagonista.setDescripcion("Dura y Bella criminal");
		Viajable paisInicial = new Canada();
		antagonista.viajar(paisInicial);
	}
	
	@Test
	public void elPersonajeDebePoderViajarAUnVisitable() {
		
		Viajable australia = new Australia();
		protagonista.viajar(australia);
		Assert.assertEquals(australia, protagonista.getPaisActual());
	}
	
	@Test
	public void elPersonajeDebePoderVisitarUnEspacioDeUnPais() {
		
		ClubNocturno clubNocturno = new ClubNocturno();
		protagonista.visitar(clubNocturno);
		Assert.assertEquals(clubNocturno,protagonista.getEspacioActual());
	}
	
	@Test
	public void elPersonajePrincipalDebePoderRecolectarPistasDePaisesYLugares() {
		
		Australia australia = new Australia();
		ClubNocturno clubNocturno = new ClubNocturno();
		Embajada embajada = new Embajada();
		
		Pista pista1 = new Pista("Pista 1");
		Pista pista2 = new Pista("Pista 2");
		
		embajada.informarPista(pista1);
		australia.agregarPista(pista2);
		
		australia.agregarEspacio(embajada);
		australia.agregarEspacio(clubNocturno);
		
		this.protagonista.viajar(australia);
		this.protagonista.visitar(clubNocturno);
		this.protagonista.visitar(embajada);
		
		Integer cantidadPistasAcumuladas = this.protagonista.obtenerPistas().size();
		
		Assert.assertTrue(cantidadPistasAcumuladas.equals(2));
		
	}
	
	@Test
	public void elAntagonistaDebeDropearPistasEnPaisesYLugares() {
		Pista pista1 = new Pista("Pista 1");
		Pista pista2 = new Pista("Pista 2");
		
		Australia australia = new Australia();
		ClubNocturno clubNocturno = new ClubNocturno();
		
		australia.agregarEspacio(clubNocturno);
		
		antagonista.setPista(pista1);
		
		antagonista.viajar(australia);
		
		Integer cantidadPistasAcumuladas = this.antagonista.obtenerPistas().size();
		
		Assert.assertTrue(cantidadPistasAcumuladas.equals(0));
		
		antagonista.setPista(pista2);
		
		antagonista.visitar(clubNocturno);
		
		cantidadPistasAcumuladas = this.antagonista.obtenerPistas().size();
		
		Assert.assertTrue(cantidadPistasAcumuladas.equals(0));				
	}
	
	@Test
	public void antagonistaEligeRecorridoNoDebeIncluirPaisActual() {
		List<Pais> paises = new ArrayList<Pais>();
		paises.add(new Argentina());
		paises.add(new Alemania());
		paises.add(new Australia());
		paises.add(new Canada());
		paises.add(new Egipto());
		antagonista.elegirRecorrido(paises);
		//Consultar y avanzar sobre los destinos
		int count = 0;
		while(count < paisesDestino) {
			Assert.assertFalse(antagonista.getPaisActual().getNombre().equals(antagonista.obtenerProximoDestino().getNombre()));
			antagonista.seguirRecorrido();
			count++;
		}
	}

}
