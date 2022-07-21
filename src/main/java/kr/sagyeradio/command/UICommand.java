package kr.sagyeradio.command;

import kr.sagyeradio.GuiPacket;
import kr.sagyeradio.NetworkHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class UICommand extends CommandBase {

    @Override
    public String getName() {
        return "radio";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "command.radio.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (!(sender instanceof EntityPlayerMP)) {
            String msg = "콘솔에서 사용 가능한 명령어가 아닙니다.";
            TextComponentString Text = new TextComponentString(msg);
            Text.getStyle().setColor(TextFormatting.RED);
            sender.sendMessage(Text);

            return;
        }
        if (args != null && args.length >= 0 && args.length != 1) {
            String msg = "사용법 : /radio <일차>";
            TextComponentString Text = new TextComponentString(msg);
            Text.getStyle().setColor(TextFormatting.AQUA);
            sender.sendMessage(Text);
        } else if (args != null && args.length == 1) {
            String radioPage = args[0]; // 상점번호
            int radioNum = Integer.parseInt(radioPage);
            if (radioNum < 1 || radioNum > 9) {
                String msg = "올바른 라디오 일차를 입력해주세요";
                TextComponentString Text = new TextComponentString(msg);
                Text.getStyle().setColor(TextFormatting.AQUA);
                sender.sendMessage(Text);
            } else {

                NetworkHandler.handler.sendTo(new GuiPacket(radioNum), (EntityPlayerMP) sender);
            }

        }
//        GGMain.proxy.commandHandler(server, sender, args);
    }


}
