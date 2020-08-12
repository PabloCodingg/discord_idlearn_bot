package fr.pablo.bot.trigger.list;

import fr.pablo.bot.modules.autoevents.EventLauncher;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class MsgEvent {
    public MsgEvent(MessageReceivedEvent e) {
        if (e.getMember().getUser().equals(e.getJDA().getSelfUser())) return;

        if(e.getChannel().getIdLong() == EventLauncher.eventChannelID){
            EventLauncher.awnser(e);
            return;
        }

        if(e.getMessage().getContentRaw().toLowerCase().contains("discord.gg")){
            e.getMessage().delete().queue();
            e.getGuild().getTextChannelById(742372801628995615L).sendMessage(e.getAuthor().getAsMention() + " ["+e.getAuthor().getAsTag()+"] a tenté de faire une pub ```"+e.getMessage().getContentRaw()+"```").queue();
        }

    }
}
