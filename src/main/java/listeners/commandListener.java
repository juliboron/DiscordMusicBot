package listeners;

import core.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATICS;

public class commandListener extends ListenerAdapter {


    public static void onMessageRecieved(MessageReceivedEvent event){

        if (event.getMessage().getContentRaw().startsWith(STATICS.PREFIX) && event.getMessage().getAuthor().isBot() == false){
            commandHandler.handleCommand(commandHandler.parse.parse(event.getMessage().getContentRaw(), event));
        }



    }

}
