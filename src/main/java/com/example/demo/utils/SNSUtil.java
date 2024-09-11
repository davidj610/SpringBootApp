package com.example.demo.utils;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

public class SNSUtil {

    public String publish(){

        String topicArn = "arn:aws:sns:us-east-1:423623832495:SNSToLambda";
        String msg = "{\"Key1\": \"Value1\", \"Key2\": \"Value2\"}";

        SnsClient snsClient = SnsClient.builder()
                .region(Region.US_EAST_1)
                .build();
        String result = pubTopic(snsClient, msg, topicArn);
        snsClient.close();
        return result;

    }

    public String pubTopic(SnsClient snsClient, String message, String topicArn) {

        try {
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .topicArn(topicArn)
                    .build();

            PublishResponse result = snsClient.publish(request);
            System.out.println(result.messageId() + " Message sent. Status is " + result.sdkHttpResponse().statusCode());

        } catch (SnsException e) {
            e.printStackTrace();
            return "<html><body>Error</body></html>";

        }

        return "<html><body>Success</body></html>";
    }
}
