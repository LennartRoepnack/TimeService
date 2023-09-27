package com.projects.jexxatutorials.domainservice;

import io.jexxa.addend.applicationcore.InfrastructureService;

import java.time.LocalTime;

@InfrastructureService
public interface TimeDisplay
{
    void show(LocalTime localTime);
}
