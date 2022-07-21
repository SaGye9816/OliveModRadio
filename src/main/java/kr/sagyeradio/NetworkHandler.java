package kr.sagyeradio;

import kr.sagyeradio.util.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


public class NetworkHandler {

    public static final SimpleNetworkWrapper handler = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

    public static void registerCode() {
        handler.registerMessage(GuiPacket.PacketHandler.class, GuiPacket.class, 00, Side.CLIENT);
    }

}
