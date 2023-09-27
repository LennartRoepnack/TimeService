package com.projects.jexxatutorials.infrastructure.drivingadapter.messaging;

import com.projects.jexxatutorials.applicationservice.TimeApplicationService;
import io.jexxa.addend.infrastructure.DrivingAdapter;
import io.jexxa.drivingadapter.messaging.JMSConfiguration;
import io.jexxa.drivingadapter.messaging.listener.TypedMessageListener;

import java.time.LocalTime;

import static io.jexxa.drivingadapter.messaging.JMSConfiguration.MessagingType.TOPIC;

/**
 * 1. Within the constructor we define our class from the application core that will be called. Jexxa automatically
 * injects this object when creating the port adapter. By convention, this is the only object defined in the
 * constructor.
 * <p>
 * 2. In case of JMS we have to implement the JMS specific `MessageListener` interface. To facilitate this, Jexxa offers
 * convenience classes such as TypedMessageListener which perform JSON deserialization into a defined type.
 * <p>
 * 3. The JMS specific connection information is defined as annotation at the onMessage method.
 * <p>
 * 4. Finally, the implementation of this method just forwards received data to the application service.
 */
@DrivingAdapter
@SuppressWarnings("unused")
public final class TimeListener extends TypedMessageListener<LocalTime> {
    private final TimeApplicationService timeApplicationService;
    private static final String TIME_TOPIC = "TimeService";

    public TimeListener(TimeApplicationService timeApplicationService) {
        super(LocalTime.class);
        this.timeApplicationService = timeApplicationService;
    }

    @Override
    // The JMS specific configuration is defined via annotation.
    @JMSConfiguration(destination = TIME_TOPIC,  messagingType = TOPIC)
    public void onMessage(LocalTime localTime) {
        // Forward this information to corresponding application service.
        timeApplicationService.showReceivedTime(localTime);
    }
}
