package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.BOTH)
@CommandParameters(description = "RubyFreedomMod Licenseing Information", aliases = "rfmlicense", usage = "/<command>")
public class Command_license extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        TFM_Util.playerMsg(sender_p, "RubyFreedomMod License", ChatColor.GOLD);
        // It isn't closed source dumbass if it's uploaded to github.
        TFM_Util.playerMsg(sender_p, "The RubyFreedomMod is a plugin that only the owner and the certified RFM developers can edit.", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "If you wish to use the plugin on your server, you must give credit to tylerhyperHD and DarkGamingDronze as they are the RFM Creators.", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "In buildcreator.properties and buildcreator.defualt.properties you cannot change any RubyFreedom Developers names in there as they are the RFM creators and that will violate our License.", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "Also you cannot remove/edit the /rfm, /optroll, /tfm or /license commands", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "The RubyFreedomMod cannot be distributed by anyone else but the Owner or the RFM Developers and can only be uploaded on github and not anyother file sharing sites.", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "You can change the RubyFreedomMod name in plugin.yml BUT you must not change or remove anything that shows the RFM Creator and Developers", ChatColor.AQUA);
        TFM_Util.playerMsg(sender_p, "Thank you for reading this and enjoy our plugin! - RubyFreedomMod Developers", ChatColor.GREEN);
        return true;
    }
}
