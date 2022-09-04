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

    private final String[] blockedWords = new String[] {
            "gg pyro",
            "ggpyro",
            "ggpiro",
            "gg piewo",
            "ggpiewo",
            "ez" // Let's just remove this, we aren't all 9 years old.
    };

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        final EntityPlayer player = Minecraft.getMinecraft().player;
        final String message = event.getMessage();

        for (String blockedWord : blockedWords) {
            if (message.equalsIgnoreCase(blockedWord)) {
                event.setCanceled(true);
                player.sendMessage(new TextComponentString("Stop it... get some help.")
                        .setStyle(
                                new Style()
                                        .setColor(TextFormatting.RED)
                                        .setBold(true)));
            }
        }
    }
}
