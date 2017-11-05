package com.kodcu;
/*
 * Created by hakdogan on 04/11/2017
 */

import com.kodcu.controller.QueryController;
import org.junit.Test;
import static junit.framework.Assert.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Starter.class)
public class AtlasTest {

    @Autowired
    private QueryController queryController;

    @Test
    public void findDocuments() {
        assertNotNull(queryController.executeQuery("mongo"));
    }
}
