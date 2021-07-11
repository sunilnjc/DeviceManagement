package com.axiom.devicemanagement.channel;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Project ms-skeleton
 * @Author Arab-Bank
 * @Date 2/3/19
 */

public interface GeneralChannel {

    MessageChannel messageChannel();

    SubscribableChannel subscribableChannel();

    SubscribableChannel subscribableChannelError();
}
