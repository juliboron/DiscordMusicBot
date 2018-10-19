package listeners;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class VoiceListener extends ListenerAdapter {

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent e){
        e.getGuild().getTextChannelsByName("voicelog", true).get(0).sendMessage(
                "Member " + e.getVoiceState().getMember().getUser().getName() + " joined voice channel " + e.getChannelJoined().getName()
        ).queue();
    }

}
