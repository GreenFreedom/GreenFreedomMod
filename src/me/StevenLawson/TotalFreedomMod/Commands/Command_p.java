package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.FOPM_TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "AdminChat - Talk privately with other admins. Using <command> itself will toggle AdminChat on and off for all messages.", usage = "/<command> [message...]", aliases = "senioradminchat")
public class Command_p extends TFM_Command {

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        if (args.length == 0) {
            if (senderIsConsole) {
                playerMsg("Only in-game players can toggle Senior Admin Chat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);

            if (userinfo.inAdminChat()) {
                userinfo.setAdminChat(!userinfo.inAdminChat());
            }

            if (userinfo.inDevChat()) {
                userinfo.setDevChat(!userinfo.inDevChat());
            }

            if (userinfo.inTelnetAdminChat()) {
                userinfo.setTelnetAdminChat(!userinfo.inTelnetAdminChat());
            }

            userinfo.setSeniorAdminChat(!userinfo.inSeniorAdminChat());
            playerMsg("Toggled Senior Admin Chat " + (userinfo.inSeniorAdminChat() ? "on" : "off") + ".");
        } else {
            FOPM_TFM_Util.SeniorAdminChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}
