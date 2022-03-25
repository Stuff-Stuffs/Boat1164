package io.github.stuff_stuffs.test1164.entity;

import io.github.stuff_stuffs.test1164.network.SpawnCustomBoatEntityPacketSender;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class CustomBoatEntity extends BoatEntity {
    public CustomBoatEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return SpawnCustomBoatEntityPacketSender.createSpawnPacket(this);
    }
}
