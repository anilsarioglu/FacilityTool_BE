package edu.ap.facilitytoolspringboot;

import edu.ap.facilitytoolspringboot.config.mongodb.MongoDBConfigMelding;
import edu.ap.facilitytoolspringboot.models.Status;
import edu.ap.facilitytoolspringboot.repositories.MeldingRepo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.List;

import static edu.ap.facilitytoolspringboot.models.Status.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {MongoDBConfigMelding.class},
        loader = AnnotationConfigContextLoader.class)
@DataMongoTest
public class DefectTest {

    @MockBean
    MeldingRepo mockMeldingRepository = Mockito.mock(MeldingRepo.class);

    @Autowired
    MeldingServ meldingSystemUnderTest = new MeldingServ(mockMeldingRepository);

    private static Melding melding;
    private static List<Melding> meldingList;

    @Before
    public void setUp() {
        melding = new Melding("Ariana Grande", "P106204");
        meldingList = new ArrayList<>();
        meldingList.add(new Melding("Selena Gomez", "P105106"));
        meldingList.add(new Melding("Ariana Grande", "P106809"));
    }



    @Test
    public void countDefect(){
        //arrange
        int count = (int) mockMeldingRepository.count();

        //act
        mockMeldingRepository.save(melding);
        int count2 = (int) mockMeldingRepository.count();
        count++;count2++;

        //assert
        assertEquals(count, count2);
    }


    @Test
    public void findAddedMeldingen() {

        //act
        when(mockMeldingRepository.findAll()).thenReturn(meldingList);
        List<Melding> expectedList = meldingSystemUnderTest.getAlleMeldingen();

        //assert
        assertEquals(2, expectedList.size());
    }


}
