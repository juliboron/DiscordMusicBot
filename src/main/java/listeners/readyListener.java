package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class readyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event){

        String out = "\n[readyListener]:    This bot is running on following Servers:  \n";

        for (Guild g : event.getJDA().getGuilds()) {
            out += "                    " + g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);


        for (Guild g : event.getJDA().getGuilds()) {
            g.getTextChannels().get(0).sendMessage(
                "Hey im Back!"
            ).queue();
        }


        System.out.println("[readyListener]:    Bot is ready");
    }
}
