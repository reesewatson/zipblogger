package com.zipcode.zipblogger;

import com.zipcode.zipblogger.Models.Shipwreck;
import com.zipcode.zipblogger.RESTControllers.ShipwreckController;
import com.zipcode.zipblogger.Repositories.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTests {

    //Once mock is injected, mockito is managing this object for you
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository sr;

    @Before
    public void initialize(){
        MockitoAnnotations.initMocks(this);
    }

    //The goal of this test is to get a shipwreck by id
    //Begin by instantiating the shipwreck controller and calling the get method on that controller
    @Test
    public void testShipwreckGet() {
        //We are creating an instantiation of shipwreck
        //Then we give this instance an id #
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);

        //Then we mock fetching the wreck from the database using the static method "when"
        when(sr.getOne(1L)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);
        assertEquals(1L, wreck.getId().longValue());
    }
}
