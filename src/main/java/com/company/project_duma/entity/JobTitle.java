package com.company.project_duma.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum JobTitle implements EnumClass<String> {

    DEPUTAT("A"),
    POMDEPUTAT("B"),
    SECRETAR("C");

    private final String id;

    JobTitle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static JobTitle fromId(String id) {
        for (JobTitle at : JobTitle.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}