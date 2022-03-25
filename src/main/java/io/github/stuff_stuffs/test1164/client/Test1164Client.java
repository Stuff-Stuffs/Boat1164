package io.github.stuff_stuffs.test1164.client;

import io.github.stuff_stuffs.test1164.Test1164;
import io.github.stuff_stuffs.test1164.entity.CustomBoatEntity;
import io.github.stuff_stuffs.test1164.network.SpawnCustomBoatEntityPacketSender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import java.util.UUID;

@Environment(EnvType.CLIENT)
public class Test1164Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(SpawnCustomBoatEntityPacketSender.IDENTIFIER, (client, handler, buf, responseSender) -> {
            final int entityId = buf.readInt();
            final UUID uuid = buf.readUuid();
            final double x = buf.readDouble();
            final double y = buf.readDouble();
            final double z = buf.readDouble();
            final double xVelocity = buf.readDouble();
            final double yVelocity = buf.readDouble();
            final double zVelocity = buf.readDouble();
            final float pitch = buf.readFloat();
            final float yaw = buf.readFloat();
            final CustomBoatEntity boat = new CustomBoatEntity(Test1164.BOAT_ENTITY_TYPE, client.world);
            boat.setEntityId(entityId);
            boat.setUuid(uuid);
            boat.setPos(x, y, z);
            boat.setVelocity(xVelocity, yVelocity, zVelocity);
            boat.setYaw(yaw);
            boat.pitch = pitch;
            client.execute(() -> client.world.addEntity(entityId, boat));
        });
    }
}
