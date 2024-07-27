package xyz.blobsu;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import xyz.blobsu.commands.OsuTop;
import xyz.blobsu.commands.commandLoader;
import xyz.blobsu.commands.osu;

import javax.security.auth.login.LoginException;

public class Main {

    private final ShardManager shardManager;


    public Main() throws LoginException {
        Dotenv dotenv = Dotenv.load();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(dotenv.get("DISCORD_TOKEN"));
        builder.setStatus(OnlineStatus.IDLE);
        builder.setActivity(Activity.customStatus("Try break me "));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.enableCache(CacheFlag.ONLINE_STATUS);
        shardManager = builder.build();

        shardManager.addEventListener(new commandLoader(), new osu(), new OsuTop());

    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {

        try {
            Main bot = new Main();
        } catch (LoginException e) {
            System.out.println("Error did not log in");
        }
    }


}