package net.mrconqueso.middleearthextras.screen.custom;

import net.minecraft.block.Block;
import net.minecraft.block.DyedCarpetBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.mrconqueso.middleearthextras.entity.custom.OliphauntEntity;
import net.mrconqueso.middleearthextras.item.custom.OliphauntArmorItem;
import net.mrconqueso.middleearthextras.screen.ModScreenHandlers;

import java.util.List;
import java.util.UUID;

public class OliphauntScreenHandler extends ScreenHandler {
    private Inventory warturtleContainer;
    public OliphauntEntity oliphaunt;

    // With Help from https://github.com/Mrbysco/ChocoCraft4/tree/arch/1.21
    // Under MIT LICENSE
    public static OliphauntScreenHandler create(int i, PlayerInventory inventory, UUID uuid) {
        List<OliphauntEntity> turtles = inventory.player.getWorld().getEntitiesByClass(OliphauntEntity.class,
                inventory.player.getBoundingBox().expand(16), test -> test.getUuid().equals(uuid));
        OliphauntEntity OliphauntEntity = turtles.isEmpty() ? null : turtles.getFirst();
        return new OliphauntScreenHandler(i, inventory, new SimpleInventory(28), OliphauntEntity, 4);
    }

    public OliphauntScreenHandler(int containerId, PlayerInventory inventory, Inventory warturtleContainer, final OliphauntEntity OliphauntEntity, int columns) {
        super(ModScreenHandlers.OLIPHAUNT_SCREEN_HANDLER, containerId);
        this.warturtleContainer = warturtleContainer;
        this.oliphaunt = OliphauntEntity;
        warturtleContainer.onOpen(inventory.player);

        // Armor Slot
        this.addSlot(new Slot(warturtleContainer, 0, 8, 63) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.getItem() instanceof OliphauntArmorItem;
            }
        });
        // Dye Slot
        this.addSlot(new Slot(warturtleContainer, 1, 44, 63) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return OliphauntEntity.hasArmorOn() && Block.getBlockFromItem(stack.getItem()) instanceof DyedCarpetBlock;
            }

            @Override
            public int getMaxItemCount() {
                return 1;
            }
        });

        // Chest Slot Tier 1
        this.addSlot(new Slot(warturtleContainer, 2, 72, 27) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.CHEST);
            }

            @Override
            public boolean canTakeItems(PlayerEntity player) {
                return !OliphauntEntity.hasTier2Chest();
            }

            @Override
            public int getMaxItemCount() {
                return 1;
            }
        });

        // Chest Slot Tier 2
        this.addSlot(new Slot(warturtleContainer, 3, 72, 45) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.CHEST) && OliphauntEntity.hasTier1Chest();
            }

            @Override
            public boolean canTakeItems(PlayerEntity player) {
                return !OliphauntEntity.hasTier3Chest();
            }

            @Override
            public int getMaxItemCount() {
                return 1;
            }
        });

        // Chest Slot Tier 3
        this.addSlot(new Slot(warturtleContainer, 4, 72, 63) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.CHEST) && OliphauntEntity.hasTier2Chest();
            }

            @Override
            public int getMaxItemCount() {
                return 1;
            }
        });

        if (columns > 0) {
            for (int l = 0; l < columns; l++) {
                this.addSlot(new Slot(warturtleContainer, 5 + l, 98 + l * 18, 27) {
                    @Override
                    public boolean isEnabled() {
                        return OliphauntEntity.hasTier1Chest();
                    }
                });
            }
            for (int l = 0; l < columns; l++) {
                this.addSlot(new Slot(warturtleContainer, 5 + l + columns, 98 + l * 18, 27 + 18){
                    @Override
                    public boolean isEnabled() {
                        return OliphauntEntity.hasTier2Chest();
                    }
                });
            }
            for (int l = 0; l < columns; l++) {
                this.addSlot(new Slot(warturtleContainer, 5 + l + 2 * columns, 98 + l * 18, 27 + 2 * 18){
                    @Override
                    public boolean isEnabled() {
                        return OliphauntEntity.hasTier3Chest();
                    }
                });
            }
        }


        for (int i1 = 0; i1 < 3; i1++) {
            for (int k1 = 0; k1 < 9; k1++) {
                this.addSlot(new Slot(inventory, k1 + i1 * 9 + 9, 8 + k1 * 18, 102 + i1 * 18 + -18));
            }
        }

        for (int j1 = 0; j1 < 9; j1++) {
            this.addSlot(new Slot(inventory, j1, 8 + j1 * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return !this.oliphaunt.areInventoriesDifferent(this.warturtleContainer) &&
                this.warturtleContainer.canPlayerUse(player) &&
                this.oliphaunt.isAlive() && player.canInteractWithEntity(this.oliphaunt, 4.0);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            int i = this.warturtleContainer.size() + 1;
            if (slot < i) {
                if (!this.insertItem(itemStack2, i, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(1).canInsert(itemStack2) && !this.getSlot(1).hasStack()) {
                if (!this.insertItem(itemStack2, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.getSlot(0).canInsert(itemStack2)) {
                if (!this.insertItem(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (i <= 1 || !this.insertItem(itemStack2, 2, i, false)) {
                int k;
                int j = i;
                int l = k = j + 27;
                int m = l + 9;
                if (slot >= l && slot < m ? !this.insertItem(itemStack2, j, k, false) : (slot >= j && slot < k ? !this.insertItem(itemStack2, l, m, false) : !this.insertItem(itemStack2, l, k, false))) {
                    return ItemStack.EMPTY;
                }
                return ItemStack.EMPTY;
            }
            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
        }
        return itemStack;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.warturtleContainer.onClose(player);
    }
}
