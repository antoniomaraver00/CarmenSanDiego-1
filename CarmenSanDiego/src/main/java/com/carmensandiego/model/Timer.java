package com.carmensandiego.model;

import com.carmensandiego.model.parametria.ParametriaTime;

/**
 * Esta clase es responsable de contabilizar el tiempo del juego.
 * Sus tareas son
 * 	Cargar desde parametria el tiempo de vida del Juego.
 * 	Cada vez que es llamada modificar el tiempo utilizado por una accion del juego.
 * 	Ofrecer el tiempo restante que queda.
 * @author mperez
 *
 */
public class Timer {
	
	private static Timer timer = null;
	
	private Long timestamp;
	private static Long hoursPerDay = 24L;
	private static Long minutesPerHour = 60L;
	private static Long secondPerMinute = 60L;
	private static Long milis = 1000L;
	
	public Timer() {
		this.timestamp = this.daysToMilis(ParametriaTime.INIT_TIME.getValue());
	}
	
	public static Timer getSingletonInstance(){
		if(timer == null)
			timer = new Timer();
		return timer;
	}
	
	/**
	 * Descuenta el tiempo de vida de juego.
	 * Recibe la cantidad de tiempo que se avanzo en horas.
	 * @param milis
	 */
	public void descontarTiempo(Long hours) {
		if(this.timestamp > 0)
			this.timestamp -= this.hourToMilis(hours);
	}
	
	/**
	 * Transformar de dias a milisegundos
	 * @param day
	 * @return
	 */
	private Long daysToMilis(Long day){
		return(day * hoursPerDay * minutesPerHour * secondPerMinute * milis);
	}
	
	/**
	 * Transformar de horas a milisegundos
	 * @param hour
	 * @return
	 */
	private Long hourToMilis(Long hour) {
		return(hour * minutesPerHour * secondPerMinute * milis);
	}

	/**
	 * Retorna si el tiempo de juego se ha agotado
	 * @return
	 */
	public Boolean tiempoAgotado() {
		return this.timestamp <= 0;
	}

	/**
	 * Retorna el tiempo restante
	 * @return
	 */
	public String getTiempoRestante() {
		Long days = (this.timestamp / milis / secondPerMinute / minutesPerHour / hoursPerDay);
		Long hours = (this.timestamp / milis / secondPerMinute / minutesPerHour) % hoursPerDay;
		return new StringBuilder().append("Dias: ").append(days).append(" Horas: ").append(hours).toString();
	}
}
