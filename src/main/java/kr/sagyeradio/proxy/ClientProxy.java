package kr.sagyeradio.proxy;

import kr.sagyeradio.sound.RadioSound;
import kr.sagyeradio.ui.gui.*;
import net.minecraft.client.Minecraft;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        FMLCommonHandler.instance().bus().register(this);
    }

    @Override
    public void openGUI(int radioNum) {
        Radio gui = null;
        switch (radioNum) {
            case 1:
                gui = new Radio1();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio1, 1.0F));
                break;
            case 2:
                gui = new Radio2();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio2, 1.0F));
                break;
            case 3:
                gui = new Radio3();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio3, 1.0F));
                break;
            case 4:
                gui = new Radio4();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio4, 1.0F));
                break;
            case 5:
                gui = new Radio5();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio5, 1.0F));
                break;
            case 6:
                gui = new Radio6();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio6, 1.0F));
                break;
            case 7:
                gui = new Radio7();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio7, 1.0F));
                break;
            case 8:
                gui = new Radio8();
                Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.radio8, 1.0F));
                break;
        }

        Radio finalGui = gui;
        Minecraft.getMinecraft().addScheduledTask(() -> Minecraft.getMinecraft().displayGuiScreen(finalGui));
    }

    @Override
    public void init() {
    }


}