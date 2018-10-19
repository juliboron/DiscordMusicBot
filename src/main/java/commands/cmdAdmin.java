package commands;

import core.permsCore;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdAdmin implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent e) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent e) {

        if (!permsCore.check(e)){
            e.getTextChannel().sendMessage(
                    "Hello Master ;)"
            ).queue();
            return;
        }


    }

    @Override
    public void executed(boolean succsess, MessageReceivedEvent e) {

    }

    @Override
    public String help() {
        return null;
    }
}
