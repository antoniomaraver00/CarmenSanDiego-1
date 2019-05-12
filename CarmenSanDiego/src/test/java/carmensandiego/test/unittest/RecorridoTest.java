package carmensandiego.test.unittest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.carmensandiego.model.Mundo;
import com.carmensandiego.model.pais.Alemania;
import com.carmensandiego.model.pais.Argentina;
import com.carmensandiego.model.pais.Australia;
import com.carmensandiego.model.pais.Egipto;
import com.carmensandiego.model.pais.Pais;
import com.carmensandiego.model.recorrido.Recorrido;

public class RecorridoTest {
	
	private Mundo mundo;
	
	@Before
	public void init() {
		this.mundo = Mundo.getSingletonInstance();
		Map<String,Pais> paises = new HashMap<String,Pais>();
		//Agrego paises en orden
		Pais alemania = new Alemania();
		paises.put("ALEMANIA", alemania);
		Pais argentina = new Argentina();
		paises.put("ARGENTINA", argentina);
		Pais australia = new Australia();
		paises.put("AUSTRALIA", australia);
		Pais egipto = new Egipto();
		paises.put("EGIPTO", egipto);
		mundo.agregarPaises(paises);
	}
	
	@Test
	public void proximoDestinoDebeSerElPrimerElementoDeLaLista() {
		Recorrido recorrido = new Recorrido(new ArrayList<Pais>(mundo.obtenerPaisesOrdenadosAlfabeticamente()));
		//El primer pais alfabeticamente es Alemania
		Alemania esperado = new Alemania();
		Pais obtenido = recorrido.obtenerProximoDestino();
		System.out.println(obtenido.getNombre());
		Assert.assertTrue(esperado.getNombre().equals(obtenido.getNombre()));
	}

}
