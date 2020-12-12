package com.mppfilereader.mppfilereader.web;

import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.mpp.MPPReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class fileReaderController {

    @GetMapping("/read")
    public static void readMppFile() throws MPXJException {
        MPPReader reader = new MPPReader();
        reader.setPreserveNoteFormatting(true);
        ProjectFile project = reader.read("E:\\Spring boot\\mpp-file-reader\\src\\main\\resources\\files\\sample.mpp");

        System.out.println("hi this is "+project);
        System.out.println("hi this is "+ project.getTables());
    }
}
