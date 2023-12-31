package co.health.service.domain.profesionalsalud.rules;

import co.health.crosscutting.exception.concrete.ServiceHealthException;
import co.health.crosscutting.util.UtilTexto;
import co.health.service.domain.ValidationRule;
import co.health.service.domain.regimenafiliacion.rules.ServiciosRegimenAfiliacionValidationRule;

public class CargoProfesionalSaludValidationRule implements ValidationRule<String> {
private static final ValidationRule<String> instancia = new CargoProfesionalSaludValidationRule();
	
	private CargoProfesionalSaludValidationRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
		validarFormato(dato);
		
	}
	
	private final void validarLongitud(final String dato) {
		if(!UtilTexto.longitudMaximaValida(dato,10)) {
			var mensajeUsuario = "la longitud del nombre del cargo debe ser menor a 20";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if(UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = "El nombre del cargo es un dato obligatorio";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
		
		
	}
	private final void validarFormato(final String dato) {
		if(!UtilTexto.contieneSoloDigitos(dato)) {
			var mensajeUsuario = "El nombre del cargo debe tener solo letras";
			throw ServiceHealthException.crear(mensajeUsuario);
		}
	}

}
