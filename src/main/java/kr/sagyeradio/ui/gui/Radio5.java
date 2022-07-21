package kr.sagyeradio.ui.gui;

import kr.sagyeradio.sound.RadioSound;
import kr.sagyeradio.ui.RenderingHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;


public class Radio5 extends Radio {

    private boolean leftpreDown = false;

    private ResourceLocation bg = new ResourceLocation("olivemodradio", "textures/gui/5.png");
    private static final ResourceLocation slot = new ResourceLocation("olivemodradio", "textures/gui/out.png");

    public void initGui() {
    }

    @Override
    public void onGuiClosed()
    {
        Minecraft.getMinecraft().getSoundHandler().stopSounds();
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        if (keyCode == Keyboard.KEY_ESCAPE)
        {
            this.mc.displayGuiScreen(mc.currentScreen);
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        ScaledResolution scaledResolution = new ScaledResolution(mc);

        boolean leftdown = Mouse.isButtonDown(0);
        boolean leftb = false;

        if (leftdown) {
            if (!this.leftpreDown) {
                leftb = true;
            }
            this.leftpreDown = true;
        } else {
            this.leftpreDown = false;
        }

        int factor = scaledResolution.getScaleFactor();

        float bgx = 0;
        float bgy = 0;

        int mx = mouseX / 2;
        int my = mouseY / 2;

        this.bg = new ResourceLocation("olivemodradio", "textures/gui/5.png");
        RenderingHelper.drawTexture(bg, bgx, bgy, 1280/factor, 720/factor, 1.0F);

        float btx1 = bgx + 446.48F / 2.0F;
        float bty1 = bgx + 292.0F / 2.0F;

        float btx2 = btx1 + (313 / 4);
        float bty2 = bty1 + (124 / 4);;

        if (btx1 <= mx && mx <= btx2) { //왼쪽 버튼
            if (bty1 <= my && my <= bty2) {
                if (leftb) {
                    Minecraft.getMinecraft().getSoundHandler().stopSounds();
                    Minecraft.getMinecraft().player.closeScreen();
                    Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(RadioSound.page, 1.0F));
                }
                if (!leftdown) {
                    RenderingHelper.drawTexture(slot, btx1, bty1, 313/factor, 124/factor, 1.0F);
                }
            }
        }
    }
}


