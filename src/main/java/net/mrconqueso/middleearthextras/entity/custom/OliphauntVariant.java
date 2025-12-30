package net.mrconqueso.middleearthextras.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum OliphauntVariant {
    DEFAULT(0),
    ORCHID(1);

    private static final OliphauntVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(OliphauntVariant::getId)).toArray(OliphauntVariant[]::new);

    private final int id;

    OliphauntVariant(int id) {this.id = id;}

    public int getId() {return this.id;}

    public static OliphauntVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
