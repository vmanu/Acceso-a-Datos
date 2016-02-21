package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AsistenciaMedica{
	private int idAsistenciaMedica;
	private String breveDescripcion;
	private String lugar;
	private String explicacion;
	private TipoAsistencia tipoAsistencia;
	private Date fecha;
	private Date hora;
	private BigDecimal importe;
	
	public AsistenciaMedica(String breveDescripcion, String lugar, String explicacion, TipoAsistencia tipoAsistencia, Date fecha, Date hora, BigDecimal importe) {
		this.breveDescripcion = breveDescripcion;
		this.lugar = lugar;
		this.explicacion = explicacion;
		this.tipoAsistencia = tipoAsistencia;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
	}
	
	public AsistenciaMedica() {
		super();
	}
	
	public int getIdAsistenciaMedica() {
		return idAsistenciaMedica;
	}
	
	public void setIdAsistenciaMedica(int idAsistenciaMedica) {
		this.idAsistenciaMedica = idAsistenciaMedica;
	}
	
	public String getBreveDescripcion() {
		return breveDescripcion;
	}
	
	public void setBreveDescripcion(String breveDescripcion) {
		this.breveDescripcion = breveDescripcion;
	}
	
	public String getLugar() {
		return lugar;
	}
	
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public String getExplicacion() {
		return explicacion;
	}
	
	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	
	public TipoAsistencia getTipoAsistencia() {
		return tipoAsistencia;
	}
	
	public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	@Override
	public String toString() {
		return "AsistenciaMedica [idAsistenciaMedica=" + idAsistenciaMedica
				+ ",\n\t\t breveDescripcion=" + breveDescripcion + ",\n\t\t lugar=" + lugar
				+ ", explicacion=" + explicacion + ", tipoAsistencia="
				+ tipoAsistencia + ",\n\t\t fecha=" + fecha + ", hora=" + hora
				+ ", importe=" + importe + "]";
	}
}
