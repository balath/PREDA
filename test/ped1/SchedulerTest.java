package ped1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class SchedulerTest {

    @InjectMocks
    private Scheduler scheduler;

    @Mock
    private ArgumentsReader argumentsReader;

    @BeforeEach
    public void inicializaMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getSchedule4Players() {
        when(argumentsReader.getNumOfPlayers()).thenReturn(4);
        when(argumentsReader.getPlayers()).thenReturn(null);
        when(argumentsReader.withTrace()).thenReturn(false);



    }
}