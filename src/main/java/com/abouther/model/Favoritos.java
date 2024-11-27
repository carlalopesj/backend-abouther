package com.abouther.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuario_jogo")
public class Favoritos {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "idusuario_jogo")
	private Integer id;

    @Column(name= "fk_usuario")
	private Integer usuarioId;

    @Column(name= "fk_jogo")
	private Integer jogoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getJogoId() {
        return jogoId;
    }

    public void setJogoId(Integer jogoId) {
        this.jogoId = jogoId;
    }

    @Override
    public String toString() {
        return "Favoritos {" + 
                "User id=" + usuarioId +
                ", Jogo id='" + jogoId + '\'' +
                // Adicione outros campos conforme necessário
                '}';
    }
    
}
