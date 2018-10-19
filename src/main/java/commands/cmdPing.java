package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class cmdPing implements Command{


    @Override
    public boolean called(String[] args, MessageReceivedEvent e) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent e) {
        e.getChannel().sendMessage("Pong").queue();
    }

    @Override
    public void executed(boolean succsess, MessageReceivedEvent e) {

    }

    @Override
    public String help() {
        return null;
    }
}
