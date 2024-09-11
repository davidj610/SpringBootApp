package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;

import java.nio.charset.StandardCharsets;

import java.util.List;


@RestController
@RequestMapping("/course")
public class CourseController {

    //private CourseServiceImpl courseService;

    //public CourseController(@Autowired CourseServiceImpl courseService){
        //this.courseService = courseService;
    //}

    @GetMapping
    public String getCourse(String name){

        System.out.println("in getCourse..");

        String functionName = "JavaHelloFunction";
        String jsonString = "{\"Key1\": \"Value1\", \"Key2\": \"Value2\"}";

        InvokeRequest invokeRequest = new InvokeRequest()
                .withFunctionName(functionName)
                .withPayload(jsonString);

        InvokeResult invokeResult = null;
        String ans = "";
        try {
            AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                    //.withCredentials(new ProfileCredentialsProvider())
                    .withRegion(Regions.US_EAST_1).build();

            invokeResult = awsLambda.invoke(invokeRequest);

            ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

            //write out the return value
            System.out.println(ans);


        } catch (ServiceException e) {
            System.out.println(e);
            return "<html><body>Error</body></html>";
        }

        System.out.println(invokeResult.getStatusCode());

        return "<html><body>" + ans + "</body></html>";

        /*
        Optional opt = courseService.getCourse("Philosophy 101");
        if(opt.isPresent()) {
            Course course = (Course) opt.get();
            System.out.println("Course: " + course.getName());
            return "<html><body>" + course.getName() + "</body></html>";
        }
        System.out.println("Not present");
        return "<html><body>not present</body></html>";

         */

    }

    public List getCourses(){
        return null;

    }


}