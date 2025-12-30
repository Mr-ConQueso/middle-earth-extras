package net.mrconqueso.middleearthextras.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum BeorningVariant {
    DEFAULT(0),
    ORCHID(1);

    private static final BeorningVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator
            .comparingInt(BeorningVariant::getId)).toArray(BeorningVariant[]::new);

    private final int id;

    BeorningVariant(int id) {this.id = id;}

    public int getId() {return this.id;}

    public static BeorningVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
