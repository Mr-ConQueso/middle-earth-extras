package net.mrconqueso.middleearthextras.datagen.content.models;

import net.minecraft.item.Item;
import net.mrconqueso.middleearthextras.item.ModRingItems;

import java.util.ArrayList;
import java.util.List;

public class SimpleRingModel {
    public static List<Item> items = new ArrayList<>() {
        {
            // The Nine
            add(ModRingItems.ADUNAPHEL);
            add(ModRingItems.AKHORAHIL);
            add(ModRingItems.HOARMURATH);
            add(ModRingItems.JIINDUR);
            add(ModRingItems.KHAMUL);
            add(ModRingItems.MURAZOR);
            add(ModRingItems.REN);
            add(ModRingItems.UVATHA);
            add(ModRingItems.LAST);

            // The Seven
            add(ModRingItems.THROR);
            add(ModRingItems.BARAZ);
            add(ModRingItems.BURIN);
            add(ModRingItems.FARIN);
            add(ModRingItems.KHAIN);
            add(ModRingItems.KHIBIL);
            add(ModRingItems.THULIN);

            // The Three
            add(ModRingItems.NARYA);
            add(ModRingItems.NENYA);
            add(ModRingItems.VILYA);

            // The One Ring
            add(ModRingItems.THE_ONE);
        }
    };
}
