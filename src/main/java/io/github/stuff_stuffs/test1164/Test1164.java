package io.github.stuff_stuffs.test1164;

import io.github.stuff_stuffs.test1164.entity.CustomBoatEntity;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Test1164 implements ModInitializer {
    public static final EntityType<CustomBoatEntity> BOAT_ENTITY_TYPE = net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder.create(SpawnGroup.MISC, CustomBoatEntity::new).build();

    @Override
    public void onInitialize() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier("you_mod", "custom_boat"), BOAT_ENTITY_TYPE);
    }
}
