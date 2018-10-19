package listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import core.commandHandler;

public class commandListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        System.out.println(event.getMessage().getContentDisplay());

        if (event.getMessage().getContentRaw().startsWith("!") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            commandHandler.handleCommand(commandHandler.parser.parse(event.getMessage().getContentRaw(), event));
        }

    }

}
