package com.projects.jexxatutorials;

import com.projects.jexxatutorials.applicationservice.TimeApplicationService;
import com.projects.jexxatutorials.infrastructure.drivingadapter.messaging.TimeListener;
import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.messaging.JMSAdapter;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;

public final class TimeService
{
    public static void main(String[] args)
    {
        //Create your jexxaMain for this application
        var jexxaMain = new JexxaMain(TimeService.class);

        jexxaMain
                // Bind RESTfulRPCAdapter and JMXAdapter to TimeService class so that we can invoke its method
                .bind(RESTfulRPCAdapter.class).to(TimeApplicationService.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())

                // Bind the JMSAdapter to our TimeListener
                .bind(JMSAdapter.class).to(TimeListener.class)

                .run();
    }
}