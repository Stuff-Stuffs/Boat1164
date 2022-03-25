package io.github.stuff_stuffs.test1164.network;

import io.github.stuff_stuffs.test1164.entity.CustomBoatEntity;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public final class SpawnCustomBoatEntityPacketSender {
    public static final Identifier IDENTIFIER = new Identifier("your_mod", "spawn_boat");

    public static Packet<?> createSpawnPacket(final CustomBoatEntity boatEntity) {
        final PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeInt(boatEntity.getEntityId());
        buf.writeUuid(boatEntity.getUuid());
        buf.writeDouble(boatEntity.getX());
        buf.writeDouble(boatEntity.getY());
        buf.writeDouble(boatEntity.getZ());
        final Vec3d velocity = boatEntity.getVelocity();
        buf.writeDouble(velocity.x);
        buf.writeDouble(velocity.y);
        buf.writeDouble(velocity.z);
        buf.writeFloat(boatEntity.getPitch(1));
        buf.writeFloat(boatEntity.yaw);
        return ServerPlayNetworking.createS2CPacket(IDENTIFIER, buf);
    }

    private SpawnCustomBoatEntityPacketSender() {
    }
}
