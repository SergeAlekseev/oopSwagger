package oop.controllers;


import oop.model.Response;
import oop.repositories.RepositoryOOP;
import oop.service.OOPService;
import oop.utils.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class Controller {

    RepositoryOOP repository;
    File file = new File("file.txt");
    List<String> list = new ArrayList<String>();
    OOPService service;

    @Autowired
    public void setRepository(RepositoryOOP repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/test1", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody double test, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;
            String res = service.light(test);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(res);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                repository.addTest(String.valueOf(test), String.valueOf(test));
            } catch (Exception e) {
                error = ErrorEnum.SYSTEM_ERROR;
                return ErrorEnum.createResponse(error);
            }

        return ErrorEnum.createResponse(error);
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody String test, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;
        String tmp="";
        test = service.roll(test, tmp);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(tmp, tmp);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody String[] Name, int[] time, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;

        String test = service.topSpeder(Name,time);

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(test, test);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }

    @RequestMapping(value = "/test4", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody String text) {
        ErrorEnum error = ErrorEnum.SUCCESS;
        String test = String.valueOf(service.isPalindrome(text));
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(test, test);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }
    @RequestMapping(value = "/test5", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody int day) {
        ErrorEnum error = ErrorEnum.SUCCESS;

        int[] tmp = service.day(day);
        String test = tmp[0] + " H, " + tmp[1] + " M, " + tmp[2] + " S";

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(test, test);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }

}