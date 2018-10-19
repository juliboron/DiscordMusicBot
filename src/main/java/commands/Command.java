package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public interface Command {

    boolean called(String[] args, MessageReceivedEvent e);
    void action(String[] args, MessageReceivedEvent e);
    void executed(boolean succsess, MessageReceivedEvent e);
    String help();

}
