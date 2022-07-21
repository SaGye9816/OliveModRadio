package kr.sagyeradio;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GuiPacket implements IMessage {

    int radioNum;

    public GuiPacket() {

    }

    public GuiPacket(int radioNum) {
        this.radioNum = radioNum;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        radioNum = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(radioNum);
    }

    public static class PacketHandler implements IMessageHandler<GuiPacket, IMessage> {

        @Override
        public IMessage onMessage(GuiPacket message, MessageContext ctx) {

            ORadioMain.proxy.openGUI(message.radioNum);

            return null;
        }

    }
}
