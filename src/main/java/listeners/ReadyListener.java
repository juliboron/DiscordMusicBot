package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent e){

        String out = "\nThis bot is running on following Servers:  \n";

        for (Guild g : e.getJDA().getGuilds()) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);


        for (Guild g : e.getJDA().getGuilds()) {
            g.getTextChannels().get(0).sendMessage(
                "Hey im Back!"
            ).queue();
        }

    }
}
