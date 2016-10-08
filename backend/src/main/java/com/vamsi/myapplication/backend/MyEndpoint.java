/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.vamsi.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.vamsi.com",
                ownerName = "backend.myapplication.vamsi.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that says a joke
     */
    @ApiMethod(name = "sayJoke")
    public MyBean sayJoke(MyBean bean){

        return bean;
    }

}
