package net.mrconqueso.middleearthextras.entity.custom;

public interface IWraithEntity {
    default boolean canSeeUnseen() {
        return true;
    }
}
