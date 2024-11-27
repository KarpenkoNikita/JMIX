package com.company.project_duma.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "PD_ZAYAVKA", indexes = {
        @Index(name = "IDX_PD_ZAYAVKA_KAB", columnList = ""),
        @Index(name = "IDX_PD_ZAYAVKA_ADRESS", columnList = "ADRESS_ID"),
        @Index(name = "IDX_PD_ZAYAVKA_COMPANY", columnList = "COMPANY_ID"),
        @Index(name = "IDX_PD_ZAYAVKA_", columnList = "")
})
@Entity(name = "pd_Zayavka")
public class Zayavka {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @Column(name = "FIO", nullable = false)
    @NotNull
    private String fio;
    @FutureOrPresent
    @Column(name = "DATATIME", nullable = false)
    @NotNull
    private LocalDateTime datatime;
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @NotNull
    @JoinColumn(name = "KAB_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Kabinet kab;
    @JoinColumn(name = "ADRESS_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Adress adress;
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Company company;
    @Column(name = "PROBLEM")
    private String problem;
    @Column(name = "COMMENT_")
    @Lob
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Kabinet getKab() {
        return kab;
    }

    public void setKab(Kabinet kab) {
        this.kab = kab;
    }

    public LocalDateTime getDatatime() {
        return datatime;
    }

    public void setDatatime(LocalDateTime datatime) {
        this.datatime = datatime;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}