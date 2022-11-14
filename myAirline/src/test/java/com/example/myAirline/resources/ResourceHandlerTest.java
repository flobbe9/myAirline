package com.example.myAirline.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.lowagie.text.DocumentException;


@SpringBootTest
@AutoConfigureMockMvc
public class ResourceHandlerTest {

    @Test
    void testHtmlToString() throws IOException {

        String testStr = ResourceHandler.htmlToString(ResourceHandler.HTML_ATTACHMENTS_PATH + "test.html", "!");  
          
        String actualHtml = "This is for the ResourceHandlerTest class. Please don't change the text!";

        assertEquals(actualHtml, testStr);
    }


    @Test
    void testStringToPdf() throws IOException, DocumentException {

        String path = ResourceHandler.PDF_ATTACHMENTS_PATH + "test.pdf";
        ResourceHandler.stringToPdf("This is the pdf text", ResourceHandler.PDF_ATTACHMENTS_PATH, "test.pdf");

        assertTrue(new File(path).exists());
    }
}