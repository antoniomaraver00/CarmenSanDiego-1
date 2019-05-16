package carmensandiego.test.unittest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.interfaz.Viajero;
import com.carmensandiego.model.lugar.ClubNocturno;
import com.carmensandiego.model.lugar.Lugar;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Canada;
import com.carmensandiego.model.pais.ClavePais;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.pais.Egipto;

public class MundoTest {
	
	private Mundo mundo;
	
	@Before
	public void init() {
		this.mundo = Mundo.getSingletonInstance();
		Map<String,Pais> paises = new HashMap<String,Pais>();
		Pais alemania = new Alemania();
		paises.put(ClavePais.ALEMANIA.getKey(), alemania);
		Pais argentina = new Argentina();
		paises.put(ClavePais.ARGENTINA.getKey(), argentina);
		Pais australia = new Australia();
		paises.put(ClavePais.AUSTRALIA.getKey(), australia);
		Pais egipto = new Egipto();
		paises.put(ClavePais.EGIPTO.getKey(), egipto);
		Pais canada = new Canada();
		paises.put(ClavePais.CANADA.getKey(), canada);
		mundo.agregarPaises(paises);
	}
	
	@Test
	public void protagonistaPuedeVisitarEspaciosSoloDelPaisActual() {
		Viajero viajero = mundo.getProtagonista();
		viajero.viajar(mundo.getPais("ARGENTINA"));
		//Argentina tiene
			//1) Aeropuerto
			//2) Home
			//3) Club Nocturno
		//Protagonista arranca en Home
		viajero.visitar(mundo.getPais("ARGENTINA").getLugares().get(1));
		List<Lugar> lugaresDisponibles = mundo.obtenerEspaciosDisponiblesParaProtagonista();
		List<Lugar> lugares = mundo.getProtagonista().getPaisActual().getLugares();
		//Al menos debe ser un tamano menor
		Assert.assertTrue(lugaresDisponibles.size() == lugares.size() - 1);
		Lugar original = null;
		Lugar nuevo = null;
		for (Lugar lugar : lugares) {
			Lugar aux = new ClubNocturno();
			if(lugar.getNombre().equals(aux.getNombre()))
				original = lugar;
		}
		//Tomamos el club
		nuevo = lugaresDisponibles.get(1);
		Assert.assertTrue(nuevo.getNombre().equals(original.getNombre()));
		//SON EL MISMO OBJETO
	}

	@Test
	public void protagonistaPuedeViajarAOtrosPaises() {
		Viajero viajero = mundo.getProtagonista();
		Pais argentina = mundo.getPais(ClavePais.ARGENTINA.getKey());
		Pais egipto = mundo.getPais(ClavePais.EGIPTO.getKey());
		viajero.viajar(argentina);
		//Argentina tiene
			//1) Home
			//2) Club Nocturno
		//Protagonista arranca en Home
		viajero.visitar(argentina.getLugares().get(0));
		List<Pais> paisesDisponibles = mundo.obtenerPaisesDisponiblesParaProtagonista();
		Assert.assertFalse(paisesDisponibles.contains(argentina));
		Assert.assertTrue(paisesDisponibles.contains(egipto));
	}
}
