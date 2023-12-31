package co.health.service.domain.paciente;

import java.sql.Date;
import java.util.UUID;

import co.health.crosscutting.util.UtilDate;
import co.health.crosscutting.util.UtilObjeto;
import co.health.service.domain.paciente.support.ContactoPacienteDomain;
import co.health.service.domain.paciente.support.InformacionAfiliacionPacienteDomain;
import co.health.service.domain.paciente.support.NombreCompletoPacienteDomain;
import co.health.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class PacienteDomain {
	
	private UUID id;
	private String numeroIdentificacion;
	private NombreCompletoPacienteDomain nombreCompletoPaciente;
	private ContactoPacienteDomain contactoPaciente;
	private Date fechaNacimiento;
	private TipoIdentificacionDomain tipoIdentificacion;
	private InformacionAfiliacionPacienteDomain informacionAfiliacionPaciente;

	
	private PacienteDomain(final UUID id, final String numeroIdentificacion, final NombreCompletoPacienteDomain nombreCompletoPaciente,
			final ContactoPacienteDomain contactoPaciente, final Date fechaNacimiento,
			final TipoIdentificacionDomain tipoIdentificacion, final InformacionAfiliacionPacienteDomain informacionAfiliacionPaciente) {
		setId(id);
		setNumeroIdentificacion(numeroIdentificacion);
		setNombreCompletoPaciente(nombreCompletoPaciente);
		setContactoPaciente(contactoPaciente);
		setInformacionAfiliacionPaciente(informacionAfiliacionPaciente);
		setFechaNacimiento(fechaNacimiento);
		setTipoIdentificacion(tipoIdentificacion);
	}

	public static final PacienteDomain crear(final UUID id, final String numeroIdentificacion, final NombreCompletoPacienteDomain nombreCompletoPaciente,
			final ContactoPacienteDomain contactoPaciente, final Date fechaNacimiento,
			final TipoIdentificacionDomain tipoIdentificacion, final InformacionAfiliacionPacienteDomain informacionAfiliacionPaciente) {
		return new PacienteDomain(id, numeroIdentificacion, 
				nombreCompletoPaciente, contactoPaciente, fechaNacimiento, tipoIdentificacion, informacionAfiliacionPaciente);
	}

	public final UUID getId() {
		return id;
	}

	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public final NombreCompletoPacienteDomain getNombreCompletoPaciente() {
		return nombreCompletoPaciente;
	}

	public final ContactoPacienteDomain getContactoPaciente() {
		return contactoPaciente;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final InformacionAfiliacionPacienteDomain getInformacionAfiliacionPaciente() {
		return informacionAfiliacionPaciente;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	private final void setNombreCompletoPaciente(final NombreCompletoPacienteDomain nombreCompletoPaciente) {
		this.nombreCompletoPaciente = UtilObjeto.obtenerValorDefecto(nombreCompletoPaciente, new NombreCompletoPacienteDomain());
	}

	private final void setContactoPaciente(final ContactoPacienteDomain contactoPaciente) {
		this.contactoPaciente = UtilObjeto.obtenerValorDefecto(contactoPaciente, new ContactoPacienteDomain());
	}

	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = UtilObjeto.obtenerValorDefecto(fechaNacimiento, UtilDate.crearFechaPorDefecto());
	}

	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefecto(tipoIdentificacion, new TipoIdentificacionDomain());
	}

	private final void setInformacionAfiliacionPaciente(final InformacionAfiliacionPacienteDomain informacionAfiliacionPaciente) {
		this.informacionAfiliacionPaciente = UtilObjeto.obtenerValorDefecto(informacionAfiliacionPaciente, new InformacionAfiliacionPacienteDomain());
	}


}
