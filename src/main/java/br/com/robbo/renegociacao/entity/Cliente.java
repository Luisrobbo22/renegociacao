package br.com.robbo.renegociacao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Setter
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    @Setter
    @Column(nullable = false)
    private String celular;

    @Setter
    private String telefone;

    @OneToMany
    private List<Debito> debitos;





}
