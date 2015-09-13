package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Spy on commands", usage = "/<command> [on | off]", aliases = "commandspy")
public class Command_cmdspy extends TFM_Command {

    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole) {
        TFM_PlayerData playerdata = TFM_PlayerData.getPlayerData(sender_p);
        if (args.length == 0) {
            return false;
        } else if (args.length == 1) {
            if (args[0].equals("on")) {
                if (playerdata.cmdspyEnabled()) {
                    sender.sendMessage(ChatColor.RED + "CommandSpy is already enabled.");
                }
                playerdata.setCommandSpy(!playerdata.cmdspyEnabled());
                playerMsg("CommandSpy " + (playerdata.cmdspyEnabled() ? "enabled." : "disabled."));
                return true;
            }
            if (args[0].equals("off"))
            {
                if (!playerdata.cmdspyEnabled()) {
                    sender.sendMessage(ChatColor.RED + "CommandSpy is already disabled.");
                }
                playerdata.setCommandSpy(!playerdata.cmdspyEnabled());
                playerMsg("Command Spy " + (playerdata.cmdspyEnabled() ? "enabled." : "disabled."));
            }
            return false;
        }
        return true;
    }
}
