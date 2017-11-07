package com.kodcu;
/*
 * Created by hakdogan on 04/11/2017
 */

import com.kodcu.controller.DropController;
import com.kodcu.controller.QueryController;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class AtlasTest {

    @Autowired
    private QueryController queryController;

    @Autowired
    private DropController dropController;

    @Test
    public void findDocuments() {
        assertNotNull(queryController.executeQuery("D"));
    }

    @Test
    public void dropCollections() {
        dropController.dropCollection();
        assertTrue(Integer.parseInt(queryController.executeQuery("D")) == 0);
    }
}
