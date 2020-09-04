package net.ultra03.noannoyingshields;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Items;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("noannoyingshields")
public class NoAnnoyingShields {

    private static final Logger LOGGER = LogManager.getLogger();

    public NoAnnoyingShields() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(FMLCommonSetupEvent event) {
        LOGGER.info("NoAnnoyingShields setup!");
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onHandRender(RenderHandEvent event) {
        if(event.getItemStack().getItem() == Items.SHIELD) {
            if(!Minecraft.getInstance().player.isHandActive())
                event.setCanceled(true);
        }
    }

}
