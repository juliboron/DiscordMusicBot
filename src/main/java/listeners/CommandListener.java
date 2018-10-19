package listeners;

import core.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATICS;

public class CommandListener extends ListenerAdapter {


    public static void onMessageRecieved(MessageReceivedEvent e){

        if (e.getMessage().getContentRaw().startsWith(STATICS.PREFIX) && e.getMessage().getAuthor().getId() != e.getJDA().getSelfUser().getId()){
            CommandHandler.handleCommand(CommandHandler.parse.parser(e.getMessage().getContentRaw(), e));
        }



    }

}
