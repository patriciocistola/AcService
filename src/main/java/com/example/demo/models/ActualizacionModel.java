package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.demo.utils.GeometryToJsonSerializer;
import com.example.demo.utils.JsonToGeometryDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.hibernate.annotations.DynamicInsert;
import org.locationtech.jts.geom.MultiPolygon;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicInsert
@Table(name="actualizacion", schema="public")
public class ActualizacionModel implements Serializable {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id	
	private int id;
	public String usuario; 
	public String observacion; 
	@Column(name="fecha_generacion", columnDefinition = "timestamp with time zone NOT NULL DEFAULT now()")
	public Date fechaGeneracion; 
	@Column(name="fecha_fin_actualizacion")
	public Date fechaFinActualizacion; 
	@Column(columnDefinition = "integer NOT NULL DEFAULT 1")
	public Integer version;
	@JsonSerialize(using = GeometryToJsonSerializer.class)
    @JsonDeserialize(using = JsonToGeometryDeserializer.class)
	private MultiPolygon oa;

}
