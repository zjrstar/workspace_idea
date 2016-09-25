package akka.dispatch;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by ZhendongHuang on 2016/9/2.
 */
public class PinnedDispatchTest {

    public static void main(String[] args){
        //Config config = ConfigFactory.parseString("akka.remote.netty.tcp.port=" + 2551)
        //        .withFallback(ConfigFactory.load("application.conf"));
        Config config = ConfigFactory.load("application.conf");

        ActorSystem system = ActorSystem.create("ClusterSystem", config);
        LoggingAdapter log = Logging.getLogger(system, new PinnedDispatchTest());
        ActorRef actor = system.actorOf(Props.create(MyActor.class).withDispatcher("my-pinned-dispatcher"), "actor");
        ActorRef actor1 = system.actorOf(Props.create(MyActor.class).withDispatcher("my-pinned-dispatcher"), "actor1");
        actor.tell("hello", actor);
        log.info(system.dispatcher().toString());

        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
