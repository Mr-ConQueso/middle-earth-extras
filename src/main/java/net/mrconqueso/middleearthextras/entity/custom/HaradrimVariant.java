package net.mrconqueso.middleearthextras.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum HaradrimVariant {
    DEFAULT(0),
    ORCHID(1);

    private static final HaradrimVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(HaradrimVariant::getId)).toArray(HaradrimVariant[]::new);

    private final int id;

    HaradrimVariant(int id) {this.id = id;}

    public int getId() {return this.id;}

    public static HaradrimVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
