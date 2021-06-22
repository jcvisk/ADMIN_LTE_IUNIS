package com.iunis.adminiunis.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "username",unique = true)
    private String userName;

    //@NotBlank
    //@Size(min = 5, max = 8)
    @Column(name = "userpassword")
    private String userPassword;

    //@NotBlank
    @Transient
    private String confirmUserPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="roles_usuarios"
            ,joinColumns=@JoinColumn(name="idusuario")
            ,inverseJoinColumns=@JoinColumn(name="idrole"))
    private Set<Role> roles;

    @JoinColumn(name = "iddatospersonales", referencedColumnName = "id")
    @OneToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private DatosPersonales datospersonales;

    @ManyToOne
    @JoinColumn(name = "idestatus", referencedColumnName = "id")
    private Estatus estatus;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }
}