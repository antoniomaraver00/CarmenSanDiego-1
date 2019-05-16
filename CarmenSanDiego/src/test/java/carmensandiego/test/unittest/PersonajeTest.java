package carmensandiego.test.unittest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carmensandiego.model.lugar.ClubNocturno;
import com.carmensandiego.model.lugar.Embajada;
import com.carmensandiego.model.lugar.Home;
import com.carmensandiego.model.lugar.Lugar;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Canada;
import com.carmensandiego.model.pais.ClavePais;
import com.carmensandiego.model.pais.Egipto;
import com.carmensandiego.model.pais.NingunPais;
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
	private static Integer sinPistas = 0;
	
	@Before
	public void initProtagonista() {
		protagonista = new Protagonista();
		protagonista.setNombre("Wincho");
		protagonista.setDescripcion("El mejor detective de todos los tiempos");
		Pais paisDeOrigen = new Argentina();
		Lugar hogar = new Home();
		protagonista.viajar(paisDeOrigen);
		protagonista.visitar(hogar);
		
	}
	
	@Before
	public void initAntagonista() {
		antagonista = new Antagonista();
		antagonista.setNombre("Carmen San Diego");
		antagonista.setDescripcion("Dura y Bella criminal");
		Pais paisInicial = new Canada();
		antagonista.viajar(paisInicial);
	}
	
	@Test
	public void elPersonajeDebePoderViajarAUnVisitable() {
		
		Pais australia = new Australia();
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
	public void elPersonajePrincipalDebePoderRecolectarPistasEnLosLugaresDeLosPaises() {
		
		Integer cantidadPistasIniciales = this.protagonista.obtenerPistasAcumuladas().size();
		
		Australia australia = new Australia();
		ClubNocturno clubNocturno = new ClubNocturno();
		Embajada embajada = new Embajada();
		
		Pista pista1 = new Pista("Pista 1");
		Pista pista2 = new Pista("Pista 2");
		
		embajada.informarPista(pista1);
		embajada.informarPista(pista2);
		
		australia.agregarLugar(embajada);
		australia.agregarLugar(clubNocturno);
		
		this.protagonista.viajar(australia);
		this.protagonista.visitar(clubNocturno);
		this.protagonista.visitar(embajada);
		
		Integer cantidadPistasAcumuladas = this.protagonista.obtenerPistasAcumuladas().size();
		
		Assert.assertTrue(cantidadPistasAcumuladas > cantidadPistasIniciales);
	}
	
	@Test
	public void elAntagonistaDebeDropearPistasEnLosLugaresDeLosPaisesAlViajar() {
		Pista pista1 = new Pista("Pista 1");
		Pista pista2 = new Pista("Pista 2");
		
		//El Antagonista comienza en Canada
		//Abstraccion: viaja de ningun lugar a canada.
		Canada origen = new Canada();
		antagonista.viajar(origen);
		
		//Toma otro destino, ejemplo Australia.
		Australia destino = new Australia();
		
		//Canada no tiene pistas distribuidas sobre Australia
		Integer cantidadPistasDistribuidas = sinPistas;
		
		for (Lugar lugar : origen.getLugares()) {
			cantidadPistasDistribuidas+= lugar.darPistas().size();
		}
		
		Assert.assertTrue(sinPistas.equals(cantidadPistasDistribuidas));	
		
		antagonista.acumularPista(pista1);
		antagonista.acumularPista(pista2);
		
		antagonista.viajar(destino);
		
		for (Lugar lugar : origen.getLugares()) {
			cantidadPistasDistribuidas+= lugar.darPistas().size();
		}
		
		Assert.assertFalse(sinPistas.equals(cantidadPistasDistribuidas));				
	}
	
	@Test
	public void antagonistaEligeRecorridoNoDebeIncluirPaisActual() {
		Map<String,Pais> paises = new HashMap<String,Pais>();
		paises.put(ClavePais.ALEMANIA.getKey(),new Argentina());
		paises.put(ClavePais.ARGENTINA.getKey(),new Alemania());
		paises.put(ClavePais.AUSTRALIA.getKey(),new Australia());
		paises.put(ClavePais.CANADA.getKey(),new Canada());
		paises.put(ClavePais.EGIPTO.getKey(),new Egipto());
		antagonista.elegirRecorrido(paises);
		//Consultar y avanzar sobre los destinos
		int count = 0;
		while(count < paisesDestino) {
			Assert.assertFalse(antagonista.getPaisActual().getNombre().equals(antagonista.obtenerProximoDestino().getNombre()));
			antagonista.seguirRecorrido(new NingunPais());
			count++;
		}
	}

}
