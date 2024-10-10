package com.abouther.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "jogos")
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idjogos")
	private Integer id;
	
	@Column(name= "id_esportes")
	private Integer esporteId;
	
	@Column(name= "data_jogo")
	private String data;
	
	@Column(name= "horario")
	private String horario;
	
	@Column(name= "local_jogo")
	private String local;
	
	@Column(name= "canal")
	private String canal;
	
	@Column(name= "time_jogo")
	private String time;

	@Column(name= "time2_jogo")
	private String time2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_esportes() {
		return esporteId;
	}

	public void setId_esportes(Integer id_esportes) {
		this.esporteId = id_esportes;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time) {
		this.time2 = time;
	}
	
	@Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", esporte='" + esporteId + '\'' +
                ", data='" + data + '\'' +
                ", horário='" + horario + '\'' +
                ", local='" + local + '\'' +
				", canal='" + canal + '\'' +
                ", time='" + time + '\'' +
                ", time2='" + time2 + '\'' +
                // Adicione outros campos conforme necessário
                '}';
    }
	
	
}
