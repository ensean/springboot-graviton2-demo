package com.example.graviton2demo.services;

import com.example.graviton2demo.pojo.EchoInoPojo;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class EchoService {

    public String getRuntimeInfo(){
        Runtime rt = Runtime.getRuntime();
        return rt.toString();
    }

    public EchoInoPojo getEchoInfo(){
        EchoInoPojo echoInoPojo = new EchoInoPojo();
        echoInoPojo.setRuntime(getRuntimeInfo());
        echoInoPojo.setInstanceAZ(EC2MetadataUtils.getAvailabilityZone());
        echoInoPojo.setInstanceId(EC2MetadataUtils.getInstanceId());
        echoInoPojo.setInstanceType(EC2MetadataUtils.getInstanceType());
        return echoInoPojo;
    }
}
