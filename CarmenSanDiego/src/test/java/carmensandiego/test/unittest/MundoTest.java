package carmensandiego.test.unittest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.espacio.ClubNocturno;
import com.carmensandiego.model.espacio.Espacio;
import com.carmensandiego.model.interfaz.ViajeroInterface;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.pais.Egipto;

public class MundoTest {
	
	private Mundo mundo;
	
	@Before
	public void init() {
		this.mundo = Mundo.getSingletonInstance();
		Map<String,Pais> paises = new HashMap<String,Pais>();
		Pais alemania = new Alemania();
		paises.put("ALEMANIA", alemania);
		Pais argentina = new Argentina();
		paises.put("ARGENTINA", argentina);
		Pais espania = new Australia();
		paises.put("ESPANIA", espania);
		Pais rusia = new Egipto();
		paises.put("RUSIA", rusia);
		mundo.agregarPaises(paises);
	}
	
	@Test
	public void protagonistaPuedeVisitarEspaciosSoloDelPaisActual() {
		ViajeroInterface viajero = mundo.getProtagonista();
		viajero.viajar(mundo.getPais("ARGENTINA"));
		//Argentina tiene
			//1) Home
			//2) Club Nocturno
		//Protagonista arranca en Home
		viajero.visitar(mundo.getPais("ARGENTINA").getEspacios().get(0));
		List<Espacio> espaciosNuevos = mundo.obtenerEspaciosDisponiblesParaProtagonista();
		List<Espacio> espaciosViejos = mundo.getProtagonista().getPaisActual().getEspacios();
		Assert.assertTrue(espaciosNuevos.size() == espaciosViejos.size() - 1);
		Espacio original = null;
		Espacio nuevo = null;
		for (Espacio espacio : espaciosViejos) {
			Espacio aux = new ClubNocturno();
			if(espacio.getNombre() == aux.getNombre())
				original = espacio;
		}
		nuevo = espaciosNuevos.get(0);
		Assert.assertTrue(nuevo.getNombre() == original.getNombre());
		//SON EL MISMO OBJETO
		//Assert.assertNotSame(original, nuevo);
	}

	@Test
	public void protagonistaPuedeViajarAOtrosPaises() {
		ViajeroInterface viajero = mundo.getProtagonista();
		Pais argentina = mundo.getPais("ARGENTINA");
		Pais rusia = mundo.getPais("RUSIA");
		viajero.viajar(argentina);
		//Argentina tiene
			//1) Home
			//2) Club Nocturno
		//Protagonista arranca en Home
		viajero.visitar(argentina.getEspacios().get(0));
		List<Pais> paisesDisponibles = mundo.obtenerPaisesDisponiblesParaProtagonista();
		Assert.assertFalse(paisesDisponibles.contains(argentina));
		Assert.assertTrue(paisesDisponibles.contains(rusia));
	}
}
