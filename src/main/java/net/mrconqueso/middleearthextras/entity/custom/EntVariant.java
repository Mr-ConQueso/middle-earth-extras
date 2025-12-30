package net.mrconqueso.middleearthextras.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum EntVariant {
    OAK(0),
    SPRUCE(1);

    private static final EntVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(EntVariant::getId)).toArray(EntVariant[]::new);

    private final int id;

    EntVariant(int id) {this.id = id;}

    public int getId() {return this.id;}

    public static EntVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
