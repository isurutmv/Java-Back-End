package com.example.java_back.resource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import com.example.java_back.Domain.Client;
import com.example.java_back.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/client")
public class ClientResource {
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }
    @RequestMapping(value="/add/image", method=RequestMethod.POST)
    public ResponseEntity<String> upload(
            @RequestParam("id") Long id,
            HttpServletResponse response, HttpServletRequest request
    ){
        try {
            Client client = clientService.findOne(id);
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator<String> it = multipartRequest.getFileNames();
            MultipartFile multipartFile = multipartRequest.getFile(it.next());
            String fileName = id+".png";


            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/client/"+fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity<>("Upload Success!", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Upload failed!", HttpStatus.BAD_REQUEST);
        }
    }
}

