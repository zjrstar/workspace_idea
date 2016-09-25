package akka.dispatch;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by ZhendongHuang on 2016/9/2.
 */
public class MyActor extends UntypedActor{
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Exception {
        log.info(message+"");
    }
}
