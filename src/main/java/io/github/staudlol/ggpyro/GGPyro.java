package io.github.staudlol.ggpyro;

/*
 * Created by Kyle
 * Project: gg-pyro
 * Date: 04/09/2022 - 01:20
 */

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid= "ggpyro", name = "GG Pyro", version = "1.0")
public class GGPyro {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        final EntityPlayer player = Minecraft.getMinecraft().player;
        final String message = event.getMessage();

        if (message.equalsIgnoreCase("gg pyro") || message.equalsIgnoreCase("ggpyro") || message.equalsIgnoreCase("ggpiro")) {
            event.setCanceled(true);

            player.sendMessage(new TextComponentString("Stop it.. get some help.")
                    .setStyle(
                            new Style()
                                    .setColor(TextFormatting.RED)
                                    .setBold(true)));

            event.setCanceled(true);
        }
    }
}
