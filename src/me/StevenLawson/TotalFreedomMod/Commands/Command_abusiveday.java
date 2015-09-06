package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Log;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Start a abusive day", usage = "/<command> [on | off]", aliases = "tm")
public class Command_abusiveday extends TFM_Command
{
// *********************************
// * A msg from the RFM Developers *
// * You may NOT Copy any Commands *
// * From the RFM, Any Commands    *
// * Found Copied, Your server will*
// * be infront of a DCMA threat.  *
// *********************************   

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (!sender.getName().equals("tylerhyperHD") && !sender.getName().equals("DarkGamingDronze"))
        {
            // This is a secret command, other members from the staff list knowing this may result into a command wipe.
            // ~Dark
            sender.sendMessage("Unknown command. Type \"/help\" for help.");
            return true;
        }
        if (args.length != 1)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("off -s"))
        {
            TFM_ConfigEntry.ABUSIVE_DAY.setBoolean(false);
            TFM_ConfigEntry.ADMIN_ONLY_MODE.setBoolean(false);
            TFM_ConfigEntry.ABUSIVE_DAY.setBoolean(false);
            return true;
        }

        if (args[0].equalsIgnoreCase("off"))
        {
            TFM_ConfigEntry.ABUSIVE_DAY.setBoolean(false);
            TFM_ConfigEntry.ADMIN_ONLY_MODE.setBoolean(false);
            TFM_ConfigEntry.ABUSIVE_DAY.setBoolean(false);
            TFM_Util.adminAction(sender.getName(), "Stopping the abusive day...", true);
            return true;
        }
        else if (args[0].equalsIgnoreCase("on"))
        {
            TFM_ConfigEntry.ABUSIVE_DAY.setBoolean(true);
            TFM_ConfigEntry.ADMIN_ONLY_MODE.setBoolean(true);
            TFM_ConfigEntry.ABUSIVE_DAY.setBoolean(true);
            TFM_Util.adminAction(sender.getName(), "Starting the abusive day...", ChatColor.RED);
            TFM_Util.bcastMsg("*****************************************************", ChatColor.RED);
            TFM_Util.bcastMsg("* WARNING: RubyFreedom Will start Abusvie Day!      *", ChatColor.RED);
            TFM_Util.bcastMsg("* This might result in unexpected behaviour...      *", ChatColor.RED);
            TFM_Util.bcastMsg("* - - - - - - - - - - - - - - - - - - - - - - - - - *", ChatColor.RED);
            TFM_Util.bcastMsg("* Admins Now can abuse thier powers only in-game!!  *", ChatColor.RED);
            TFM_Util.bcastMsg("*          Beaware! This might be harsh!            *", ChatColor.RED);
            TFM_Util.bcastMsg("*****************************************************", ChatColor.RED);
            TFM_Util.bcastMsg("     ", ChatColor.BLACK);
            TFM_Util.bcastMsg("     ", ChatColor.BLACK);
            TFM_Util.bcastMsg("     ", ChatColor.BLACK);
            TFM_Util.bcastMsg("Abusive day rules:", ChatColor.YELLOW);
            TFM_Util.bcastMsg("[1] You may not abuse on the Owners/Chief dev.", ChatColor.RED);
            TFM_Util.bcastMsg("[2] If the Owner/Chief dev says to stop abusing you need to stop now.", ChatColor.RED);
            for (Player player : server.getOnlinePlayers())
            {
                if (!TFM_AdminList.isSuperAdmin(player))
                {
                    player.kickPlayer("RubyFreedom now started abusive day, relog in 1 hour.");
                }
                
            }
            return true;
        }

        return false;
    }
}
