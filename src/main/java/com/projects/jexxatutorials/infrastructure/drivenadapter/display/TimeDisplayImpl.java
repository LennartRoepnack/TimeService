package com.projects.jexxatutorials.infrastructure.drivenadapter.display;
import com.projects.jexxatutorials.domainservice.TimeDisplay;
import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.common.wrapper.logger.SLF4jLogger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@DrivenAdapter
@SuppressWarnings("unused")
public class TimeDisplayImpl implements TimeDisplay
{
    @Override
    public void show(LocalTime localTime)
    {
        var messageWithPublishedTime = "New Time was published, time: " + localTime.format(DateTimeFormatter.ISO_TIME);
        SLF4jLogger.getLogger(TimeDisplayImpl.class).info(messageWithPublishedTime);
    }
}
