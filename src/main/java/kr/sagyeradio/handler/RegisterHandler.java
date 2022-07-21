package kr.sagyeradio.handler;


import kr.sagyeradio.sound.RadioSound;
import kr.sagyeradio.util.Reference;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class RegisterHandler {
    @SubscribeEvent
    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
        final SoundEvent[] soundEvents = {
                RadioSound.page,
                RadioSound.radio1,
                RadioSound.radio2,
                RadioSound.radio3,
                RadioSound.radio4,
                RadioSound.radio5,
                RadioSound.radio6,
                RadioSound.radio7,
                RadioSound.radio8,
        };
        event.getRegistry().registerAll(soundEvents);
    }
}
