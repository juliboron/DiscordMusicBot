package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CmdPing implements Command{

    @Override
    public boolean called(String[] args, MessageReceivedEvent e) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent e) {
        e.getTextChannel().sendMessage("Pong!").queue();
    }

    @Override
    public void executed(boolean succsess, MessageReceivedEvent e) {
        System.out.println("[CMD]:  Command 'ping' wurde ausgeführt");
    }

    @Override
    public String help() {
        return null;
    }
}
