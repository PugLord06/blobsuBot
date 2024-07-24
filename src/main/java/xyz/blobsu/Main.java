package xyz.blobsu;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;
import xyz.blobsu.commands.OsuTop;
import xyz.blobsu.commands.commandLoader;
import xyz.blobsu.commands.osu;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    Dotenv dotenv = Dotenv.load();
    private final ShardManager shardManager;

    private final String[] gamemodes = new String[]{"std", "taiko", "ctb", "mania", "rxStd", "rxTaiko"
            , "rxCatch", "rxMania", "autoStd", "autoTaiko", "autoCatch", "autoMania"};


    public Main() throws LoginException {
        Dotenv dotenv = Dotenv.load();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(dotenv.get("DISCORD_TOKEN"));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.watching(" over Blobsu"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES,GatewayIntent.GUILD_MEMBERS,GatewayIntent.GUILD_PRESENCES);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableCache(CacheFlag.ONLINE_STATUS);
        shardManager= builder.build();

        shardManager.addEventListener(new commandLoader() ,new osu(),new OsuTop());

    }

    public ShardManager getShardManager(){
        return shardManager;
    }

    public static void main(String[] args) {

        try {
            Main bot = new Main();
        } catch (LoginException e){
            System.out.println("Error did not log in");
        }
    }


}