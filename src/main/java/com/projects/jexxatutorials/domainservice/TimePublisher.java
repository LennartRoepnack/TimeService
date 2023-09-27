package com.projects.jexxatutorials.domainservice;

import io.jexxa.addend.applicationcore.InfrastructureService;

import java.time.LocalTime;

@InfrastructureService
public interface TimePublisher
{
    void publish(LocalTime localTime);
}
