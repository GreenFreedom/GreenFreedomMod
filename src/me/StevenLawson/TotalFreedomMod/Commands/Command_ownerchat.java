package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.FOPM_TFM_Util;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OWNER, source = SourceType.BOTH)
@CommandParameters(
        description = "Owner Chat - Used for Owners to talk privatly. Using <command> itself will toggle Owner Chat on and off for all messages.",
        usage = "/<command> [message...]",
        aliases = "oc")
public class Command_ownerchat extends TFM_Command
{
  /*********************************
   * A msg from the RFM Developers *
   * You may NOT Copy any Commands *
   * From the RFM, Any Commands    *
   * found Copied, Your server will*
   * be infront of a DCMA threat.  *
   *********************************/
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            if (senderIsConsole)
            {
                playerMsg("Only in-game players can toggle OwnerChat.");
                return true;
            }

            TFM_PlayerData userinfo = TFM_PlayerData.getPlayerData(sender_p);

            if (userinfo.inAdminChat())
            {
                userinfo.setAdminChat(!userinfo.inAdminChat());
            }

            if (userinfo.inSeniorAdminChat())
            {
                userinfo.setSeniorAdminChat(!userinfo.inSeniorAdminChat());
            }
            if (userinfo.inOwnerChat())
            {
                userinfo.setOwnerChat(!userinfo.inAdminChat());
            }

            userinfo.setOwnerChat(!userinfo.inOwnerChat());
            playerMsg("Toggled Owner Chat " + (userinfo.inOwnerChat() ? "on" : "off") + ".");
        }
        else
        {
            FOPM_TFM_Util.OwnerChatMessage(sender, StringUtils.join(args, " "), senderIsConsole);
        }

        return true;
    }
}
