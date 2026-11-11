package com.example.spinhit;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;

public class SpinHitClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient()) return ActionResult.PASS;

            ClientPlayNetworkHandler handler = MinecraftClient.getInstance().getNetworkHandler();
            if (handler == null) return ActionResult.PASS;

            float yaw = player.getYaw();
            float pitch = player.getPitch();
            boolean onGround = player.isOnGround();
            boolean collided = player.horizontalCollision;

            // 180 turn
            handler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(
                    MathHelper.wrapDegrees(yaw + 180f), pitch, onGround, collided));
            // 180 back
            handler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(
                    yaw, pitch, onGround, collided));

            return ActionResult.PASS;
        });
    }
}
