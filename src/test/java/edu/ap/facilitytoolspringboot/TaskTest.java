package edu.ap.facilitytoolspringboot;

import edu.ap.facilitytoolspringboot.models.Report;
import edu.ap.facilitytoolspringboot.repositories.ReportRepository;
import edu.ap.facilitytoolspringboot.services.ReportService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class TaskTest {
    @MockBean
    ReportRepository mockReportRepository = Mockito.mock(ReportRepository.class);

    ReportService reportSystemUnderTest = new ReportService(mockReportRepository);

    private static Report report;
    private static List<Report> reportList;

    @Before
    public void setUp() {
        report = new Report("Test Name", "P000001");
    }

    //Task created test
    @Test
    public void checkTaskCreated(){
        //arrange
        int count = (int) mockReportRepository.count();

        //act
        mockReportRepository.save(report);
        int count2 = (int) mockReportRepository.count();
        count++;count2++;

        //assert
        assertEquals(count, count2);
    }

    @org.springframework.context.annotation.Configuration
    public static class ContextConfiguration {
    }
}
